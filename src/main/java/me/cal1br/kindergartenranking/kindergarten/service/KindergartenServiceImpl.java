package me.cal1br.kindergartenranking.kindergarten.service;

import me.cal1br.kindergartenranking.child.model.ChildModel;
import me.cal1br.kindergartenranking.child.repository.ChildRepository;
import me.cal1br.kindergartenranking.kindergarten.model.KindergartenModel;
import me.cal1br.kindergartenranking.kindergarten.repository.KindergartenRepository;
import me.cal1br.kindergartenranking.parent.model.ParentModel;
import me.cal1br.kindergartenranking.parent.repository.ParentRepository;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class KindergartenServiceImpl implements KindergartenService {
    private final ParentRepository parentRepository;
    private final ChildRepository childRepository;
    private final KindergartenRepository kindergartenRepository;

    public KindergartenServiceImpl(final ParentRepository parentRepository, final ChildRepository childRepository, final KindergartenRepository kindergartenRepository) {
        this.parentRepository = parentRepository;
        this.childRepository = childRepository;
        this.kindergartenRepository = kindergartenRepository;
    }

    @Override
    public Map<KindergartenModel, List<ChildModel>> rankChildren(final List<KindergartenModel> kindergartenList, final List<ChildModel> childList) {
        final Map<KindergartenModel, List<ChildModel>> rankedChildren = new HashMap<>();
        final List<ChildModel> leftoverChildren = new LinkedList<>(); // kicknati които влизат отново в класирането
        do {
            leftoverChildren.clear();
            kindergartenList.forEach(kindergarten -> {
                final List<ChildModel> childrenForThisGarden = childList.stream()
                        .filter(child -> child.getWishList().get(0).equals(kindergarten))
                        .collect(Collectors.toList());
                childrenForThisGarden.addAll(kindergarten.getStudents());// adding previous children, if any
                final List<ChildModel> acceptedChildren = rankChildrenForKindergarten(kindergarten, childrenForThisGarden);
                childrenForThisGarden.removeAll(acceptedChildren);
                rankedChildren.put(kindergarten, acceptedChildren);
                leftoverChildren.addAll(childrenForThisGarden);
            });
            leftoverChildren.parallelStream().forEach(leftoverChild -> {
                if (!leftoverChild.getWishList().isEmpty()) {
                    leftoverChild.getWishList().remove(0);
                } else {
                    leftoverChildren.remove(leftoverChild); //no wishlist left
                }
            });
        } while (!leftoverChildren.isEmpty());
        return rankedChildren;
    }

    @Override
    public List<KindergartenModel> findAll() {
        return this.kindergartenRepository.getAll();
    }

    private List<ChildModel> rankChildrenForKindergarten(final KindergartenModel kindergarten, final List<ChildModel> childModelList) {
        final Map<Integer, ChildModel> map = new HashMap<>();
        childModelList.parallelStream().forEach(child ->
                map.put(calculateChildPoints(kindergarten.getId(), child), child)
        );
        List<Integer> sortedIds = map.keySet().stream().limit(kindergarten.getPlaces()).sorted().collect(Collectors.toList());
        return sortedIds.stream().map(map::get).collect(Collectors.toList());
    }

    private int calculateChildPoints(long kindergartenId, final ChildModel child) {
        int points = 0;//осъществява по точков принцип.
        if (child.isDisabled()) points += 2; //За дете с увреждане 2 точки
        final List<ParentModel> parents = parentRepository.getParentsByChild(child);
        for (final ParentModel parent : parents) {
            if (parent.getWorkplace() != null) points++; //За всеки работещ родител по 1 точка.
        }
        final List<ChildModel> twins = childRepository.getTwinsOf(child);
        points += twins.size(); //За близнаци 1
        points += kindergartenRepository.getSiblingsOf(kindergartenId, child).size(); //За брат/сестра в детското заведение 1т.
        return points;
    }
}

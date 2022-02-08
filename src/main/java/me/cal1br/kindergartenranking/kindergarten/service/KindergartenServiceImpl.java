package me.cal1br.kindergartenranking.kindergarten.service;

import me.cal1br.kindergartenranking.child.model.ChildModel;
import me.cal1br.kindergartenranking.child.repository.ChildRepository;
import me.cal1br.kindergartenranking.kindergarten.model.KindergartenModel;
import me.cal1br.kindergartenranking.kindergarten.repository.KindergartenRepository;
import me.cal1br.kindergartenranking.parent.model.ParentModel;
import me.cal1br.kindergartenranking.parent.repository.ParentRepository;

import java.util.HashMap;
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
    public List<ChildModel> rankChildren(final KindergartenModel kindergarten, final List<ChildModel> childModelList) {
        final Map<Integer, ChildModel> map = new HashMap<>();
        childModelList.parallelStream().forEach(child -> {
            map.put(calculateChildPoints(kindergarten.getId(), child), child);
        });
        List<Integer> sortedIds = map.keySet().stream().limit(kindergarten.getPlaces()).sorted().collect(Collectors.toList());
        return sortedIds.stream().map(map::get).collect(Collectors.toList());
    }

    @Override
    public int calculateChildPoints(long kindergartenId, final ChildModel child) {
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

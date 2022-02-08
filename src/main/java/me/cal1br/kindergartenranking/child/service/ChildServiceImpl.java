package me.cal1br.kindergartenranking.child.service;

import me.cal1br.kindergartenranking.child.model.ChildModel;
import me.cal1br.kindergartenranking.child.repository.ChildRepository;
import me.cal1br.kindergartenranking.kindergarten.repository.KindergartenRepository;
import me.cal1br.kindergartenranking.parent.model.ParentModel;
import me.cal1br.kindergartenranking.parent.repository.ParentRepository;

import java.util.List;

public class ChildServiceImpl implements ChildService {
    private final ParentRepository parentRepository;
    private final ChildRepository childRepository;
    private final KindergartenRepository kindergartenRepository;

    public ChildServiceImpl(final ParentRepository parentRepository, final ChildRepository childRepository, final KindergartenRepository kindergartenRepository) {
        this.parentRepository = parentRepository;
        this.childRepository = childRepository;
        this.kindergartenRepository = kindergartenRepository;
    }

    @Override
    public int calculateChildPoints(long kindergartenId, final ChildModel child) {
        int points = 0;//осъществява по точков принцип.
        if (child.isDisabled()) points += 2; //За дете с увреждане 2 точки
        final List<ParentModel> parents = parentRepository.getParentsByChild(child);
        for (final ParentModel parent : parents) {
            if (parent.getWorkplace() != null) points++;//За всеки работещ родител по 1 точка.
        }
        final List<ChildModel> twins = childRepository.getTwinsOf(child);
        points += twins.size(); //За близнаци 1
        points += kindergartenRepository.getSiblingsOf(kindergartenId, child).size(); //За брат/сестра в детското заведение 1т.
        return points;
    }
}
package me.cal1br.kindergartenranking.child.service;

import me.cal1br.kindergartenranking.child.model.ChildModel;
import me.cal1br.kindergartenranking.child.repository.ChildRepository;
import me.cal1br.kindergartenranking.parent.model.ParentModel;
import me.cal1br.kindergartenranking.parent.repository.ParentRepository;

import java.util.List;

public class ChildServiceImpl implements ChildService {
    private final ParentRepository parentRepository;
    private final ChildRepository childRepository;

    public ChildServiceImpl(final ParentRepository parentRepository, final ChildRepository childRepository) {
        this.parentRepository = parentRepository;
        this.childRepository = childRepository;
    }

    @Override
    public int calculateChildPoints(final ChildModel child) {
        int points = 0;
        if (child.isDisabled()) points += 2;
        final List<ParentModel> parents = parentRepository.getParentsByChild(child);
        for (final ParentModel parent : parents) {
            if (parent.getWorkplace() != null) points++;
        }
        List<ChildModel> twins = childRepository.getTwinsOf(child);
        for (final ChildModel twin : twins) {
            points++;
        }

        //TODO Класирането ще се
        //осъществява по точков принцип.
        //За всеки работещ родител по 1 точка.
        //За дете с увреждане 2 точки
        //За близнаци 1
        //За брат/сестра в детското заведение 1т.
        //При деца с еднакви точки класирането е на случаен принцип.
        return 0;
    }
}

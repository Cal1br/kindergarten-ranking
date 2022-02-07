package me.cal1br.kindergartenranking.parent.repository;

import me.cal1br.kindergartenranking.base.repository.AbstractBaseRepositoryImpl;
import me.cal1br.kindergartenranking.child.model.ChildModel;
import me.cal1br.kindergartenranking.parent.model.ParentModel;

import java.util.List;
import java.util.stream.Collectors;

public class ParentRepositoryImpl extends AbstractBaseRepositoryImpl<ParentModel> implements ParentRepository {
    @Override
    protected boolean verifyModel(final ParentModel model) {
        //TODO
        return true;
    }

    @Override
    public List<ParentModel> getParentsByChild(final ChildModel child) {
        return getDatabaseDummy()
                .values()
                .parallelStream()
                .filter(parent -> parent.getParentOf().equals(child))
                .collect(Collectors.toList());
    }
}

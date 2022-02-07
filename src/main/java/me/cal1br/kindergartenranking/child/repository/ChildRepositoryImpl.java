package me.cal1br.kindergartenranking.child.repository;

import me.cal1br.kindergartenranking.base.repository.AbstractBaseRepositoryImpl;
import me.cal1br.kindergartenranking.child.model.ChildModel;

public class ChildRepositoryImpl extends AbstractBaseRepositoryImpl<ChildModel> implements ChildRepository {
    @Override
    protected boolean verifyModel(final ChildModel model) {
        //TODO
        return true;
    }
}

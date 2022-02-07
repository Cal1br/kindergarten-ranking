package me.cal1br.kindergartenranking.parent.repository;

import me.cal1br.kindergartenranking.base.repository.AbstractBaseRepositoryImpl;
import me.cal1br.kindergartenranking.base.repository.BaseRepository;
import me.cal1br.kindergartenranking.parent.model.ParentModel;

public class ParentRepositoryImpl extends AbstractBaseRepositoryImpl<ParentModel> implements ParentRepository {
    @Override
    protected boolean verifyModel(final ParentModel model) {
        //TODO
        return true;
    }
}

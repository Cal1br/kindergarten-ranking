package me.cal1br.kindergartenranking.kindergarten.repository;

import me.cal1br.kindergartenranking.base.repository.AbstractBaseRepositoryImpl;
import me.cal1br.kindergartenranking.kindergarten.model.KindergartenModel;

public class KindergartenRepositoryImpl extends AbstractBaseRepositoryImpl<KindergartenModel> implements KindergartenRepository {
    @Override
    protected boolean verifyModel(final KindergartenModel model) {
        //TODO
        return true;
    }
}

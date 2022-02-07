package me.cal1br.kindergartenranking.administrator.repository;

import me.cal1br.kindergartenranking.administrator.model.AdministratorModel;
import me.cal1br.kindergartenranking.base.repository.AbstractBaseRepositoryImpl;

public class AdministratorRepositoryImpl extends AbstractBaseRepositoryImpl<AdministratorModel> implements AdministratorRepository {

    @Override
    protected boolean verifyModel(final AdministratorModel model) {
        return false;
    }
}

package me.cal1br.kindergartenranking.administrator.repository;

import me.cal1br.kindergartenranking.administrator.model.AdministratorModel;
import me.cal1br.kindergartenranking.base.repository.AbstractBaseRepositoryImpl;
import me.cal1br.kindergartenranking.util.exception.InvalidInputException;

import java.util.HashMap;
import java.util.Optional;

public class AdministratorRepositoryImpl extends AbstractBaseRepositoryImpl<AdministratorModel> implements AdministratorRepository {

    private static final HashMap<Long, AdministratorModel> databaseDummy = new HashMap<>();
    private static final int idCount = 0;

    @Override
    public Optional<AdministratorModel> findByUsername(final String name) {
        return databaseDummy.values().parallelStream().filter(potentialAdmin -> potentialAdmin.getUsername().equals(name)).findAny();
    }

    @Override
    public Optional<AdministratorModel> findById(final Long id) {
        if (id == null) {
            throw new InvalidInputException("Id cannot be null");
        }
        return Optional.ofNullable(databaseDummy.get(id));
    }


    /**
     * @return true if model is verified, false if it is not.
     */
    private boolean verification(final AdministratorModel model) {

    }
}

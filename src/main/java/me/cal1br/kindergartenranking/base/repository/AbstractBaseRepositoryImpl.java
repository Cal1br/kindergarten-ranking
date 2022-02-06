package me.cal1br.kindergartenranking.base.repository;

import me.cal1br.kindergartenranking.administrator.model.BaseModel;
import me.cal1br.kindergartenranking.util.exception.InvalidInputException;
import me.cal1br.kindergartenranking.util.exception.InvalidModelException;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public abstract class AbstractBaseRepositoryImpl<T extends BaseModel> implements BaseRepository<T> {
    private final HashMap<Long, T> databaseDummy = new HashMap<>();
    private long idCount = 0;

    @Override
    public Optional<T> findByName(final String name) {
        return databaseDummy.values().parallelStream().filter(obj -> obj.getName().equals(name)).findAny();
    }

    @Override
    public Optional<T> findById(final Long id) {
        if (id == null) {
            throw new InvalidInputException("Id cannot be null");
        }
        return Optional.ofNullable(databaseDummy.get(id));
    }

    /**
     * @return returns the id of the saved model.
     */
    @Override
    public long save(final T model) {
        if (model == null) {
            throw new InvalidModelException("Model cannot be null");
        }
        if (!verifyModel(model)) {
            throw new InvalidModelException("Invalid model");
        }
        this.databaseDummy.put(idCount, model);
        return idCount++; //post-increment, thus it returns the correct id
    }

    @Override
    public boolean editById(final Long id, final T model) {
        return false;
    }

    /**
     * Used to verify a model. Clients of this class can get access to the entries
     * in the database with {@link #getDatabaseDummy()}
     *
     * @return return false if model is invalid, true if it is valid.
     */
    protected abstract boolean verifyModel(T model);

    /**
     * Used to get an unmodifiable version of the database.
     *
     * @return returns a wrapped reference to the database, that has input methods disabled.
     */
    protected Map<Long, T> getDatabaseDummy() {
        return Collections.unmodifiableMap(this.databaseDummy);
    }
}

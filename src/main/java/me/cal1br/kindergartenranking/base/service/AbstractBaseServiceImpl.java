package me.cal1br.kindergartenranking.base.service;

import me.cal1br.kindergartenranking.administrator.model.BaseModel;
import me.cal1br.kindergartenranking.base.repository.BaseRepository;
import me.cal1br.kindergartenranking.util.exception.InvalidInputException;

import java.util.List;
import java.util.Optional;

public abstract class AbstractBaseServiceImpl<T extends BaseModel> implements BaseService<T> {

    @Override
    public List<T> findAll() {
        return this.getRepository().findAll();
    }

    @Override
    public T findById(final long id) {
        final Optional<T> byId = this.getRepository().findById(id);
        if (!byId.isPresent()) {
            throw new InvalidInputException("No such object with id: " + id);
        }
        return byId.get();
    }

    @Override
    public long save(final T model) {
        return getRepository().save(model);
    }

    @Override
    public T editById(final Long id, final T model) {
        return getRepository().editById(id, model);
    }

    protected abstract BaseRepository<T> getRepository();
}

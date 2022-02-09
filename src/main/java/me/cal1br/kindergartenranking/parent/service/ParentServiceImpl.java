package me.cal1br.kindergartenranking.parent.service;

import me.cal1br.kindergartenranking.base.repository.BaseRepository;
import me.cal1br.kindergartenranking.base.service.AbstractBaseServiceImpl;
import me.cal1br.kindergartenranking.parent.model.ParentModel;
import me.cal1br.kindergartenranking.parent.repository.ParentRepository;

public class ParentServiceImpl extends AbstractBaseServiceImpl<ParentModel> implements ParentService {
    private final ParentRepository repository;

    public ParentServiceImpl(final ParentRepository repository) {
        this.repository = repository;
    }

    @Override
    protected BaseRepository<ParentModel> getRepository() {
        return repository;
    }
}

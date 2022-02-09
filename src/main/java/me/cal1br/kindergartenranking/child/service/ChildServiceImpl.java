package me.cal1br.kindergartenranking.child.service;

import me.cal1br.kindergartenranking.base.repository.BaseRepository;
import me.cal1br.kindergartenranking.base.service.AbstractBaseServiceImpl;
import me.cal1br.kindergartenranking.child.model.ChildModel;
import me.cal1br.kindergartenranking.child.repository.ChildRepository;

public class ChildServiceImpl extends AbstractBaseServiceImpl<ChildModel> implements ChildService {

    private final ChildRepository childRepository;

    public ChildServiceImpl(final ChildRepository childRepository) {
        this.childRepository = childRepository;
    }

    @Override
    protected BaseRepository<ChildModel> getRepository() {
        return childRepository;
    }
}
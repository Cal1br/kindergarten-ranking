package me.cal1br.kindergartenranking.child.repository;

import me.cal1br.kindergartenranking.base.repository.AbstractBaseRepositoryImpl;
import me.cal1br.kindergartenranking.child.model.ChildModel;

import java.util.List;
import java.util.stream.Collectors;

public class ChildRepositoryImpl extends AbstractBaseRepositoryImpl<ChildModel> implements ChildRepository {
    @Override
    protected boolean verifyModel(final ChildModel model) {
        //TODO
        return true;
    }

    @Override
    public List<ChildModel> getTwinsOf(final ChildModel child) {
        return this.getDatabaseDummy().values().parallelStream().filter(
                potentialTwin -> potentialTwin.getDateOfBirth().equals(child.getDateOfBirth()) &&
                        potentialTwin.getParents().equals(child.getParents())).collect(Collectors.toList());
        //TODO maybe make helper class family which contains List<Parents> and List<Children>
    }
}

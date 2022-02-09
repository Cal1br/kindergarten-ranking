package me.cal1br.kindergartenranking.child.repository;

import me.cal1br.kindergartenranking.base.repository.AbstractBaseRepositoryImpl;
import me.cal1br.kindergartenranking.child.model.ChildModel;

import java.util.List;
import java.util.stream.Collectors;

public class ChildRepositoryImpl extends AbstractBaseRepositoryImpl<ChildModel> implements ChildRepository {
    @Override
    protected boolean verifyModel(final ChildModel model) {
        if (model.getDateOfBirth().getYear() < 3) {
            return false;
        }
        if (model.getName() == null || model.getName().isEmpty()) {
            return false;
        }
        return true;
    }

    @Override
    public List<ChildModel> getTwinsOf(final ChildModel child) {
        return this.getDatabaseDummy().values().parallelStream().filter(
                potentialTwin -> potentialTwin.getDateOfBirth().equals(child.getDateOfBirth()) &&
                        potentialTwin.getParents().equals(child.getParents())).collect(Collectors.toList());
    }
}

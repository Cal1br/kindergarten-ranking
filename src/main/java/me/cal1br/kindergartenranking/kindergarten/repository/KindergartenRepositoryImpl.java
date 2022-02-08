package me.cal1br.kindergartenranking.kindergarten.repository;

import me.cal1br.kindergartenranking.base.repository.AbstractBaseRepositoryImpl;
import me.cal1br.kindergartenranking.child.model.ChildModel;
import me.cal1br.kindergartenranking.kindergarten.model.KindergartenModel;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class KindergartenRepositoryImpl extends AbstractBaseRepositoryImpl<KindergartenModel> implements KindergartenRepository {
    @Override
    protected boolean verifyModel(final KindergartenModel model) {
        //TODO
        return true;
    }

    @Override
    public List<ChildModel> getSiblingsOf(final long id, final ChildModel child) {
        if (child.getParents() == null || child.getParents().isEmpty()) {
            return Collections.emptyList();
        }
        final Optional<KindergartenModel> kindergartenOptional = this.findById(id);
        if (!kindergartenOptional.isPresent()) {
            return Collections.emptyList();
        }
        final KindergartenModel kindergarten = kindergartenOptional.get();
        return kindergarten.getStudents()
                .parallelStream()
                .filter(potentialSibling -> potentialSibling.getParents().equals(child.getParents()))
                .collect(Collectors.toList());
    }
}

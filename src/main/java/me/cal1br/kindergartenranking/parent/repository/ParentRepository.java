package me.cal1br.kindergartenranking.parent.repository;

import me.cal1br.kindergartenranking.base.repository.BaseRepository;
import me.cal1br.kindergartenranking.child.model.ChildModel;
import me.cal1br.kindergartenranking.parent.model.ParentModel;

import java.util.List;

public interface ParentRepository extends BaseRepository<ParentModel> {
    List<ParentModel> getParentsByChild(ChildModel child);
}

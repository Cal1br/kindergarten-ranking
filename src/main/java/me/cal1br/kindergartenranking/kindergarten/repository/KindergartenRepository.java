package me.cal1br.kindergartenranking.kindergarten.repository;

import me.cal1br.kindergartenranking.base.repository.BaseRepository;
import me.cal1br.kindergartenranking.child.model.ChildModel;
import me.cal1br.kindergartenranking.kindergarten.model.KindergartenModel;

import java.util.List;

public interface KindergartenRepository extends BaseRepository<KindergartenModel> {
    List<ChildModel> getSiblingsOf(long id, ChildModel child);
}

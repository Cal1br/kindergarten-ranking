package me.cal1br.kindergartenranking.child.repository;

import me.cal1br.kindergartenranking.base.repository.BaseRepository;
import me.cal1br.kindergartenranking.child.model.ChildModel;

import java.util.List;

public interface ChildRepository extends BaseRepository<ChildModel> {
    List<ChildModel> getTwinsOf(ChildModel child);
}

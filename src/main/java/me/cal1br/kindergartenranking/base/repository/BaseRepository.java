package me.cal1br.kindergartenranking.base.repository;

import me.cal1br.kindergartenranking.administrator.model.BaseModel;

import java.util.Optional;

public interface BaseRepository<T extends BaseModel> {
    Optional<T> findByName(String name);

    Optional<T> findById(Long id);

    long save(final T model);

    boolean editById(Long id, T model);

}

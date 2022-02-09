package me.cal1br.kindergartenranking.base.repository;

import me.cal1br.kindergartenranking.administrator.model.BaseModel;

import java.util.List;
import java.util.Optional;

public interface BaseRepository<T extends BaseModel> {
    Optional<T> findByName(String name);

    Optional<T> findById(Long id);

    List<T> findAll();

    long save(final T model);

    T editById(Long id, T model);
}

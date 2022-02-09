package me.cal1br.kindergartenranking.base.service;

import me.cal1br.kindergartenranking.administrator.model.BaseModel;

import java.util.List;

public interface BaseService<T extends BaseModel> {
    List<T> findAll();

    T findById(long id);
}

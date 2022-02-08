package me.cal1br.kindergartenranking.child.service;

import me.cal1br.kindergartenranking.child.model.ChildModel;

public interface ChildService {
    int calculateChildPoints(long kindergartenId, ChildModel child);
}

package me.cal1br.kindergartenranking.kindergarten.service;

import me.cal1br.kindergartenranking.child.model.ChildModel;
import me.cal1br.kindergartenranking.kindergarten.model.KindergartenModel;

import java.util.List;

public interface KindergartenService {
    List<ChildModel> rankChildren(KindergartenModel kindergarten, List<ChildModel> childModelList);
    int calculateChildPoints(long kindergartenId, ChildModel child);
}

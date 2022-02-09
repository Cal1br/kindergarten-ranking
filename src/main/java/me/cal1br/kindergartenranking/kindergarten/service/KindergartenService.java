package me.cal1br.kindergartenranking.kindergarten.service;

import me.cal1br.kindergartenranking.base.service.BaseService;
import me.cal1br.kindergartenranking.child.model.ChildModel;
import me.cal1br.kindergartenranking.kindergarten.model.KindergartenModel;

import java.util.List;
import java.util.Map;

public interface KindergartenService extends BaseService<KindergartenModel> {
    Map<KindergartenModel, List<ChildModel>> rankChildren(List<KindergartenModel> kindergartenList, List<ChildModel> childList);
}

package me.cal1br.kindergartenranking.kindergarten.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import me.cal1br.kindergartenranking.administrator.model.BaseModel;
import me.cal1br.kindergartenranking.child.model.ChildModel;

import java.util.LinkedList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class KindergartenModel extends BaseModel {
    @EqualsAndHashCode.Include
    private int places;
    private List<ChildModel> students = new LinkedList<>();
}
//todo remove wishlist when child is accepted

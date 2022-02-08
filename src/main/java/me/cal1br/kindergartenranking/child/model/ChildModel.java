package me.cal1br.kindergartenranking.child.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import me.cal1br.kindergartenranking.base.model.PersonModel;
import me.cal1br.kindergartenranking.kindergarten.model.KindergartenModel;
import me.cal1br.kindergartenranking.parent.model.ParentModel;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class ChildModel extends PersonModel {
    private boolean isDisabled;
    private List<ParentModel> parents;
    private List<KindergartenModel> wishList;
}

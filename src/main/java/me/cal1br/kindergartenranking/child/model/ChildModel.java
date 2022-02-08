package me.cal1br.kindergartenranking.child.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import me.cal1br.kindergartenranking.base.model.PersonModel;
import me.cal1br.kindergartenranking.kindergarten.model.KindergartenModel;
import me.cal1br.kindergartenranking.parent.model.ParentModel;

import java.util.List;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
public class ChildModel extends PersonModel {
    private boolean isDisabled = false;
    private List<ParentModel> parents;
    private Set<KindergartenModel> wishList;


}

package me.cal1br.kindergartenranking.child.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import me.cal1br.kindergartenranking.base.model.PersonModel;
import me.cal1br.kindergartenranking.kindergarten.model.KindergartenModel;
import me.cal1br.kindergartenranking.parent.model.ParentModel;

import java.util.Collections;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class ChildModel extends PersonModel {
    @EqualsAndHashCode.Include
    private boolean isDisabled = false;
    @EqualsAndHashCode.Include
    private List<ParentModel> parents = Collections.emptyList();
    private List<KindergartenModel> wishList = Collections.emptyList();

    @Override
    public String toString() {
        return "ChildModel{" +
                "isDisabled=" + isDisabled +
                ", parents=" + parents +
                '}';
    }
}

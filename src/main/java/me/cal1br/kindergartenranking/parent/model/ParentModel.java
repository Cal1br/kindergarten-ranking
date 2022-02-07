package me.cal1br.kindergartenranking.parent.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import me.cal1br.kindergartenranking.base.model.PersonModel;
import me.cal1br.kindergartenranking.child.model.ChildModel;

@Data
@EqualsAndHashCode(callSuper = true)
public class ParentModel extends PersonModel {
    private String workplace;
    private String phoneNumber;
    private ChildModel parentOf;
}

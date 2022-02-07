package me.cal1br.kindergartenranking.parent.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import me.cal1br.kindergartenranking.administrator.model.BaseModel;
import me.cal1br.kindergartenranking.child.model.ChildModel;

@Data
@EqualsAndHashCode(callSuper = true)
public class ParentModel extends BaseModel {
    private String workplace;
    private String phoneNumber;
    private ChildModel parentOf;
}

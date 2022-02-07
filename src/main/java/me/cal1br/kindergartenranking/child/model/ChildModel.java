package me.cal1br.kindergartenranking.child.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import me.cal1br.kindergartenranking.administrator.model.BaseModel;

@Data
@EqualsAndHashCode(callSuper = true)
public class ChildModel extends BaseModel {
    private boolean isDisabled;
}

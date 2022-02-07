package me.cal1br.kindergartenranking.kindergarten.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import me.cal1br.kindergartenranking.administrator.model.BaseModel;

@Data
@EqualsAndHashCode(callSuper = true)
public class KindergartenModel extends BaseModel {
    private Long id;
    private String name;
    private int places;
}

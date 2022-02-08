package me.cal1br.kindergartenranking.kindergarten.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import me.cal1br.kindergartenranking.administrator.model.BaseModel;
import me.cal1br.kindergartenranking.child.model.ChildModel;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class KindergartenModel extends BaseModel {
    private Long id;
    private String name;
    private int places;
    private List<ChildModel> students;
}

package me.cal1br.kindergartenranking.base.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import me.cal1br.kindergartenranking.administrator.model.BaseModel;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
public abstract class PersonModel extends BaseModel {
    private LocalDateTime dateOfBirth;
}

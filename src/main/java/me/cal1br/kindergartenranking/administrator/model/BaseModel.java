package me.cal1br.kindergartenranking.administrator.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public abstract class BaseModel {
    private Long id;
    private String name;
}

package me.cal1br.kindergartenranking.administrator.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class AdministratorModel extends BaseModel {
    private String password;
    private String email;
}

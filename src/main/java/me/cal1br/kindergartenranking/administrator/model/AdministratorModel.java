package me.cal1br.kindergartenranking.administrator.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import me.cal1br.kindergartenranking.base.model.PersonModel;

@Data
@EqualsAndHashCode(callSuper = true)
public class AdministratorModel extends PersonModel {
    private String password;
    private String email;
}

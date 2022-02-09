package me.cal1br.kindergartenranking.parent.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import me.cal1br.kindergartenranking.base.model.PersonModel;
import me.cal1br.kindergartenranking.child.model.ChildModel;

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class ParentModel extends PersonModel {
    @EqualsAndHashCode.Include
    private String workplace;
    @EqualsAndHashCode.Include
    private String phoneNumber;
    private ChildModel parentOf;

    @Override
    public String toString() {
        return "ParentModel{" +
                "workplace='" + workplace + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}

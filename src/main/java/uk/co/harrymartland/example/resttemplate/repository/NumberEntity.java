package uk.co.harrymartland.example.resttemplate.repository;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class NumberEntity {

    @Id
    private Integer number;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}

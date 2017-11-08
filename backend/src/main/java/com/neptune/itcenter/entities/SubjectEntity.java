package com.neptune.itcenter.entities;

import javax.persistence.*;

@Entity
@Table(name = "subjects")
@NamedQueries({
        @NamedQuery(name = SubjectEntity.FIND_ALL, query = "SELECT t FROM SubjectEntity t"),
})
public class SubjectEntity extends GenericEntity {
    public static final String FIND_ALL = "SubjectEntity.findAll";

    @Column
    private String name;
    @Column
    private int price;
    @Column
    private boolean active;

    public SubjectEntity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}

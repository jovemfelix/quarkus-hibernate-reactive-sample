package org.acme;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;

import javax.persistence.Cacheable;
import javax.persistence.Entity;

@Entity
@Cacheable
public class Fruit extends PanacheEntity {

    public String name;

    public Fruit() {}

    public Fruit(String name) {
        this.name = name;
    }

}
package com.anma.qrk;

import java.util.UUID;

public class City {
    private UUID id;
    private String name;
    private int population;

    public City() {
    }

    public City(UUID id, String name, int population) {
        this.id = id;
        this.name = name;
        this.population = population;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}

package org.lessons.java.agency;

import java.math.BigDecimal;

public class Escursione {
    private String city;
    private int duration;
    private BigDecimal price;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Escursione(String city, int duration, BigDecimal price) {
        this.city = city;
        this.duration = duration;
        this.price = price;
    }
}
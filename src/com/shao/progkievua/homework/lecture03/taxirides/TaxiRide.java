package com.shao.progkievua.homework.lecture03.taxirides;

import java.util.Random;

public class TaxiRide {
    private int passengers;
    private int distance;
    private int duration;

    public TaxiRide(int passengers, int distance, int duration) {
        this.passengers = passengers;
        this.distance = distance;
        this.duration = duration;
    }

    public TaxiRide() {
        Random random = new Random();
        passengers = random.nextInt(4) + 1;
        this.distance = random.nextInt(30) + 1;
        ;
        this.duration = random.nextInt(120) + 1;
    }

    public int getPassengers() {
        return passengers;
    }

    public int getDistance() {
        return distance;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "Passengers: " + passengers + ". Distance: " + distance + " km. Duration: " + duration + " min.";
    }

    public String toString(TaxiTariff taxiTariff) {
        return "Passengers: " + passengers + ". Distance: " + distance + " km. Duration: " + duration + " min. Price: " + getPrice(taxiTariff);
    }

    public long getPrice(TaxiTariff tariff) {
        return tariff.calculatePrice(this);
    }
}

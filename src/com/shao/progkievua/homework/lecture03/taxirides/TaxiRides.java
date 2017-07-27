package com.shao.progkievua.homework.lecture03.taxirides;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TaxiRides {
    private List<TaxiRide> rides;

    public TaxiRides() {
        rides = new ArrayList();
    }

    public void addRandomRide() {
        rides.add(new TaxiRide());
    }

    public void addRide(TaxiRide ride) {
        rides.add(ride);
    }

    public void addRandomRides() {
        Random random = new Random();
        for (int i = 0; i < random.nextInt(20) + 1; i++) {
            addRandomRide();
        }
    }

    public long getPrice(TaxiTariff tariff) {
        long summaryPrice = 0;
        for (TaxiRide ride : rides) {
            summaryPrice += ride.getPrice(tariff);
        }
        return summaryPrice;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rides.size(); i++) {
            sb.append("Ride: ").append(i).append(rides.get(i).toString()).append("\n");
        }
        return sb.toString();
    }

    public String toString(TaxiTariff taxiTariff) {
        StringBuilder sb = new StringBuilder().append("Tariff: ").append(taxiTariff.getClass().getSimpleName()).append("\n");
        for (int i = 0; i < rides.size(); i++) {
            sb.append("Ride: ").append(i).append(". ").append(rides.get(i).toString(taxiTariff)).append("\n");
        }
        return sb.toString();
    }
}

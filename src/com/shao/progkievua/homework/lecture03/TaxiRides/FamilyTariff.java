package com.shao.progkievua.homework.lecture03.TaxiRides;

public final class FamilyTariff implements TaxiTariff {
    public static FamilyTariff instance;

    public static FamilyTariff getInstance() {
        if (instance == null) instance = new FamilyTariff();
        return instance;
    }

    @Override
    public long calculatePrice(TaxiRide ride) {
        return 50 + 20 * ride.getDistance() / ride.getPassengers();
    }

}

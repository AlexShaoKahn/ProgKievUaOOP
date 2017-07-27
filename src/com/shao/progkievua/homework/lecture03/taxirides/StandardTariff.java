package com.shao.progkievua.homework.lecture03.taxirides;

public final class StandardTariff implements TaxiTariff {
    public static StandardTariff instance;

    public static StandardTariff getInstance() {
        if (instance == null) instance = new StandardTariff();
        return instance;
    }

    @Override
    public long calculatePrice(TaxiRide ride) {
        return 30 + 5 * ride.getDistance() + 2 * ride.getDuration();
    }
}

package com.shao.progkievua.homework.lecture03.taxirides;

public final class VipTariff implements TaxiTariff {
    public static VipTariff instance;

    private VipTariff() {
    }

    public static VipTariff getInstance() {
        if (instance == null) instance = new VipTariff();
        return instance;
    }

    @Override
    public long calculatePrice(TaxiRide ride) {
        return ride.getPassengers() * 10 + ride.getDistance() * 10 + ride.getDuration() * 10;
    }
}

package com.shao.progkievua.homework.lecture03.taxirides;

public class RidesRunner {
    public static void main(String[] args) {
        TaxiTariff standardTariff = StandardTariff.getInstance();
        TaxiTariff familyTariff = FamilyTariff.getInstance();
        TaxiTariff vipTariff = VipTariff.getInstance();
        TaxiRides taxiRides = new TaxiRides();

        taxiRides.addRandomRides();

        System.out.println(taxiRides.toString(standardTariff));
        System.out.println(taxiRides.toString(familyTariff));
        System.out.println(taxiRides.toString(vipTariff));

    }
}

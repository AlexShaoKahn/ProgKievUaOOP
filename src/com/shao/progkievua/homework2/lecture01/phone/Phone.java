package com.shao.progkievua.homework2.lecture01.phone;

import java.io.Serializable;
import java.util.Objects;

public class Phone implements Serializable {
    private int number;

    public Phone() {

    }

    public void register(Network network, int number) {
        if (network.register(number)) this.number = number;
        else System.out.println("ERROR: number " + number + " already exists!");
    }

    public void autoRegister(Network network) {
        number = network.register();
    }

    public void call(Network network, int number) {
        System.out.print("Calling form " + this.number + " to " + number + ": ");
        System.out.println(network.connect(this, number));
    }


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phone phone = (Phone) o;
        return number == phone.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return "Phone{" +
                "number=" + number +
                '}';
    }
}

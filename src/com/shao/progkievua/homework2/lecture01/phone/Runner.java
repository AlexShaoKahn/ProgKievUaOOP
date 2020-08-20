package com.shao.progkievua.homework2.lecture01.phone;

public class Runner {
    public static void main(String[] args) {
        Network network = new Network();
        Phone phone1 = new Phone();
        Phone phone2 = new Phone();
        Phone phone3 = new Phone();

        phone1.autoRegister(network);
        phone2.autoRegister(network);
        phone3.register(network, 1234567);

        phone1.call(network, phone2.getNumber());
        phone3.call(network, 1234567);
        phone2.call(network, 7654321);
    }
}

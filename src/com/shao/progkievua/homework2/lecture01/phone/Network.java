package com.shao.progkievua.homework2.lecture01.phone;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Network implements Serializable {
    List<Integer> numbers;

    public Network() {
        numbers = randomNumbers();
    }

    private Network(List<Integer> numbers) {
        this.numbers = numbers;
    }

    private static List<Integer> randomNumbers() {
        Random random = new Random();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < random.nextInt(500) + 101; i++) {
            numbers.add(random.nextInt(9000000) + 1000000);
        }
        return numbers;
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    public Network setNumbers(List<Integer> numbers) {
        return new Network(numbers);
    }

    public Boolean register(int number) {
        if (numbers.contains(number)) return false;
        else {
            numbers.add(number);
            return true;
        }
    }

    public int register() {
        Random random = new Random();
        int number;
        do {
            number = random.nextInt(9000000) + 1000000;
        } while (!register(number));
        return number;
    }

    public String connect(Phone phoneFrom, int number) {
        if (phoneFrom.getNumber() <= 0 || number <= 0) return "ERROR: Not registered";
        else if (phoneFrom.getNumber() == number) return "ERROR: Can't call yourself";
        else if (numbers.contains(number)) return "Connection established!";
        else return "ERROR: Not registered!";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Network network = (Network) o;
        return numbers.equals(network.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        return "Network{" +
                "numbers=" + numbers +
                '}';
    }
}

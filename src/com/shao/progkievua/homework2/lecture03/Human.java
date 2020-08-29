package com.shao.progkievua.homework2.lecture03;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Human implements Serializable {
    private static final long serialVersionUID = 8203105951999963898L;
    private String name;
    private String surname;
    private int age;
    private Gender gender;

    public Human() {
        this(generateHuman());
    }

    public Human(String name, String surname, int age, Gender gender) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
    }

    private Human(Human human) {
        this.name = human.name;
        this.surname = human.surname;
        this.age = human.age;
        this.gender = human.gender;
    }

    private static Human generateHuman() {
        Random random = new Random();
        List<String> maleNames = Arrays.asList("James", "John", "Robert", "Michael", "William", "David", "Richard", "Joseph", "Thomas", "Charles", "Christopher", "Daniel", "Matthew", "Anthony", "Donald", "Mark", "Paul", "Steven", "Andrew", "Kenneth", "Joshua", "George", "Kevin", "Brian", "Edward", "Ronald", "Timothy", "Jason", "Jeffrey", "Ryan", "Jacob", "Gary", "Nicholas", "Eric", "Stephen", "Jonathan", "Larry", "Justin", "Scott", "Brandon", "Frank", "Benjamin", "Gregory", "Samuel", "Raymond", "Patrick", "Alexander", "Jack", "Dennis", "Jerry", "Tyler", "Aaron", "Jose", "Henry", "Douglas", "Adam", "Peter", "Nathan", "Zachary", "Walter", "Kyle", "Harold", "Carl", "Jeremy", "Keith", "Roger", "Gerald", "Ethan", "Arthur", "Terry", "Christian", "Sean", "Lawrence", "Austin", "Joe", "Noah", "Jesse", "Albert", "Bryan", "Billy", "Bruce", "Willie", "Jordan", "Dylan", "Alan", "Ralph", "Gabriel", "Roy", "Juan", "Wayne", "Eugene", "Logan", "Randy", "Louis", "Russell", "Vincent", "Philip", "Bobby", "Johnny", "Bradley");
        List<String> femaleNames = Arrays.asList("Mary", "Patricia", "Jennifer", "Linda", "Elizabeth", "Barbara", "Susan", "Jessica", "Sarah", "Karen", "Nancy", "Margaret", "Lisa", "Betty", "Dorothy", "Sandra", "Ashley", "Kimberly", "Donna", "Emily", "Michelle", "Carol", "Amanda", "Melissa", "Deborah", "Stephanie", "Rebecca", "Laura", "Sharon", "Cynthia", "Kathleen", "Helen", "Amy", "Shirley", "Angela", "Anna", "Brenda", "Pamela", "Nicole", "Ruth", "Katherine", "Samantha", "Christine", "Emma", "Catherine", "Debra", "Virginia", "Rachel", "Carolyn", "Janet", "Maria", "Heather", "Diane", "Julie", "Joyce", "Victoria", "Kelly", "Christina", "Joan", "Evelyn", "Lauren", "Judith", "Olivia", "Frances", "Martha", "Cheryl", "Megan", "Andrea", "Hannah", "Jacqueline", "Ann", "Jean", "Alice", "Kathryn", "Gloria", "Teresa", "Doris", "Sara", "Janice", "Julia", "Marie", "Madison", "Grace", "Judy", "Theresa", "Beverly", "Denise", "Marilyn", "Amber", "Danielle", "Abigail", "Brittany", "Rose", "Diana", "Natalie", "Sophia", "Alexis", "Lori", "Kayla", "Jane");
        List<String> surnames = Arrays.asList("Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia", "Miller", "Davis", "Rodriguez", "Martinez", "Hernandez", "Lopez", "Gonzales", "Wilson", "Anderson", "Thomas", "Taylor", "Moore", "Jackson", "Martin", "Lee", "Perez", "Thompson", "White", "Harris", "Sanchez", "Clark", "Ramirez", "Lewis", "Robinson", "Walker", "Young", "Allen", "King", "Wright", "Scott", "Torres", "Nguyen", "Hill", "Flores", "Green", "Adams", "Nelson", "Baker", "Hall", "Rivera", "Campbell", "Mitchell", "Carter", "Roberts", "Gomez", "Phillips", "Evans", "Turner", "Diaz", "Parker", "Cruz", "Edwards", "Collins", "Reyes", "Stewart", "Morris", "Morales", "Murphy", "Cook", "Rogers", "Gutierrez", "Ortiz", "Morgan", "Cooper", "Peterson", "Bailey", "Reed", "Kelly", "Howard", "Ramos", "Kim", "Cox", "Ward", "Richardson", "Watson", "Brooks", "Chavez", "Wood", "James", "Bennet", "Gray", "Mendoza", "Ruiz", "Hughes", "Price", "Alvarez", "Castillo", "Sanders", "Patel", "Myers", "Long", "Ross", "Foster", "Jimenez");
        if (random.nextBoolean())
            return new Human(
                    femaleNames.get(random.nextInt(femaleNames.size())),
                    surnames.get(random.nextInt(surnames.size())),
                    16 + random.nextInt(40),
                    Gender.FEMALE
            );
        else
            return new Human(
                    maleNames.get(random.nextInt(maleNames.size())),
                    surnames.get(random.nextInt(surnames.size())),
                    16 + random.nextInt(40),
                    Gender.values()[random.nextInt(Gender.values().length - 1) + 1]
            );
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return age == human.age &&
                name.equals(human.name) &&
                surname.equals(human.surname) &&
                gender == human.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, gender);
    }

    @Override
    public String toString() {
        return "name: " + surname + " " + name +
                ", age: " + age + ", gender: " + gender.toString();
    }
}

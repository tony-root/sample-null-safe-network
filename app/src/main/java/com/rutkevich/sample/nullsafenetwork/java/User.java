package com.rutkevich.sample.nullsafenetwork.java;

public class User {

    private final String id;
    private final String name;
    private final String surname;
    private final int age;

    public User(String id, String name, String surname, int age) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getSurname() { return surname; }
    public int getAge() { return age; }
}

package me.seungho.java8to11;

public class DefaultApp implements App{

    String name;

    public DefaultApp(String name) {
        this.name = name;
    }

    @Override
    public void printName() {
        System.out.println(this.name);
    }

    @Override
    public String getName() {
        return this.name;
    }
}

package org.example;

public class Cat extends Animal{
    private boolean isLazy;

    public Cat(String name, int age, boolean isLazy) {
        super(name, age);
        this.isLazy = isLazy;
    }

    @Override
    public void makeSound() {
        System.out.println("Meow! Meow!");
    }

    @Override
    public String toString() {
        return "Cat{" +
                "isLazy=" + isLazy +
                '}';
    }
}

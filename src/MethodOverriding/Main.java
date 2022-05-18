package MethodOverriding;

public class Main {
    public static void main(String[] args) {
        //basic methods
        Animal animal = new Animal();
        animal.speak();
        animal.eat();

        System.out.println();
        //Overwrite methods for specific animals/ dog case;
        Dog dog = new Dog();
        dog.speak();
        dog.eat();

        System.out.println();
        //overwrite methods for cat case;
        Cat cat = new Cat();
        cat.speak();
        cat.eat();
    }
}

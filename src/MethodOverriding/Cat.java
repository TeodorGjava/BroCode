package MethodOverriding;

public class Cat extends Animal{

    @Override
    void speak(){
        System.out.println("This animal meows");
    }
    @Override
    void eat(){
        System.out.println("This animal eats fish");
    }
}

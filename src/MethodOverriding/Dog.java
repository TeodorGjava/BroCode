package MethodOverriding;

public class Dog extends Animal{
    // This is overrided method
    //do something that is more specific to this class
    @Override
    void speak(){
        //change speak to bark
        System.out.println("This animal barks");
    }
    @Override
    void eat(){
        System.out.println("This animal eats meat");
    }

}

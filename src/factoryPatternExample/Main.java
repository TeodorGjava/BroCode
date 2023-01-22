package factoryPatternExample;

import java.util.List;

interface SwimBehavior{
    void swim();
}
class Creature{

}
interface FlyBehavior{
    void fly();
}
class Bee extends Creature implements FlyBehavior{

    @Override
    public void fly() {
        System.out.println("Bees can fly");
    }
}
class Penguin extends Creature implements FlyBehavior,SwimBehavior{

    @Override
    public void swim() {
        System.out.println("Penguins can swim");
    }

    @Override
    public void fly() {
        System.out.println("Penguins can't fly");
    }
}
class Human extends Creature implements FlyBehavior, SwimBehavior{


    @Override
    public void swim() {
        System.out.println("Humans can swim");
    }

    @Override
    public void fly() {
        System.out.println("Humans fly with inventions!");
    }
}
public class Main{
    public static void main(String[] args) {
        List<Creature> creatures = List.of(
                new Penguin(),new Bee(),new Human()
        );
        
    }
}



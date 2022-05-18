package Abstract;
//subclass of Vehicle
public class Car extends Vehicle{
    @Override
    void go(){
        System.out.println("The driver drives the car");
    }
    @Override
    void stop(){
        System.out.println("The driver stopped the vehicle");
    }

}

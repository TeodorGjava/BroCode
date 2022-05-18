package PassingObjectsAsArgs;

public class Garage {
    //passing car Object as arg
    void park(Car car){
        System.out.println("The car "+ car.name + " with license plate "+ car.plate +" is parked in the garage");
    }

}

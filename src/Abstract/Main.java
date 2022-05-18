package Abstract;

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        //cannot declare a vehicle obj, we have to pick a certain type of vehicle, a car, a motorcycle, a truck
        Vehicle vehicle = new Car();
        car.go();
        vehicle.go();
        car.stop();
        vehicle.stop();
    }
}

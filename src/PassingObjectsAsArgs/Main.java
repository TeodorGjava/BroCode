package PassingObjectsAsArgs;

public class Main {
    public static void main(String[] args) {
        //creating garage
        Garage garage = new Garage();

        Car car = new Car("BMW","СВ 6666 АВ");
        Car car1 = new Car("Mercedes","СВ 6643 АР");

        garage.park(car);
        garage.park(car1);
    }
}

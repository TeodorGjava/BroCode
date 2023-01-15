package thinking.holdingYObjects;

public class Gerbil {
    private final int gerbilNumber;

    public Gerbil(int gerbilNumber) {
        this.gerbilNumber = gerbilNumber;
    }

    void hop() {

        System.out.println(this.gerbilNumber + " is hopping!");
    }
}

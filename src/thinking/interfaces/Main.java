package thinking.interfaces;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Random;
import java.util.Scanner;

public class Main {
    /*
    Exercise 16: (3) Create a class that produces a sequence of chars. Adapt this class so
that it can be an input to a Scanner object.
     */

    interface FinalStaticFieldsExample {
        String name = "Pesho";

    }

    static class FinalStaticFieldsExampleImpl implements FinalStaticFieldsExample {

    }

    static class RandomChars implements Readable {
        private static final Random rnd = new Random(47);
        private static final char[] aToZ = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        private int size;

        public RandomChars(int size) {
            this.size = size;
        }

        @Override
        public int read(CharBuffer cb) throws IOException {
            if (size-- == 0) {
                return -1;
            }
            for (int i = 0; i < 10; i++) {
                cb.append(aToZ[rnd.nextInt(aToZ.length)]);
            }
            cb.append(" ");
            return size;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(new RandomChars(10));
        while (sc.hasNext()) {
            System.out.println(sc.next());
        }
        // Cannot assign a value to a final variable
        //Exercise 17: (2) Prove that the fields in an interface are implicitly static and final.
        // FinalStaticFieldsExample.name = "Gosho";



        /*
        Exercise 18: (2) Create a Cycle interface, with implementations Unicycle, Bicycle
and Tricycle. Create factories for each type of Cycle, and code that uses these factories.
         */
        System.out.println();
        getCycle(new BicycleFactory());
        getCycle(new UnicycleFactory());
        getCycle(new TricycleFactory());
    }

    interface Cycle {

    }

    interface CycleFactory {
        Cycle getCycle();
    }

    static class Bicycle implements Cycle {
        Bicycle() {
            System.out.println("Bicycle constructed");
        }
    }

    static class BicycleFactory implements CycleFactory {
        @Override
        public Cycle getCycle() {
            return new Bicycle();
        }
    }

    static class Tricycle implements Cycle {
        Tricycle() {
            System.out.println("Tricycle Constructed");
        }
    }

    static class TricycleFactory implements CycleFactory {

        @Override
        public Cycle getCycle() {
            return new Tricycle();
        }
    }

    static class Unicycle implements Cycle {
        Unicycle() {
            System.out.println("Unicycle Constructed");
        }
    }

    static class UnicycleFactory implements CycleFactory {

        @Override
        public Cycle getCycle() {
            return new Unicycle();
        }
    }

    public static void getCycle(CycleFactory factory) {
        Cycle cycle = factory.getCycle();
    }
}





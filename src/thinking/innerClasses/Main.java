package thinking.innerClasses;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static class Outer {
        static private String label;

        public String getLabel() {
            return label;
        }

        public Outer(String label) {
            this.label = label;
        }

        static Inner getInner() {
            return new Inner();
        }

        static class Inner {
            @Override
            public String toString() {
                return label;
            }
        }
    }

    public interface Selector {
        boolean end();

        Object current();

        void next();

        Sequence getSequence();
    }

    public interface Iteration {
        void display(Iterator<String> it);
    }

    public static class Sequence {
        private List<Object> items;
        private int next = 0;

        public Sequence() {
            items = new ArrayList<>();
        }

        public void add(Object x) {
            items.add(x);
        }

        public class SequenceIterator implements Iteration {

            @Override
            public void display(Iterator<String> it) {
                while (it.hasNext()) {
                    System.out.println(it.next());
                }
            }

        }

        public class SequenceSelector implements Selector {
            private int i = 0;

            @Override
            public boolean end() {
                return i == items.size();
            }

            @Override
            public Sequence getSequence() {
                return new Sequence();
            }

            @Override
            public Object current() {
                return items.get(i);
            }

            @Override
            public void next() {
                if (i < items.size()) i++;
            }
        }

        public class ReverseSelector implements Selector {
            private int i = 10;

            @Override
            public boolean end() {
                return i == 0;
            }

            @Override
            public Sequence getSequence() {
                return new Sequence();
            }

            @Override
            public Object current() {
                return items.get(i - 1);
            }

            @Override
            public void next() {
                if (i > -1) i--;
            }
        }

        private static class Person {
            private String name;

            public Person(String name) {
                this.name = name;
            }

            @Override
            public String toString() {
                return this.name;
            }
        }

        public Iteration iteration() {
            return new SequenceIterator();
        }

        public Selector selector() {
            return new SequenceSelector();
        }

        public Selector reverseSelector() {
            return new ReverseSelector();
        }


        public static void main(String[] args) {
            //Exercise 1: (1) Write a class named Outer that contains an inner class named Inner.
            //Add a method to Outer that returns an object of type Inner. In main( ), create and
            //initialize a reference to an Inner.
            System.out.println("Exercise 1:");
            Outer.Inner inner = Outer.getInner();


            /*
            Exercise 2: (1) Create a class that holds a String, and has a toString( ) method that
displays this String. Add several instances of your new class to a Sequence object, then
display them.
             */
            System.out.println("Exercise 2:");
            Sequence sequence = new Sequence();

            sequence.add(new Person("John First"));
            sequence.add(new Person("Smith"));
            sequence.add(new Person("Potter"));

            sequence.add(new Person("John"));
            sequence.add(new Person("Smith"));
            sequence.add(new Person("Potter"));

            sequence.add(new Person("John"));
            sequence.add(new Person("Smith"));
            sequence.add(new Person("Potter"));
            sequence.add(new Person("Potter Last"));
            Selector selector = sequence.selector();
            while (!selector.end()) {
                System.out.print(selector.current() + " ");
                selector.next();
            }
            /*
            Exercise 3: (1) Modify Exercise 1 so that Outer has a private String field (initialized
        by the constructor), and Inner has a toString( ) that displays this field. Create an object of
        type Inner and display it.
             */
            System.out.println("Exercise 3:");
            Outer.Inner inner1 = new Outer.Inner();
            Outer outer = new Outer("label");
            System.out.println(inner1);


            /*\
            \Exercise 4: (2) Add a method to the class Sequence.SequenceSelector that produces
the reference to the outer class Sequence.
             */
            System.out.println("Exercise 4:");
            Sequence sequence1 = new Sequence();
            Selector selector1 = sequence.selector();
            Sequence sequence2 = selector1.getSequence();
            System.out.println(sequence2);
            /*
            Exercise 5: (1) Create a class with an inner class. In a separate class, make an instance of
the inner class.
             */
            System.out.println("Exercise 5:");
            Outer2.Inner2 inner2 = new Outer2.Inner2();
            System.out.println(inner2);

            /*
            Exercise 15: (2) Create a class with a non-default constructor (one with arguments) and
            no default constructor (no "no-arg" constructor). Create a second class that has a method
            that returns a reference to an object of the first class. Create the object that you return by
            making an anonymous inner class that inherits from the first class.
             */
            System.out.println("Exercise 15:");

            Ring ring = Bell.Ringer.getRing();

            /*
            Exercise 21: (2) Create an interface that contains a nested class that has a static method
            that calls the methods of your interface and displays the results. Implement your interface
            and pass an instance of your implementation to the method.
             */
            System.out.println("Exercise 21:");
            Wall wall = new Wall();
            Switch.Controller.callSwitch(wall);

            /*
            Exercise 22: (2) Implement reverseSelector( ) in Sequence.java.
             */
            System.out.println("Exercise 22:");
            sequence.add(new Person("John"));
            sequence.add(new Person("Smith"));
            sequence.add(new Person("Potter"));
            Selector reverseSelector = sequence.reverseSelector();
            while (!reverseSelector.end()) {
                System.out.print(reverseSelector.current() + " ");
                reverseSelector.next();
            }
        }

    }

}

class Wall implements Switch {

    @Override
    public void turnOn(String msg) {
        System.out.println(msg);
    }

    @Override
    public void turnOff(String msg) {
        System.out.println(msg);
    }
}

interface Switch {
    void turnOn(String msg);

    void turnOff(String msg);

    class Controller {
        static void callSwitch(Switch sw) {
            sw.turnOff("Switched Off");
            sw.turnOn("Switched On");
        }
    }
}

class Ring {
    Ring(String melody) {
        System.out.println("Jingle-Bells");
    }

}

class Bell {
    static class Ringer {
        public static Ring getRing() {
            return new Ring("2");
        }
    }
}

class Outer2 {
    static class Inner2 {

    }
}


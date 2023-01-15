package thinking.holdingYObjects;

import java.util.*;

public class Main {
    public static void main(String[] args) {
    /*
    Exercise 1: (2) Create a new class called Gerbil with an int gerbilNumber that’s
initialized in the constructor. Give it a method called hop( ) that displays which gerbil
number this is, and that it’s hopping. Create an ArrayList and add Gerbil objects to the
List. Now use the get( ) method to move through the List and call hop( ) for each Gerbil.
     */
        List<Gerbil> gerbils = new ArrayList<>();
        gerbils.add(new Gerbil(1));
        gerbils.add(new Gerbil(2));
        gerbils.add(new Gerbil(3));
        gerbils.add(new Gerbil(4));
        System.out.println("Exercise 1:");
        for (int i = 0; i < gerbils.size(); i++) {
            Gerbil currentGerbil = gerbils.get(i);
            currentGerbil.hop();
        }
        /*
        Exercise 2: (1) Modify SimpleCollection.java to use a Set for c.
         */

        System.out.println("Exercise 2:");
        Collection<Integer> c = new HashSet<>();
        for (int i = 0; i < 10; i++)
            c.add(i); // Autoboxing
        for (Integer i : c)
            System.out.print(i + ", ");

        System.out.println();

        /*
        Exercise 3: (2) Modify innerclasses/Sequence.java so that you can add any number
of elements to it.
         */
        System.out.println("Exercise 3:");
        thinking.innerClasses.Main.Sequence sequence = new thinking.innerClasses.Main.Sequence();
        sequence.add("Pesho");
        sequence.add(32);
        sequence.add(32.5);
        thinking.innerClasses.Main.Selector selector = sequence.selector();
        while (!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }
        System.out.println();
        /*
        Exercise 4: (3) Create a generator class that produces character names (as String
        objects) from your favorite movie (you can use Snow White or Star Wars as a fallback) each
        time you call next( ), and loops around to the beginning of the character list when it runs out
        of names. Use this generator to queue an array, an ArrayList, a LinkedList, a HashSet, a
        LinkedHashSet, and a TreeSet, then print each container.
         */
        System.out.println("Exercise 4:");
        Generator generator = new Generator();

        System.out.println(generator.fill(new ArrayList<>()));
        System.out.println(generator.fill(new LinkedList<>()));
        System.out.println(generator.fill(new HashSet<>()));
        System.out.println(generator.fill(new LinkedHashSet<>()));
        System.out.println(generator.fill(new TreeSet<>()));
        System.out.println(generator.fill(new TreeMap<>()));

        /*
        Exercise 9: (4) Modify innerclasses/Sequence.java so that Sequence works with an
Iterator instead of a Selector.
         */
        System.out.println("Exercise 9:");
        thinking.innerClasses.Main.Iteration iteration = sequence.iteration();
        List<String> names = List.of("Pesho", "Gosho", "Tosho");
        iteration.display(names.iterator());

        /*
        Exercise 11: (2) Write a method that uses an Iterator to step through a Collection and
        print the toString( ) of each object in the container. Fill all the different types of
        Collections with objects and apply your method to each container.
         */
        System.out.println("Exercise 11:");

        List<Cat> catsArrayList1 = new ArrayList<>();
        List<Cat> catsArrayList2 = new LinkedList<>();
        Set<Cat> catsSet1 = new HashSet<>();
        Set<Cat> catsSet2 = new LinkedHashSet<>();
        Map<Integer, Cat> catsMap = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            Cat cat = new Cat("Cat");
            catsArrayList1.add(cat);
            catsArrayList2.add(cat);
            catsSet1.add(cat);
            catsSet2.add(cat);
            catsMap.put(i + 1, cat);
        }
        iterate(catsArrayList1.iterator());
        iterate(catsArrayList2.iterator());
        iterate(catsSet1.iterator());
        iterate(catsSet2.iterator());
        iterate(catsMap.values().iterator());

        /*
        Exercise 12: (3) Create and populate a List<Integer>. Create a second List<Integer>
of the same size as the first, and use ListIterators to read elements from the first List and
insert them into the second in reverse order. (You may want to explore a number of different
ways to solve this problem.)
         */
        System.out.println("Exercise 12:");
        List<Integer> list1 = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7));
        List<Integer> list2 = list1;
        Collections.reverse(list2);
        for (Integer integer : list2) {
            System.out.print(integer + " ");
        }
        System.out.println();
        /*
        Exercise 15: (4) Stacks are often used to evaluate expressions in programming languages.
        Using net.mindview.util.Stack, evaluate the following expression, where’+’ means "push
        the following letter onto the stack," and’-’ means "pop the top of the stack and print it":
            "+U+n+c—+e+r+t—+a-+i-+n+t+y—+ -+r+u—+l+e+s—"
         */
        System.out.println("Exercise 15:");
        ArrayDeque<String> stack = new ArrayDeque<>();
        String[] split = "+U+n+c-+e+r+t—+a-+i-+n+t+y—+ -+r+u-+l+e+s-".split("");
        for (int i = 0; i < split.length; i++) {
            if (split[i].equals("-"))
                System.out.print(stack.pop() + " ");
            else if (split[i].equals("+"))
                stack.push(split[i + 1]);
        }
        System.out.println();

        /*
        Exercise 17: (2) Take the Gerbil class in Exercise 1 and put it into a Map instead,
        associating each Gerbil’s name (e.g. "Fuzzy" or "Spot") as a String (the key) for each
        Gerbil (the value) you put in the table. Get an Iterator for the keySet( ) and use it to move
        through the Map, looking up the Gerbil for each key and printing out the key and telling the
        Gerbil to hop( )
         */
        System.out.println("Exercise 17:");
        Map<String, Gerbil> gerbilMap = new HashMap<>();
        gerbilMap.put("Pesho", new Gerbil(3));
        gerbilMap.put("Toni", new Gerbil(1));
        gerbilMap.put("Gosho", new Gerbil(2));
        for (String s : gerbilMap.keySet()) {
            gerbilMap.get(s).hop();
        }
        /*
        Exercise 18: (3) Fill a HashMap with key-value pairs. Print the results to show
ordering by hash code. Extract the pairs, sort by key, and place the result into a
LinkedHashMap. Show that the insertion order is maintained.
         */
        Map<String, Integer> wordAndNumber = new HashMap<>();
        wordAndNumber.put("one", 1);
        wordAndNumber.put("two", 2);
        wordAndNumber.put("tree", 3);
        wordAndNumber.put("four", 4);

        Map<String, Integer> sortedMap = new TreeMap<>();
        sortedMap.put("two", 2);
        sortedMap.put("one", 1);
        sortedMap.put("four", 4);
        sortedMap.put("tree", 3);
        System.out.println("Sorted by key:");
        Map<String, Integer> linkedMap = new LinkedHashMap<>(sortedMap);

        sortedMap.forEach((k, v) -> System.out.println(k + " : " + v));
        /*
        Exercise 27: (2) Write a class called Command that contains a String and has a
        method operation( ) that displays the String. Write a second class with a method that fills
        a Queue with Command objects and returns it. Pass the filled Queue to a method in a
        third class that consumes the objects in the Queue and calls their operation( ) methods.
         */
        System.out.println("Exercise 27:");
        List<Command> commandList = List.of(
                new Command("Run"),
                new Command("Stop"),
                new Command("Jump"),
                new Command("Hide")
        );
        CommandFiller commandFiller = new CommandFiller();
        Queue<Command> queue = commandFiller.fill(commandList);
        CommandConsumer consumer = new CommandConsumer();
        consumer.consume(queue);

        /*
        Exercise 28: (2) Fill a PriorityQueue (using offer( )) with Double values created
using java.util.Random, then remove the elements using poll( ) and display them.
         */
        System.out.println("Exercise 28:");
        Random rnd = new Random();
        PriorityQueue<Double> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < 10; i++) {
            double v = rnd.nextDouble(400);
            priorityQueue.offer(v);
        }
        while (!priorityQueue.isEmpty())
            System.out.println(priorityQueue.poll());

        System.out.println("::::::::::::::::");
        System.out.println("System.getenv() Example ");
        for(Map.Entry entry: System.getenv().entrySet()) {
            System.out.println(entry.getKey() + ": " +
                    entry.getValue());
        }
        System.out.println("::::::::::::::::");

    }

    static void iterate(Iterator<Cat> it) {
        while (it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }
}

class Command {
    String name;

    public Command(String name) {
        this.name = name;
    }

    void operation() {
        System.out.println(this.name);
    }
}

class CommandFiller {
    Queue<Command> fill(List<Command> commands) {
        Queue<Command> commandQueue = new ArrayDeque<>();
        for (Command command : commands) {
            commandQueue.offer(command);
        }
        return commandQueue;
    }
}

class CommandConsumer {
    void consume(Queue<Command> commands) {
        while (!commands.isEmpty()) {
            commands.poll().operation();
        }
    }
}

class Cat {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cat named - " + this.name;
    }
}

class Generator {
    Collection<String> fill(Collection<String> collection) {
        collection.add("Heizenberg");
        collection.add("Fring");
        collection.add("Pinkman");
        collection.add("Hector");
        return collection;
    }

    Map<Integer, String> fill(TreeMap<Integer, String> map) {
        map.put(1, "Heizenberg");
        map.put(2, "Heizenberg");
        map.put(3, "Heizenberg");
        map.put(4, "Heizenberg");
        return map;
    }

}



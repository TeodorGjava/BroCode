package thinking.synchronizedMethod;

public class Table {
    public static void main(String[] args) {
        Table table = new Table();
        Thread1 t1 = new Thread1(table);
        Thread2 t2 = new Thread2(table);
        t1.start();
        t2.start();
    }

    synchronized void printTable(int n) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(n * i);
        }
        try {
            Thread.sleep(1);
        } catch (Exception e) {
            System.out.println("Exception");
        }
    }
}

class Thread1 extends Thread implements Runner {
    Table t;

    Thread1(Table t) {
        this.t = t;
    }

    @Override
    public void run() {
        t.printTable(100);

    }

}

class Thread2 extends Thread implements Runner {
    Table t;

    Thread2(Table t) {
        this.t = t;
    }

    @Override
    public void run() {
        t.printTable(20);
    }

}


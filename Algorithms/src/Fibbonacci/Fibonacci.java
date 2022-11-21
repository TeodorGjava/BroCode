package Fibbonacci;

import java.util.Scanner;

public class Fibonacci {

    public static int fib(int n) {
        if (n < 3) {
            return n;
        }
        int fibonacci = fib(n - 2) + fib(n - 1);
        return fibonacci;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        System.out.println(fib(n));
    }
}

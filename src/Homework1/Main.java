package Homework1;

import Homework1.Calculator;

public class Main {
    public static void main(String[] args) throws ArithmeticException {
        Calculator calc = Calculator.instance.get();
        int a = calc.plus.apply(1, 2);
        int b = calc.minus.apply(1,1);
        try {
            int c = calc.devide.apply(a, b);
            calc.println.accept(c);
        }catch (ArithmeticException e){
            System.out.println("Делить на ноль нельзя");
        }
        Worker.OnTaskDoneListener listener = System.out::println;
        Worker.OnTaskErrorListener errorListener = System.out::println;
        Worker worker = new Worker(listener, errorListener);
        worker.start();

    }
}

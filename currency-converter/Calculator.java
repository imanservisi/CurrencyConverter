import java.awt.GridLayout;

public class Calculator {

    public Calculator () {
    }

    public void add(double a, double b){
        double result = a + b;
        System.out.println(result);
    }

    public void subtract(double a, double b){
        double result = a - b;
        System.out.println(result);
    }

    public void multiply(double a, double b){
        double result = a * b;
        System.out.println(result);
    }

    public void divide(double a, double b){
        double result = a / b;
        System.out.println(result);
    }

   /* public static void main (String[] arg) {
        Calculator calculette = new Calculator();
        calculette.add(3, 2);
        calculette.divide(3, 2);
        calculette.multiply(3,2);
        calculette.subtract(3,2);
    }*/
}
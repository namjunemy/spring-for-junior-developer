package com.java.ex;

public class MainClass {
  public static void main(String[] args) {
    MyCalculator myCalculator = new MyCalculator();
    myCalculator.setCalculator(new Calculator());

    myCalculator.setFirst(10);
    myCalculator.setSecond(2);

    myCalculator.add();
    myCalculator.sub();
    myCalculator.mul();
    myCalculator.div();
  }
}

package com.java.ex;

public class MyCalculator {
  Calculator calculator;
  private int first;
  private int second;

  public MyCalculator() {

  }

  public void add() {
    calculator.addtion(first, second);
  }

  public void sub() {
    calculator.subtraction(first, second);
  }

  public void mul() {
    calculator.multiplication(first, second);
  }

  public void div() {
    calculator.division(first, second);
  }

  public void setCalculator(Calculator calculator) {
    this.calculator = calculator;
  }

  public void setFirst(int first) {
    this.first = first;
  }

  public void setSecond(int second) {
    this.second = second;
  }
}

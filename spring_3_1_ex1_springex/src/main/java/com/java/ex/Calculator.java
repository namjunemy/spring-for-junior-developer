package com.java.ex;

public class Calculator {
  public void addtion(int first, int second) {
    System.out.println("addtion()");
    int result = first + second;
    System.out.println(first + " + " + second + " = " + result);
  }

  public void subtraction(int first, int second) {
    System.out.println("subtraction()");
    int result = first - second;
    System.out.println(first + " - " + second + " = " + result);
  }

  public void multiplication(int first, int second) {
    System.out.println("multiplication()");
    int result = first * second;
    System.out.println(first + " * " + second + " = " + result);
  }

  public void division(int first, int second) {
    System.out.println("division()");
    int result = first / second;
    System.out.println(first + " / " + second + " = " + result);
  }
}

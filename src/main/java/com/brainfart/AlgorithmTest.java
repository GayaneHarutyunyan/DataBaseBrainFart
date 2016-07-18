package com.brainfart;


import java.util.Scanner;
import java.util.Stack;

/**
 * Created by gaya on 18.07.2016.
 */
public class AlgorithmTest {

    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("ВВедите списки символов = ");
        String str = scanner.next();

        int lengthArray = str.length();
        boolean flag = true;
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < lengthArray; i++) {
            String algorithmTest = str.substring(i, i + 1);
            if (algorithmTest.equals("(")) {
                stack.push(algorithmTest);
            } else if (algorithmTest.equals("{")) {
                stack.push(algorithmTest);
            } else if (algorithmTest.equals("[")) {
                stack.push(algorithmTest);
            } else if (algorithmTest.equals(")")) {
                if (stack.empty()) {
                    flag = false;
                    break;
                }
                if (stack.peek().equals("(")) {
                    stack.pop();
                } else {
                    flag = false;
                    break;
                }
            } else if (algorithmTest.equals("}")) {
                if (stack.empty()) {
                    flag = false;
                    break;
                }
                if (stack.peek().equals("{")) {
                    stack.pop();
                } else {
                    flag = false;
                    break;
                }
            } else if (algorithmTest.equals("]")) {
                if (stack.empty()) {
                    flag = false;
                    break;
                }
                if (stack.peek().equals("[")) {
                    stack.pop();
                } else {
                    flag = false;
                    break;
                }
            }
        }
        if (flag && stack.empty())
            System.out.println("true");
        else
            System.out.println("false");
    }
}




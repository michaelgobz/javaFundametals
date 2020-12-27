package com.michael.organised;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("The Operations are using an enum type");
        executeInteractively();
      performCalculation();
      System.out.println("The Calculate base Methods");
        Divider divider = new Divider();
        Adder adder = new Adder();
        Subtracter subtracter = new Subtracter();
        Multiplier multiplier = new Multiplier();
      doCalculation(divider,12.0d,3.0d);
      doCalculation(adder,34.0d,56.6d);
      doCalculation(subtracter,34.09d,56.0d);
      doCalculation(multiplier,34.0d,1234.90d);
      System.out.println();
      System.out.println("The Array Calculations");
      performArrayCalculations();
      System.out.println("Using the Interface Version ");
      processMathStatement();
    }

    private static void processMathStatement() {
        DynamicHelper helper  = new DynamicHelper(new MathProcessing[]{
            new Adder(),
                new Multiplier(),
                new Divider(),
                new Subtracter(),
                new PowerOf()
        });
        System.out.println("Enter an Operation and Two Numbers");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        helper.doProcess(userInput);

    }

    private static void performArrayCalculations() {
        CalculateBase[]calculateBases = {
                new Adder(34.0d,234.0d),
                new Multiplier(345.09d,490.09d),
                new Subtracter(243.90d,389.09d),
                new Divider(390.90d,38.90d)
        };

        for(CalculateBase calculateBase:calculateBases){
            calculateBase.calculate();
            System.out.println("The Result for the operations is = "+ calculateBase.getResult());
        }
    }

    public static void performCalculation(){
        MathEquation[] equations = new MathEquation[4];
        equations[0] = new MathEquation(100.0d,10.0d,'a');
        equations[1] = new MathEquation(25.0d,5.0d,'s');
        equations[2] = new MathEquation(45.0d,4.0d,'m');
        equations[3] = new MathEquation(23.3d,3.3d,'d');

        for (MathEquation equation:equations) {
            equation.execute();
            System.out.println("result = " + equation.getResult());
        }

        System.out.println("The average result = " + MathEquation.getAverageResult());
    }

    public static void doCalculation(CalculateBase calculateBase, double leftVal,double rightVal){
        calculateBase.setLeftVal(leftVal);
        calculateBase.setRightVal(rightVal);
        calculateBase.calculate();
        System.out.println("The Calculation result = " +calculateBase.getResult());

    }

    private static MathEquation create(double leftVal, double rightVal, char opCode) {
        MathEquation equation = new MathEquation();
        equation.setLeftVal(leftVal);
        equation.setRightVal(rightVal);
        equation.setOpCode(opCode);
        return equation;
    }



    private static void executeInteractively() {
        System.out.println("Enter an Operation and Two Numbers");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        String[] stringParts = userInput.split(" ");
        performOperation(stringParts);
    }

    private static void performOperation(String[] stringParts) {
        MathOperation operation = MathOperation.valueOf(stringParts[0].toUpperCase());
        double leftVal = Double.parseDouble(stringParts[1]);
        double rightVal = Double.parseDouble(stringParts[2]);

        CalculateBase calculateBase = createCalculation(operation,leftVal,rightVal);
        calculateBase.calculate();
        System.out.println("The operation was " + operation);
        System.out.println("And the Result was  = " + calculateBase.getResult());

    }

    private static void displayResult(char opCode, double leftVal, double rightVal, double result) {
        char sign = symbolForOpCode(opCode);

        String outPut = String.format("%.2f %c %.2f = %.2f", leftVal, sign, rightVal, result);
        System.out.println(outPut);
    }

    private static char symbolForOpCode(char opCode) {
        char[] opCodes = {'a', 's', 'm', 'd'};
        char[] symbols = {'+', '-', '*', '/'};
        char sign = ' ';
        for (int i = 0; i < opCodes.length; i++) {
            if (opCode == opCodes[i]) {
                sign = symbols[i];
                break;
            }
        }
        return sign;
    }

    private static double valueFromString(String stringPart) {
        String[] numberWords = {
                "zero", "one", "two", "three", "four",
                "five", "six", "seven", "eight", "nine"
        };
        double value = 0d;
        for (int index = 0; index < numberWords.length; index++) {
            if (stringPart.equals(numberWords[index])) {
                value = index;
                break;
            }
        }
        return value;
    }

    private static char opCodeFromString(String stringPart) {
        char opCode = stringPart.charAt(0);
        return opCode;
    }

    static double excute(char opCode, double leftVal, double rightVal) {
        double result = 0;
        switch (opCode) {
            case 'a':
                result = leftVal + rightVal;
                break;

            case 's':
                result = leftVal - rightVal;
                break;

            case 'm':
                result = leftVal * rightVal;
                break;

            case 'd':
                if (rightVal != 0) {
                    result = leftVal / rightVal;
                } else
                    System.out.println("cant divide with 0");
                break;
            default:
                System.out.println("that opCode is invalid");
                break;
        }
        return result;
    }

    static void handleCommandLine(String[] args) {
        char opCode = args[0].charAt(0);
        double leftVal = Double.parseDouble(args[1]);
        double rightVal = Double.parseDouble(args[2]);
        double result = excute(opCode, leftVal, rightVal);
        System.out.println(result);

    }

    public static CalculateBase createCalculation(MathOperation operation ,double leftVal, double rightVal){
        CalculateBase calculateBase = null;
        switch (operation){
            case ADD:
                calculateBase = new Adder(leftVal,rightVal);
                break;
            case DIVIDE:
                calculateBase = new Divider(leftVal,rightVal);
                break;
            case MULTIPLY:
                calculateBase = new Multiplier(leftVal ,rightVal);
                break;
            case SUBTRACT:
                calculateBase = new Subtracter(leftVal,rightVal);
        }

        return calculateBase;
    }

    private static void handleWhen(String[] parts) {
        LocalDate startDate = LocalDate.parse(parts[1]);
        long daysToAdd = (long) valueFromString(parts[2]);
        LocalDate newDate = startDate.plusDays(daysToAdd);
        String outPut = String.format("%s plus %d days is %s" ,startDate,daysToAdd,newDate);
        System.out.println(outPut);
    }
}

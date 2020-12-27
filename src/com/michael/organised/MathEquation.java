package com.michael.organised;

public class MathEquation {
    private char opCode;
    private double leftVal;
    private double rightVal;
    private double result;
    public static double sumOfResults;
    public static double nuumberOfCalculation;

    public MathEquation(){

    }

    public MathEquation(char opCode){
        this.opCode = opCode;
    }

    public  MathEquation(double leftVal,double rightVal,char opCode){
        this(opCode);
        this.leftVal = leftVal;
        this.rightVal = rightVal;
    }



    double execute() {
        result = 0;
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

        nuumberOfCalculation ++;
        sumOfResults += result;
        return result;
    }

    public static double getAverageResult(){
        return sumOfResults / nuumberOfCalculation;
    }

    public double getResult(){
        return result;
    }

    public void setOpCode(char opCode){
        this.opCode = opCode;
    }
    public void setLeftVal(double leftVal){
        this.leftVal = leftVal;
    }

    public void setRightVal(double rightVal) {
        this.rightVal = rightVal;
    }

}

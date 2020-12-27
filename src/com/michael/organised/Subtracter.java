package com.michael.organised;

public class Subtracter extends CalculateBase implements MathProcessing {

    public Subtracter(){
    }

    public Subtracter(double leftVal,double rightVal){
        super(leftVal,rightVal);
    }
    @Override
    public void  calculate(){

        double value = getLeftVal() - getRightVal();
        setResult(value);
    }

    @Override
    public String getKeyWord() {
        return "subtract";
    }

    @Override
    public double doCalculation(double leftVal, double rightVal) {
        setLeftVal(leftVal);
        setRightVal(rightVal);
        return getResult();
    }
}


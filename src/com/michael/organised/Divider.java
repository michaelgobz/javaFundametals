package com.michael.organised;


public class Divider extends  CalculateBase implements MathProcessing{

    public Divider(){

    }

    public Divider(double leftVal,double rightVal){
        super(leftVal,rightVal);
    }
    @Override
    public void calculate(){
        if(getRightVal() != 0 ) {
            double value = getLeftVal() / getRightVal();
            setResult(value);
        }else {
            System.out.println("division by a Zero is mathematically meaningless");
        }
    }

    @Override
    public String getKeyWord() {
        return "divide";
    }

    @Override
    public double doCalculation(double leftVal, double rightVal) {
        setLeftVal(leftVal);
        setRightVal(rightVal);
        return getResult();
    }
}

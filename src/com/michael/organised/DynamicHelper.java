package com.michael.organised;

public class DynamicHelper {
    private final MathProcessing[] processings;

    public DynamicHelper(MathProcessing[] processings){
        this.processings = processings;
    }

    public void doProcess(String statement){
        String[] statementParts = statement.split(MathProcessing.SEPARATER);
        String keyWord = statementParts[0];
        double leftVal = Double.parseDouble(statementParts[1]);
        double rightVal = Double.parseDouble(statementParts[2]);

        MathProcessing processing = null;
        for(MathProcessing process :processings){
            if(keyWord.equalsIgnoreCase(process.getKeyWord())){
                processing = process;
                break;
            }
        }

        double result = processing.doCalculation(leftVal,rightVal);
        System.out.println();
        System.out.println("The Result is = " + result);
    }

}

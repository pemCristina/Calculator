package es.telefonica.talentum.calculadora.model;

import static es.telefonica.talentum.calculadora.model.CalculatorOperation.NONE;

/**
 * Created by usuario on 18/01/2017.
 */

public class Calculator {

    private float num1;
    private float num2;
    private CalculatorOperation operation;

    public float getNum1() {
        return num1;
    }

    public void setNum1(float num1) {
        this.num1 = num1;
    }

    public float getNum2() {
        return num2;
    }

    public void setNum2(float num2) {
        this.num2 = num2;

    }

    public CalculatorOperation getOperation() {
        return operation;
    }

    public void setOperation(CalculatorOperation operation) {
        this.operation = operation;
    }

    public float calculate(float num1, float num2, CalculatorOperation operation) {
        float result = 0.0f;
        switch (operation) {
            case NONE:
                result =  0.0f;
                break;
            case ADD:
                result = add(num1, num2);
                break;
            case SUBTRACT:
                result = subtract(num1, num2);
                break;
            case MULTIPLY:
                result = multiply(num1, num2);
                break;
            case DIVIDE:
                result = divide(num1, num2);
                break;
        }
        return result;
    }

    public void clear() {
        num1 = 0.0f;
        num2 = 0.0f;
        operation = NONE;
    }

    private float add(float num1, float num2) {
        return num1 + num2;
    }

    private float subtract(float num1, float num2) {
        return num1 - num2;
    }

    private float multiply(float num1, float num2) {
        return num1 * num2;
    }

    private float divide(float num1, float num2) {
        if(num2 != 0) {
            return num1 / num2;
        } else {
            return 0;
        }
    }
}

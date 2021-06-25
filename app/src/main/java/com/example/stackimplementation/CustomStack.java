package com.example.stackimplementation;

import java.util.Stack;

public class CustomStack extends Stack<String> {
    private String[] stackArray;

    public CustomStack() {
        stackArray = new String[1];
        stackArray[0] = "Hello world";
    }

    @Override
    public synchronized String pop() {
        int lengthOfNewArray = this.size() -1;
        String[] tempArray = new String[lengthOfNewArray];
        int i;
        for(i=0;i<lengthOfNewArray;i++){
            tempArray[i] = stackArray[i];
        }
        stackArray = tempArray;

        return super.pop();
    }

    @Override
    public String push(String item) {
        super.push(item);
        int length = this.size();
        stackArray = new String[length];
        stackArray[length-1] = item;

        return super.push(item);
    }

    public String[] getStackArray(){
        return stackArray;
    }
}

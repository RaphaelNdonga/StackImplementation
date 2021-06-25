package com.example.stackimplementation;

import java.util.Stack;

public class CustomStack extends Stack<String> {
    private String[] stackArray;

    public CustomStack() {
        stackArray = new String[this.size()];
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
        int length = this.size();
        String [] tempArray = new String[50];
        for(int i=0;i<length;i++){
            tempArray[i] = stackArray[i];
        }
        tempArray[length] = item;
        stackArray = tempArray;

        return super.push(item);
    }

    public String[] getStackArray(){
        return stackArray;
    }
}

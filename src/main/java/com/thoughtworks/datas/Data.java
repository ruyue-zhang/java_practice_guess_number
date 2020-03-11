package com.thoughtworks.datas;

import com.thoughtworks.getAnswer.Answer;

import java.util.ArrayList;
import java.util.List;

public class Data {
    private List<String> inputData = new ArrayList<>();
    private List<String> tipsInfo = new ArrayList<>();

    public Data() { }

    public List<String> getInputData() {
        return inputData;
    }

    public void addInputData(String inputString) {
        inputData.add(inputString);
    }

    public List<String> getTipsInfo() {
        return tipsInfo;
    }

    public void addTipsInfo(String tipsString) {
        tipsInfo.add(tipsString);
    }

    public boolean isRightInput(String inputString) {
        Answer a = new Answer();
        return a.isRightful(inputString);
    }

    public String judgeOutput(String inputString, String answer) {
        char[] c = inputString.toCharArray();
        char[] answerChar = answer.toCharArray();
        int correct = 0;
        int wrongPosition = 0;
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < answerChar.length; j++) {
                if(c[i] == answerChar[j]) {
                    if(i == j) {
                        correct++;
                    } else {
                        wrongPosition++;
                    }
                }
            }
        }
        return correct + "A" + wrongPosition + "B";
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < inputData.size(); i++) {
            result += inputData.get(i) + " " +tipsInfo.get(i) + "\n";
        }
        return result;
    }
}

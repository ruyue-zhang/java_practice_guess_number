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
        if(!isRightInput(inputString)) {
            addTipsInfo("wrong input");
        }
        inputData.add(inputString);
    }

    public List<String> getTipsInfo() {
        return tipsInfo;
    }

    public void addTipsInfo(String tipsString) {
        tipsInfo.add(tipsString);
    }

    private boolean isRightInput(String inputString) {
        Answer a = new Answer();
        return a.isRightful(inputString);
    }

    public boolean judgeOutput(String inputString, String answer) {
        if(inputString.equals(answer)) {
            return true;
        }
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
        String tips = correct + "A" + wrongPosition + "B";
        addTipsInfo(tips);
        return false;
    }


}

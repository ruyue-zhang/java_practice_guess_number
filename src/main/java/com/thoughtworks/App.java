package com.thoughtworks;


import com.thoughtworks.datas.Data;
import com.thoughtworks.getAnswer.Answer;

public class App {

  public static void main(String[] args){
    //得到答案
    Answer  a = new Answer();
    String answer = a.readAnswer();
    if(a.isRightful(answer)) {
      Data data = new Data();
      System.out.println(data.judgeOutput("2478", answer));
    }
  }
}

package com.thoughtworks;


import com.thoughtworks.datas.Data;
import com.thoughtworks.getAnswer.Answer;

import java.util.Scanner;

public class App {

  public static void main(String[] args){
    Answer  a = new Answer();
    String answer = a.readAnswer();
    Data data = new Data();
    int i = 6;
    while(i > 0) {
      if(0 != data.getInputData().size()) {
        System.out.println(data.toString());
      }
      Scanner input = new Scanner(System.in);
      String inputString = input.next();
      data.addInputData(inputString);
      if(inputString.equals(answer)) {
        System.out.println("Congratulations, you win!");
        return;
      } else if(!data.isRightInput(inputString)) {
        i++;
        data.addTipsInfo("wrong input！");
      } else {
        data.addTipsInfo(data.judgeOutput(inputString, answer));
      }
      i--;
    }
    System.out.println("Unfortunately, you have no chance, the answer is "+ answer + "!");
  }
}

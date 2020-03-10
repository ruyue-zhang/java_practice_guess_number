package com.thoughtworks.getAnswer;

import com.sun.deploy.util.StringUtils;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;


public class Answer implements AnswerInterface {
    @Override
    public String readAnswer() {
        File file = new File("C:\\ruyue\\java\\ThoughtWorks\\homework\\java_practice_guess_number\\src\\main\\resources\\answer.txt");
        String answer = "";
        try(Reader reader = new FileReader(file)) {
            char[] data = new char[20];
            int len;
            while(-1 != (len = reader.read(data))) {
                answer = new String(data, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return answer;
    }

    @Override
    public String creatAnswer() {
        Set<String> answer = new HashSet<>(4);
        Random random = new Random();
        while(answer.size() != 4) {
            answer.add(String.valueOf(random.nextInt(10)));
        }
        return StringUtils.join(answer, "");
    }

    @Override
    public boolean isRightful(String answer) {
        if(answer.length() != 4) {
            return false;
        }
        char[] ch = answer.toCharArray();
        Set<Character> set = new HashSet<>();
        for(char c : ch) {
            if(c - 48 < 0 || c - 48 > 9) {
                return false;
            }
            set.add(c);
        }
        return 4 == set.size();
    }
}

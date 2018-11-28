package com.trud.algorithm.kakako;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class KakaoBlind2018_1 {
    public static void main(String[] args) {
        String[] input = new String[]{"Enter uid1234 Muzi",
                "Enter uid4567 Prodo",
                "Leave uid1234",
                "Enter uid1234 Prodo",
                "Change uid4567 Ryan"};

        System.out.println(solution(input));
    }

    public static String[] solution(String[] record) {
        List<String> list = new ArrayList<>();
        String[] temp = new String[3];
        HashMap<String, String> mapTest = new HashMap<>();


        for (int i = 0; i < record.length; i++) {
            temp = record[i].split(" ");
            if (!temp[0].equals("Leave")) {
                mapTest.put(temp[1], temp[2]);
            }
        }

        for (int i = 0; i < record.length; i++) {
            temp = record[i].split(" ");
            if (record[i].contains("Enter")) {
                list.add(String.format("%s님이 들어왔습니다.", mapTest.get(temp[1])));
            }
            if (record[i].contains("Leave")) {
                list.add(String.format("%s님이 나갔습니다.", mapTest.get(temp[1])));
            }
        }
        String[] answer = new String[list.size()];
        for (int i = 0; i < list.size() ; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}

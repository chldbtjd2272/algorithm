package com.trud.algorithm.kakako;

import java.util.Arrays;

public class KakaoBlind2018_4 {

    public static void main(String[] args) {
        int[] food_times = {3, 1, 2};
        long k = 5;
        System.out.println(solution(food_times, k));
    }


    public static int solution(int[] food_times, long k) {
        int answer = 0;
        for (int i = 0; i < food_times.length; i++) {
            answer += food_times[i];
        }
        if (answer <= k) {
            return -1;
        }
        answer = 0;

        while (true) {
            if (k == 0) {
                break;
            }
            answer = getIndex(food_times, answer);
            if (answer == -1) {
                return answer;
            }
            food_times[answer] -= 1;
            answer++;
            k--;
        }
        answer = getIndex(food_times, answer);
        return answer + 1;
    }

    public static int getIndex(int[] food_times, int index) {

        if (food_times.length == index) {
            index = 0;
        }

        if (food_times[index] == 0) {
            if (food_times.length - 1 == index) {
                index = 0;
            } else {
                index++;
            }
            return getIndex(food_times, index);
        }
        return index;
    }
}

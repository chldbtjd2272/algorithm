package com.trud.algorithm.kakako;

import java.util.Arrays;

public class KakaoBlind2018_2 {
    public static void main(String[] args) {
        int[] test = new int[]{1,1,1};

        solution(4, test);

    }

    public static int[] solution(int N, int[] stages) {
        Arrays.sort(stages);
        float[] test = new float[N + 2];
        int[] answer = new int[N];
        int num = stages.length;
        for (int i = 0; i < stages.length; i++) {
            test[stages[i]] += 1;
        }
        for (int i = 1; num != 0; i++) {
            float rem = test[i] / num;
            num -= test[i];
            test[i] = rem;
        }

        int index = 0;
        for (int i = 1; i <= N; i++) {
            float max = 0;
            int result = N;
            for (int j = 1; j < N +1; j++) {
                if (max < test[j]) {
                    max = test[j];
                    result = j;
                } else if (max == test[j]) {
                    result = result > j ? j : result;
                }
            }
            test[result] = -1;
            answer[index] = result;
            index++;
        }

        for (int i = 0; i <answer.length ; i++) {
            System.out.println(answer[i]);
        }

        return answer;
    }
}

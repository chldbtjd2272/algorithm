package com.trud.algorithm.kakako;

import java.util.Arrays;
import java.util.Comparator;

public class KaKaoBlind2018_4_2 {
    public static void main(String[] args) {
        int[] food_times = {2, 1, 2, 10};
        long k = 8;
        System.out.println(solution(food_times, k));
    }

    public static int solution(int[] food_times, long k) {
        int answer = 0;
        int size = food_times.length;

        int[][] arr = new int[size][size];
        int result = 0;
        for (int i = 0; i < size; i++) {
            arr[i][0] = i;
            arr[i][1] = food_times[i];
            result += food_times[i];
        }

        if (result <= k) {
            return -1;
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });


        if (size <= k) {
            long removeIndex = k / size;
            long remainIndex = k % size;
            int startIndex = 0;
            for (int i = 0; i < size; i++) {
                if (arr[i][1] - removeIndex <= 0) {
                    remainIndex += removeIndex - arr[i][1];
                    arr[i][1] = 0;
                    startIndex = i + 1;
                } else {
                    arr[i][1] = (int) (removeIndex - arr[i][0]);
                }
            }

            int tempIndex = startIndex;

            while (true) {
                if (remainIndex == 0) {
                    break;
                }
                arr[startIndex][1] -= 1;

                if (startIndex == size -1) {
                    startIndex = tempIndex;
                    remainIndex--;
                }else{
                    startIndex++;
                    remainIndex--;
                }
            }
            answer = startIndex;
        } else {
            for (int i = 0; i < size; i++) {
                if (k == 0) {
                    answer = i + 1;
                    break;
                }
                arr[i][1] -= 1;
            }
        }

        answer = arr[answer][0] + 1;


        return answer;
    }
}

package com.trud.algorithm.kakako;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KakaoBlind2018_3 {

    public static void main(String[] args) {
        String[][] test = new String[][]{{"100", "ryan", "music", "2"}, {"200", "apeach", "math", "2"},
                {"300", "tube", "computer", "3"}, {"400", "con", "computer", "4"}, {"500", "muzi", "music", "3"},
                {"600", "apeach", "music", "2"}};
        System.out.println(solution(test));

    }

    public static int solution(String[][] relation) {
        int answer = 0;
        List<Set<String>> list = new ArrayList<>();
        List<Integer[]> check = new ArrayList<>();

        for (int i = 0; i < relation[0].length; i++) {
            List<Integer[]> temp = new ArrayList<>();
            int[] arr = new int[relation[0].length];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = j;
            }
            int n = arr.length;
            int r = i + 1;
            int[] combArr = new int[n];
            doCombination(combArr, n, r, 0, 0, arr,temp);
            for (Integer[] integers : temp) {
                list.add(check(integers, relation,check));
            }
        }
        for (Set<String> set : list) {
               if(set.size() == relation.length){
                   answer++;
               }
        }
        return answer;
    }

    public static void doCombination(int[] combArr, int n, int r, int index, int target, int[] arr,List<Integer[]> temp) {

        if (r == 0) {
            Integer[] rem = new Integer[index];
            for (int i = 0; i < index; i++) {
                rem[i] = combArr[i];
            }
            temp.add(rem);

        } else if (target == n) {
            return;
        } else {
            combArr[index] = target;

            doCombination(combArr, n, r - 1, index + 1, target + 1, arr,temp);

            doCombination(combArr, n, r, index, target + 1, arr,temp);
        }
    }

    public static Set<String> check(Integer[] integers, String[][] test,List<Integer[]> check) {
        Set<String> set = new HashSet<>();

        for (Integer[] integers1 : check) {
            Set<String> set1 = new HashSet<>();
            for (int i = 0; i <integers.length ; i++) {
                set1.add(integers[i].toString());
            }
            for (int i = 0; i <integers1.length ; i++) {
                set1.add(integers1[i].toString());
            }
            if(set1.size() == integers.length){
                return new HashSet<>();
            }
        }

            for (int j = 0; j < test.length; j++) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < integers.length; i++) {
                    stringBuilder.append(test[j][integers[i]]);
                }
                set.add(stringBuilder.toString());
            }
        if(set.size() == test.length){
            check.add(integers);
        }
        return set;
    }
}


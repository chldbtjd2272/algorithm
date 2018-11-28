package com.trud.algorithm.kakako;

public class KakaoBlind2017_1 {
    public static void main(String[] args) {
        int[] arr1 = new int[]{9, 20, 28, 18, 11};
        int[] arr2 = new int[]{30, 1, 21, 17, 28};
        solution(5, arr1, arr2);
    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] map1 = new String[n];
        String[] map2 = new String[n];
        String[] result = new String[n];
        updateMap(map1,arr1,n);
        updateMap(map2,arr2,n);

        for (int i = 0; i < n; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if(map1[i].charAt(j) == '1' || map2[i].charAt(j) == '1'){
                    stringBuilder.append("#");
                }else{
                    stringBuilder.append(" ");
                }
            }
            result[i] = stringBuilder.toString();
        }
        return result;
    }

    public static void updateMap(String[] map,int[] arr,int n){
        for (int i = 0; i < arr.length; i++) {
            String row = Integer.toBinaryString(arr[i]);
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = row.length(); j != n ; j++) {
                stringBuilder.append("0");
            }
            stringBuilder.append(row);
            map[i] = stringBuilder.toString();
        }
    }
}

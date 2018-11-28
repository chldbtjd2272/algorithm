package com.trud.algorithm.kakako;

public class KakaoBlind2017_2 {
    public static void main(String[] args) {
        String[] test = {"1S2D*3T",
        "1D2S#10S",
        "1D2S0T",
        "1S*2T*3S",
        "1D#2S*3S",
        "1T2D3D#",
        "1D2S3T*"};

        for (String s : test) {
            System.out.println(solution(s));
        }
    }

    public static int solution(String dartResult) {
        int temp = 0;
        int[] result = new int[3];
        int resultIndex = 0;
        int count = 0;
        int bonus = 0;
        int option = 0;


        for (int i = 0; i < dartResult.length(); i++) {
            if (i == 0 || (dartResult.charAt(i -1) >= 48 && dartResult.charAt(i -1) <= 57 && i != dartResult.length() -1)) {
                continue;
            }
            String cost = "";
            if (dartResult.charAt(i) >= 48 && dartResult.charAt(i) <= 57) {
                cost = dartResult.substring(temp, i);
                temp = i;
            }

            if (i == dartResult.length() - 1) {
                cost = dartResult.substring(temp, i + 1);
            }

            if (!cost.equals("")) {
                int rem = 0;
                if (cost.charAt(1) >= 48 && cost.charAt(1) <= 57) {
                    count = Integer.parseInt(cost.substring(0, 2));
                    rem = 2;
                } else {
                    count = Integer.parseInt(cost.substring(0, 1));
                    rem = 1;
                }
                bonus = checkBonus(cost.charAt(rem));
                if (cost.contains("*") || cost.contains("#")) {
                    option = checkOption(cost.charAt(rem + 1));
                }
                result[resultIndex] = (int) Math.pow(count, bonus);
                resultIndex++;
                cost = "";
            }

            if (option == 2) {
                result[resultIndex - 1] *= option;
                if (resultIndex - 1 != 0) {
                    result[resultIndex - 2] = result[resultIndex - 2] * option;
                }
            } else if (option == -1) {
                result[resultIndex - 1] *= option;
            }

            count = 0;
            bonus = 0;
            option = 0;
        }
        int sum = 0;
        for (int i = 0; i < result.length; i++) {
            sum += result[i];
        }
        return sum;
    }

    public static int checkBonus(char c) {
        if (c == 'S') {
            return 1;
        } else if (c == 'D') {
            return 2;
        } else {
            return 3;
        }
    }

    public static int checkOption(char c) {
        if (c == '*') {
            return 2;
        } else {
            return -1;
        }
    }

}

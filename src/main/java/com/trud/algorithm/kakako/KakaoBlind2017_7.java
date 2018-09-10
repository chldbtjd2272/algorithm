package com.trud.algorithm.kakako;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class KakaoBlind2017_7 {
    public static void main(String[] args) throws ParseException {
        String[] lines = new String[]{"2016-09-15 01:00:04.002 2.0s", "2016-09-15 01:00:07.000 2s"};
        System.out.println(solution(lines));
    }

    public static int solution(String[] lines) throws ParseException {
        int result = 0;
        long[] startDate = new long[lines.length];
        long[] endDate = new long[lines.length];

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

        for (int i = 0; i < lines.length; i++) {
            String[] splitLine = lines[i].split(" ");
            endDate[i] = sdf.parse(String.format("%s %s", splitLine[0], splitLine[1])).getTime();
            int millisecondTime = (int) (Double.parseDouble(splitLine[2].replace("s", "")) * 1000);
            startDate[i] = endDate[i] - millisecondTime + 1;
        }

        for (int i = 0; i < lines.length; i++) {
            result = check(startDate,endDate,result,i);
            result = check(endDate,startDate,result,i);
        }
        return result;
    }

    public static int check ( long[] startDate, long[] endDate, int result, int index){
        long checkStart = startDate[index];
        long checkEnd = checkStart + 999l;

        int temp = 0;
        for (int i = 0; i <startDate.length ; i++) {
            if (checkEnd >= startDate[i] && checkStart <= startDate[i]) {
                temp++;
            } else if (checkEnd >= endDate[i] && checkStart <= endDate[i]) {
                temp++;
            } else if (checkEnd <= endDate[i] && checkStart >= startDate[i]) {
                temp++;
            }
        }

        result = result > temp ? result : temp;
        return result;
    }
}

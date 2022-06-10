package com.company.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class solution2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            LocalTime[][] time = new LocalTime[n][2];
            for (int i = 0; i < n; i++) {

                String[] tm = br.readLine().trim().split(" ");
                if (tm[0].equals("24:00:00")) {
                    tm[0] = "00:00:00";
                }
                if (tm[1].equals("24:00:00")) {
                    tm[1] = "00:00:00";
                }
                time[i][0] = LocalTime.parse(tm[0]);
                time[i][1] = LocalTime.parse(tm[1]);
            }
            String[] ans = minMatrix(n, time);
            System.out.println(ans[0] + " " + ans[1]);
        }

    }

    private static String[] minMatrix(int n, LocalTime[][] time) {
        PriorityQueue<LocalTime> priorityQueue = new PriorityQueue<>(
                n,
                Comparator.comparing(o -> o)
        );
        Arrays.sort(time, Comparator.comparing((o -> o[0])));
        priorityQueue.add(time[0][1]);
//        int maxSf = 1;
//        LocalTime totalTime = LocalTime.parse("00:00:00");
//        totalTime = totalTime.plus(Duration.between(time[0][0], time[0][1]).toMinutes(),
//                ChronoUnit.MINUTES);

        for (int i = 1; i < n; i++) {
            if (time[i][0].equals(priorityQueue.peek()) || time[i][0].isAfter(
                    priorityQueue.peek())) {
                priorityQueue.poll();
            }
            priorityQueue.add(time[i][1]);
        }
        int tot = priorityQueue.size();
        PriorityQueue<LocalTime[]> pq = new PriorityQueue<>(
                n,
                Comparator.comparing(o -> o[1])
        );
        pq.add(time[0]);
        int msf = 1;
        LocalTime totalTime = LocalTime.parse("00:00:00");
        for (int i = 1; i < n; i++) {
            if (time[i][0].equals(pq.peek()[1]) || time[i][0].isAfter(
                    pq.peek()[1])) {
                pq.poll();
            }
            pq.add(time[i]);
            if (pq.size() == tot) {
                LocalTime[] lq = new LocalTime[2];
                lq[0] = pq.peek()[0];
                lq[1] = pq.peek()[1];
                for (LocalTime[] t : pq) {
                    if (t[0].isAfter(lq[0])) {
                        lq[0] = t[0];
                    }
                    if (t[1].isBefore(lq[1])) {
                        lq[1] = t[1];
                    }
                }
                totalTime = totalTime.plus(Duration.between(lq[0], lq[1]).toSeconds(),
                        ChronoUnit.SECONDS);
            }
        }
        //System.out.println(Arrays.toString(priorityQueue.toArray()));
        return new String[]{String.valueOf(tot), String.valueOf(totalTime)};
    }


}

package com.myproject.exception;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Test {

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int sum = 0;
        int weights[] = new int[n];
        List<Integer> changedList = new ArrayList<>();
        List<Integer> dischangedList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            weights[i] = scan.nextInt();
            sum = sum + weights[i];
        }
        int averageWeight = sum / n;
        if (sum % n != 0) {
            System.out.println(-1);
            return;
        } else {
            for (int i = 0; i < n; i++) {
                changedList.add(weights[i] - averageWeight);
                dischangedList.add(weights[i] - averageWeight);
            }
        }
        Collections.sort(changedList);
        Collections.sort(dischangedList, Collections.reverseOrder());
        int size = changedList.size();
        int size2=dischangedList.size();
        int moves = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size2; j++) {
                if (changedList.get(i) < 0 && dischangedList.get(j) > 0) {
                    if ((changedList.get(i) + dischangedList.get(j))>=0) {
                        int diff = dischangedList.get(j)+changedList.get(i);
                          moves = moves + changedList.get(i) + averageWeight;
                        //moves = moves+1;(if we consider moving at once is one move then this should be the move calculation u can try)
                        dischangedList.add(j, diff);
                        break;
                    } else {
                        moves = moves + dischangedList.get(j);
                        //moves = moves+1;(if we consider moving at once is one move then this should be the move calculation u can try)
                       changedList.add(i,changedList.get(i) + dischangedList.get(j));
                        dischangedList.add(j, 0);
                    }
                }

            }
        }
        System.out.println(moves);
    }
}

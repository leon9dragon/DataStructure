package com.leetcode.array_problem.p0118;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {

    public static void main(String[] args) {
        //System.out.println(new ArrayList<Integer>(Arrays.asList(1,2,3)));
        List<List<Integer>> list = generate(7);
        System.out.println(list);
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        createList(list, numRows);
        return list;
    }

    public static void createList(List<List<Integer>> list, int numRows) {
        //stop this function when the list add enough rows
        if (list.size() == numRows) {
            return;
        }
        //init the first row
        if (list.size() == 0) {
            list.add(new ArrayList<>(Arrays.asList(1)));
            createList(list, numRows);
        }
        //init the second row
        else if (list.size() == 1) {
            list.add(new ArrayList<>(Arrays.asList(1, 1)));
            createList(list, numRows);
        }
        //when the list has more than 2 rows
        else {
            ArrayList arrayList = new ArrayList();
            //add the first element
            arrayList.add(1);

            //add the elements between the first element and the last one
            for (int i = 1; i < list.size(); i++) {
                arrayList.add(list.get((list.size() - 1)).get(i - 1) + list.get((list.size() - 1)).get(i));
            }

            //add the last element
            arrayList.add(1);
            list.add(arrayList);
            createList(list, numRows);
        }
    }
}

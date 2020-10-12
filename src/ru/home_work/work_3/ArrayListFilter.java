package ru.home_work.work_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//#3.2
public class ArrayListFilter {
    public static void main(String[] args) {
        var arr = new ArrayList<>(Arrays.asList(1, 3, 5, 7, 7, 9, 1, 15, 2, 3, 5, 5, 6, 10, 5, 15));
        System.out.println(arrayListFilter(arr));
    }

    public static ArrayList<Integer> arrayListFilter(ArrayList<Integer> list) {
//        Написать функцию, которая убирает одинаковые значения из списка.
//        1 1 1 1 2 2 3 4 5
//        Результат программы:
//        1 2 3 4 5
//        *******************
        var newList = new ArrayList<Integer>();
        newList.add(list.get(0));
        Collections.sort(list);
        for (int i = 1; i < list.size(); i++)
            if (list.get(i).equals(list.get(i - 1)))
                newList.add(list.get(i));
        return newList;
    }
}

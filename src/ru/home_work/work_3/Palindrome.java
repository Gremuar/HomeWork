package ru.home_work.work_3;

//#3.1
public class Palindrome {
//    Текст задания:
//     (с помощью рекурсии) Написать функцию, которая проверяет, является ли слово палиндромом. Палиндром - это слово, читающееся в обоих направлениях одинаково. Например, "топот", "доход".
//    Для получения символа из строки используйте:
//
//    String a = "топот";
//    var symbol = a.charAt(0); // первая буква
//    **************
    public static void main(String[] args) {
        System.out.println(isPalindrome("ТопоТ"));
        System.out.println(isPalindrome("Яя"));
        System.out.println(isPalindrome(null));
    }

    public static boolean isPalindrome(String word) {
        word = word != null ? word.toLowerCase() : "";
        int wLen = word.length();
        if (wLen == 2)
            return word.charAt(0) == word.charAt(1);
        else if (wLen < 2 || wLen % 2 == 0) {
            return false;
        }
        else if (wLen == 3) {
            return word.charAt(0) == word.charAt(wLen - 1);
        } else if (word.charAt(0) == word.charAt(wLen - 1)) {
            return isPalindrome(word.substring(1, wLen - 1));
        } else
            return false;
    }
}

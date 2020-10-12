package ru.home_work.work_3;

//#3.1
public class Palindrome {
    public static void main(String[] args) {
        System.out.println(IsPalindrome("ТопоТ"));
    }
    public static boolean IsPalindrome(String word) {
        word = word.toLowerCase();
        int wLen = word.length();
        if(wLen < 3 || wLen % 2 == 0)
            return false;
        else if(wLen == 3) {
            return word.charAt(0) == word.charAt(wLen - 1);
        }
        else if(word.charAt(0) == word.charAt(wLen - 1)) {
            return IsPalindrome(word.substring(1, wLen - 1));
        }
        else
            return false;
    }
}

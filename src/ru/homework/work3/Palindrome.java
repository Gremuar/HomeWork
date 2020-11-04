package ru.homework.work3;

//#3.1
public class Palindrome {
  /*
    Текст задания:
    (с помощью рекурсии) Написать функцию, которая проверяет, является ли слово палиндромом.
    Палиндром - это слово, читающееся в обоих направлениях одинаково. Например, "топот", "доход".
    Для получения символа из строки используйте:

    String a = "топот";
    var symbol = a.charAt(0); // первая буква
   */

  /**
   * The entry point of application.
   *
   * @param args the input arguments
   */
  public static void main(String[] args) {
    System.out.println(isPalindrome("ТопоТ"));
    System.out.println(isPalindrome("Яя"));
    System.out.println(isPalindrome(null));
  }

  /**
   * Is palindrome boolean.
   *
   * @param word the word
   * @return the boolean
   */
  public static boolean isPalindrome(String word) {
    word = word != null ? word.toLowerCase() : "";
    int wordLen = word.length();
    if (wordLen == 2) {
      return word.charAt(0) == word.charAt(1);
    } else if (wordLen < 2 || wordLen % 2 == 0) {
      return false;
    } else if (wordLen == 3) {
      return word.charAt(0) == word.charAt(wordLen - 1);
    } else if (word.charAt(0) == word.charAt(wordLen - 1)) {
      return isPalindrome(word.substring(1, wordLen - 1));
    } else {
      return false;
    }
  }
}

package ru.home_work.work_7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Balda {
    private String word;
    private HashMap<Character, Integer> mWord;
    private ArrayList<Player> players;
    private Player activePlayer;
    private boolean stop;
    private Scanner input;
    private Player winner;
    private ArrayList<String> allVariants;

    protected Balda() {
        this.word = "";
        this.players = new ArrayList<>();
        this.allVariants = new ArrayList<>();
        this.input = new Scanner(System.in);
    }

    public boolean newGame() {
        int numPlayers;
        String variant;
        clear();
        System.out.print("Количество игроков: ");
        if (input.hasNextInt())
            numPlayers = input.nextInt();
        else {
            System.out.println("Введите целое число игроков");
            return false;
        }
        if (numPlayers <= 0) {
            System.out.println("Количество игроков должно быть больше 0");
            return false;
        }
        for (int i = 1; numPlayers > 0; numPlayers--, i++) {
            System.out.print("Введите имя игрока №" + i + ": ");
            players.add(new Player(input.next()));
        }
        System.out.print("Введите стартовое слово: ");
        word = input.next().toLowerCase();
        if (word.isBlank()) {
            System.out.println("Слово не может быть пустым");
            return false;
        }
        mWord = wordToMap(word);
        activePlayer = players.get(0);
        System.out.println("Начинаем игру.\n" +
                "Список игроков: " + getPList() + "\n" +
                "За каждую букву в успешном варианте будет начислятся по 1 очку\n" +
                "********************************************"
        );
        input.nextLine();
        while (!stop) {
            System.out.println("Игрок " + activePlayer.name + " соберите слово из букв слова: " + word);
            variant = input.nextLine().split(" ")[0];
            if (variant.isBlank()) {
                if (voteEnd()) {
                    endGame();
                    return true;
                } else continue;
            }
            if (checkVariant(variant)) {
                allVariants.add(variant);
                activePlayer.words.add(variant);
                activePlayer.score += variant.length();
                System.out.println("Вариант засчитан. Начислено: " + variant.length() + " очков.");
                nextPlayer();
            } else System.out.println("Ошибка! Попробуйте снова.");
        }
        return true;
    }

    public void endGame() {
        stop = true;
        getWinner();
        System.out.println("Игра окончена");
        if (winner.score == 0) return;
        System.out.println("Победил " + winner.name + " набрав " + winner.score + " очков.");
        System.out.println("Результаты: \n" + getScore());
    }

    public String getPList() {
        String pList = "";
        for (Player player : players) pList += player.name + ", ";
        return pList.substring(0, pList.length() - 2);
    }

    public String getScore() {
        var score = "";
        for (Player player : players) {
            score += player.name + ": " + player.score + "\n";
        }
        return score;
    }

    private boolean voteEnd() {
        int voteCount = 1;
        String vote;
        System.out.println("Игрок " + activePlayer.name + " предлагает завершить игру");
        for (Player player : players) {
            if (player == activePlayer) continue;
            nextPlayer();
            System.out.println("Игрок " + activePlayer.name + " если вы согласны, введите пустую строку");
            vote = input.nextLine().toLowerCase();
            if (!vote.isBlank()) {
                System.out.println("Голосование отменено");
                break;
            } else {
                voteCount++;
            }
            if (voteCount == players.size()) return true;
        }
        return false;
    }

    private void getWinner() {
        winner = players.get(0);
        for (Player player : players) {
            if (winner.score < player.score) winner = player;
        }
    }

    private boolean checkVariant(String pWord) {
        var mPWord = wordToMap(pWord);
        if (pWord.length() > word.length()
                || pWord.equals(word)
                || allVariants.contains(pWord)) return false;
        for (char c : mPWord.keySet()) {
            if (mWord.containsKey(c) != mPWord.containsKey(c)) return false;
            if (mPWord.getOrDefault(c, 0) > mWord.getOrDefault(c, 0)) return false;
        }
        return true;
    }

    private HashMap<Character, Integer> wordToMap(String word) {
        var mWord = new HashMap<Character, Integer>();
        for (char l : word.toCharArray()) {
            var k = mWord.getOrDefault(l, 0);
            if (k == 0) {
                mWord.put(l, 1);
            } else {
                mWord.put(l, k + 1);
            }
        }
        return mWord;
    }

    private void nextPlayer() {
        var index = players.indexOf(activePlayer);
        if (index + 1 >= players.size() || index < 0)
            index = 0;
        else
            index++;
        this.activePlayer = players.get(index);
    }

    private void clear() {
        word = "";
        players.clear();
        activePlayer = null;
        stop = false;
    }

    @Override
    public String toString() {
        return "Balda{" +
                "word='" + word + '\'' +
                ", mWord=" + mWord +
                ", players=" + players +
                ", activePlayer=" + activePlayer +
                ", stop=" + stop +
                ", input=" + input +
                ", winner=" + winner +
                ", allVariants=" + allVariants +
                '}';
    }
}

package ru.home_work.work_7;

import java.util.ArrayList;

class Player {
    String name;
    Integer score;
    ArrayList<String> words;

    Player(String name){
        this.name = name;
        this.score = 0;
        this.words = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}

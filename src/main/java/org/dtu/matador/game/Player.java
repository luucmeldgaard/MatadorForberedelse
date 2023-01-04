package org.dtu.matador.game;

public class Player {

    String name;
    String color;
    int position;
    static DiceCup diceCup = new DiceCup();

    public Player(String name, String color, int position) {
        this.name = name;
        this.color = color;
        this.position = position;
    }

    public int rollDie() {
        return diceCup.roll();
    }

    public String getName() {
        return this.name;
    }

    public String getColor() {
        return this.color;
    }

    public int getPosition() {
        return this.position;
    }

    public void movePosition(int move) {
        System.out.println(this.name + " moved " + move + "fields");
        this.position += move;
    }

    // TODO standards of the player class should be passed and defined from a text file
    // TODO That is passed by the GameState class.

}

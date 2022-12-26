package org.dtu.matador.game;

public class Player {

    String name;
    int position;
    public Player(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }


}

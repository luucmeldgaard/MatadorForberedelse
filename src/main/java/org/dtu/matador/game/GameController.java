package org.dtu.matador.game;


import java.util.Map;
import java.util.Scanner;

public class GameController {

    FieldController board;
    GUIController gui;

    public static void main(String[] args) {
        GameState currentGameState;
        FieldController board;

        currentGameState = GameState.getInstance();
        currentGameState.menu();
        currentGameState.playRound();

        //GameState.landOn(board.landOn(player.getPosition()));

        //Initialize game (setup players and perhaps choose a board or create your own)


        // player_0 starts the game
        // Player_0 rolls dice

        // The player's position is sent to FieldController which returns the field type and field info
        // The state is then changed based on the field type
        // The GameState does its thing with the info and updates anything needed updating

    }

    public Player addPlayer() {
        System.out.println("Enter player name");
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        System.out.println("Select player color");
        String color = scan.next();
        return new Player(name, color, 0);
    }

    public void setBoard(String selectedBoard) {
        board = new FieldController(selectedBoard);
        board.setup();
        gui = GUIController.getInstance(board.getFieldMap());
    }

    public Map<String, String> getField(int position) {
        return board.getField(position);

    }




}
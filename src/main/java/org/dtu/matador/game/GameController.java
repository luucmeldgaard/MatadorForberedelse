package org.dtu.matador.game;


public class GameController {
    public static void main(String[] args) {
        GameState currentGameState;
        GUIController gui;
        FieldController board;

        currentGameState = GameState.getInstance();
        gui = GUIController.getInstance(currentGameState.getFieldList());
        Player player = new Player("Casper", 0);
        board = new FieldController();
        board.setup(currentGameState.getFieldList());

        //GameState.landOn(board.landOn(player.getPosition()));

        //Initialize game (setup players and perhaps choose a board or create your own)


        // player_0 starts the game
        // Player_0 rolls dice
        // The player's position is sent to FieldController which returns the field type and field info
        // The state is then changed based on the field type
        // The GameState does its thing with the info and updates anything needed updating



    }
}
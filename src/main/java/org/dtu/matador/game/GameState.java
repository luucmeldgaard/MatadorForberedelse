package org.dtu.matador.game;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import java.util.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class GameState {

    GameController controller;
    ArrayList<Player> playerArray;
    Scanner scan;

    private static GameState gameStateObject;
    Map<String, Map<String, String>> board;
    Map<Integer, String> positionalMap;
    Map<String, String> currentActiveField;
    Player currentActivePlayer;



    private GameState() {
        this.playerArray = new ArrayList<Player>();
        this.board = new HashMap<>();
        controller = new GameController();
        scan = new Scanner(System.in);
    }

    public static GameState getInstance() {
        if (gameStateObject == null) {
            gameStateObject = new GameState();
        }
        else {System.out.println("Gamestate instance already initialized..."); }
        return gameStateObject;
    }

    public String thhshs () {
        return "";
    }

    // Menu (Setup)
    public void menu() {
        System.out.println("Number of players: ");
        Scanner scan = new Scanner(System.in);
        int numberOfPlayers = scan.nextInt();
        for (int i = 0; i<numberOfPlayers; i++) {
            this.playerArray.add(controller.addPlayer());
        }
        // manual test - prints player names after creation of all player objects
        for (Player player : playerArray) {
            System.out.println(player.getName() + player.getColor());
        }

        System.out.println("Select board");
        String selectedBoard = scan.next();
        controller.setBoard(selectedBoard);
        currentActivePlayer = playerArray.get(0);
    }

    // playRound
    public void playRound() {
        System.out.println("Roll die");
        scan.nextLine();
        int dieFaceValue = currentActivePlayer.rollDie();
        currentActivePlayer.movePosition(dieFaceValue);
        Map<String, String> field = controller.getField(currentActivePlayer.getPosition());
        landOn(field);
    }

    // landOnField
    public void landOn(Map<String, String> field) {
        currentActiveField = field;
        System.out.println("__Field information__");
        for (String info : field.keySet()) {
            System.out.println(info + ": " + field.get(info));
        }
        System.out.println("_____________________");
        if (currentActiveField.get("fieldType").equals("property")) {
            landOnProperty(currentActiveField);
        }
    }

    public void landOnProperty(Map<String, String> field) {


    }



}

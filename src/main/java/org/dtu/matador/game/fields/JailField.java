package org.dtu.matador.game.fields;

import org.dtu.matador.game.FieldSpaces;
import org.dtu.matador.game.NonPurchaseableFields;

import java.util.ArrayList;

public class JailField extends NonPurchaseableFields {

    ArrayList<String> jailedPlayers;

    public JailField() {

    }

    public String print() {
        return "Hey";
    }

    public void LandOn(String playerName) {
        if (jailedPlayers.contains(playerName)) {

        }

    }

    public String otherPrint() {
        return "bye";
    }

}

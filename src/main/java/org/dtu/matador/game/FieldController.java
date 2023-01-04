package org.dtu.matador.game;

import org.dtu.matador.game.fields.*;

import java.util.*;

public class FieldController {

    ArrayList<FieldSpaces> fields;
    FieldLoader fieldLoader;
    Map<String, Map<String, String>> fieldMap;
    Map<Integer, String> positionalFieldMap;

    public FieldController(String selectedBoard) {
        fields = new ArrayList<>();
        fieldLoader = new FieldLoader(selectedBoard);
        this.fieldMap = fieldLoader.getFieldList();
        for (int i = 0; i < this.fieldMap.size(); i++) {
            fields.add(null);
        }
        this.positionalFieldMap = new HashMap<Integer, String>();
        for (Map<String, String> fieldFromMap : this.fieldMap.values()) {
            this.positionalFieldMap.put(Integer.parseInt(fieldFromMap.get("position")), fieldFromMap.get("title"));
            System.out.println(Integer.parseInt(fieldFromMap.get("position")) + " " +  fieldFromMap.get("title"));
        }

    }

    public void setup() {
        for (Map<String, String> field : fieldMap.values()) {
            int fieldPosition = Integer.parseInt(field.get("position"));
            switch (field.get("fieldType")) {
                case "property" -> {
                    fields.set(fieldPosition, new Street(field.get("title"), field.get("subText"), field.get("subText"), field.get("rent"), field.get("color_1"), field.get("color_2"), field.get("price"), field.get("owner")));
                }
                /*case "chance" -> {
                    guiFields[Integer.parseInt(field.get("position"))] = new GUI_Chance(field.get("title"), field.get("subText"), field.get("subText"), Color.getColor(field.get("color_1")), Color.getColor(field.get("color_2")));
                }
                case "jail" -> {
                    guiFields[Integer.parseInt(field.get("position"))] = new GUI_Jail("default", field.get("title"), field.get("subText"), field.get("subText"), Color.getColor(field.get("color_1")), Color.getColor(field.get("color_2")));
                }
                case "tax" -> {
                    guiFields[Integer.parseInt(field.get("position"))] = new GUI_Tax(field.get("title"), field.get("subText"), field.get("subText"), Color.getColor(field.get("color_1")), Color.getColor(field.get("color_2")));
                }
                case "start" -> {
                    guiFields[Integer.parseInt(field.get("position"))] = new GUI_Start(field.get("title"), field.get("subText"), field.get("subText"), Color.getColor(field.get("color_1")), Color.getColor(field.get("color_2")));
                }
                case "free-parking" -> {
                    guiFields[Integer.parseInt(field.get("position"))] = new GUI_Refuge("default", field.get("title"), field.get("subText"), field.get("subText"), Color.getColor(field.get("color_1")), Color.getColor(field.get("color_2")));
                }*/
            }
        }
        for (FieldSpaces field : fields) {
            System.out.println(field.getName());
        }
    }

    public Map<String, Map<String, String>> getFieldMap() {
        return this.fieldMap;
    }

    /*public Map<String, String> getField(int position) {
        String positionToTitle = this.positionalFieldMap.get(position);
        return this.fieldMap.get(positionToTitle);
    }*/

    public Map<String, String> getField(int position) {
        String positionToTitle = this.positionalFieldMap.get(position);
        return this.fieldMap.get(positionToTitle);
    }

    public Map<String, String> getField(String name) {
        return this.fieldMap.get(name);
    }


    /*public String landOn(int position) {

        return "";

        for (FieldSpaces field : fields) {//System.out.println(field.print());

            if (field instanceof Properties) {
                return "property";
            }
            else if (field instanceof TaxField) {
                return "Tax";
            }

            if (field instanceof Properties) {
                Properties p = (Properties) field;
                ((Properties) field).getRent();
            }
        }


        if (fields.get(1) instanceof Property) {
            String name = fields.get(1).getName();
            System.out.println(name);
        }

        //PropertyDeed.all.get(1).promptStreetName();


        //System.out.println(currentGameState.getField("Munkestræde").get("position"));
        //System.out.println(currentGameState.getField(0));

        //System.out.println(currentGameState.getFieldList().keySet());
        return "";
    }*/



}

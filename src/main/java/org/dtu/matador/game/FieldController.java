package org.dtu.matador.game;

import org.dtu.matador.game.fields.*;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public class FieldController {

    ArrayList<FieldSpaces> fields;

    public FieldController() {
        fields = new ArrayList<>();
    }


    public void setup(Map<String, Map<String, String>> fieldMap) {

        for (Map<String, String> field : fieldMap.values()) {
            System.out.println(Integer.parseInt(field.get("position")));
            switch (field.get("fieldType")) {
                case "property" -> {
                    fields.add(new Street(field.get("title"), field.get("subText"), field.get("subText"), field.get("rent"), field.get("color_1"), field.get("color_2"), field.get("price"), field.get("owner")));
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
    }

    public String landOn(int position) {

         return fields.get(position).get;

        /*for (FieldSpaces field : fields) {//System.out.println(field.print());

            if (field instanceof Properties) {
                return "property";
            }
            else if (field instanceof TaxField) {
                return "Tax";
            }
            */
            /*if (field instanceof Properties) {
                Properties p = (Properties) field;
                ((Properties) field).getRent();
            }*/
        }


        /*if (fields.get(1) instanceof Property) {
            String name = fields.get(1).getName();
            System.out.println(name);
        }*/

        //PropertyDeed.all.get(1).promptStreetName();


        //System.out.println(currentGameState.getField("Munkestræde").get("position"));
        //System.out.println(currentGameState.getField(0));

        //System.out.println(currentGameState.getFieldList().keySet());
        return null;
    }



}

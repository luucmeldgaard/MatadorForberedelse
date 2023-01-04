package org.dtu.matador.game;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import java.util.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class FieldLoader {

    Map<String, Map<String, String>> testMap;
    Map<Integer, String> positionalMap;
    Map<String, String> colorMap;


    public FieldLoader(String selectedBoard) {

        this.testMap = new HashMap<>();
        this.positionalMap = new HashMap<>();
        this.colorMap = new HashMap<>();

        this.testMap = JSONtoMapBoard(selectedBoard + ".json");
        this.colorMap = JSONtoMapColors("colors.json");
        for (Map<String, String> fieldObject : this.testMap.values()) {
            this.positionalMap.put(Integer.parseInt(fieldObject.get("position")), fieldObject.get("title"));
        }

    }

    private Map<String, String> JSONtoMapColors(String filename) {
        JSONParser jsonParser = new JSONParser();
        try (FileReader fieldFileReader = new FileReader(filename)) {
            Object obj = jsonParser.parse(fieldFileReader);

            ObjectMapper mapper = new ObjectMapper();
            String objString = obj.toString();
            objString = objString.replace("[", "");
            objString = objString.replace("]", "");
            Map<String, String> map = mapper.readValue(objString, Map.class);
            for (String color : map.keySet()) {
                System.setProperty(color, map.get(color));
            }
            return map;
        }
        catch (IOException | ParseException ex) {
            throw new RuntimeException(ex);
        }
    }
    private Map<String, Map<String, String>> JSONtoMapBoard(String filename) {

        Map<String, Map<String, String>> JSONparsedMap = new HashMap<>();

        JSONParser jsonParser = new JSONParser();
        try (FileReader fieldFileReader = new FileReader(filename)) {
            Object obj = jsonParser.parse(fieldFileReader);

            String objData = obj.toString();
            String[] rawObjDataArray = objData.split("},");

            String fieldString;
            int iteration = 0;
            String[] objDataArray = new String[rawObjDataArray.length];
            for (String fieldObject : rawObjDataArray) {
                fieldString = fieldObject;
                fieldString = fieldString.replace("[", "");
                fieldString = fieldString.replace("{\"field\":", "");
                fieldString = fieldString.replace("]", "");
                objDataArray[iteration] = fieldString;
                iteration += 1;

            }

            for (int i = 0; i < objDataArray.length; i++) {
                System.out.println(objDataArray[i]);
            }

            ObjectMapper mapper = new ObjectMapper();
            for (String fieldObject : objDataArray) {
                Map<String, String> map = mapper.readValue(fieldObject, Map.class);
                System.out.println(map);
                JSONparsedMap.put(map.get("title"), map);
            }
        }
        catch (IOException | ParseException ex) {
            throw new RuntimeException(ex);
        }
        return JSONparsedMap;
    }

    public Map<String, Map<String, String>> getFieldList() {
        return testMap;
    }

    public Map<String, String> getField(String name) {
        return testMap.get(name);
    }

    public Map<String, String> getField(int position) {
        String positionToTitle = positionalMap.get(position);
        return testMap.get(positionToTitle);
    }

}

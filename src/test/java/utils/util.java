package utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class util {
    public static void saveEmployInfo(String firstName, String lastName, String userName, String pass) throws IOException, ParseException {
        String file = "./src/test/resources/Employeeinfo.json";
        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader(file));


        JSONObject employeeObjet = new JSONObject();
        Object firstname = employeeObjet.put("firstname", firstName);
        employeeObjet.put("lastName", lastName);
        employeeObjet.put("userName", userName);
        employeeObjet.put("pass", pass);



        jsonArray.add(employeeObjet);
        FileWriter writer = new FileWriter(file);
        writer.write(jsonArray.toJSONString());
        writer.flush();
        writer.close();

    }
    public static JSONArray ReadInfo() throws IOException, ParseException {
        String file = "./src/test/resources/Employeeinfo.json";
        JSONParser parser = new JSONParser();
        JSONArray jsonArray= (JSONArray) parser.parse(new FileReader(file));
        return jsonArray;
    }
}

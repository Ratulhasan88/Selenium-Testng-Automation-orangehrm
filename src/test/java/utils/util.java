package utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class util {
    public static void saveEmployInfo(String firstName, String lastName, String userName, String pass, String confirmPass) throws IOException, ParseException {
        String file = "./src/test/resources/Employeeinfo.json";
        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader(file));

        JSONObject employeeObjet = new JSONObject();
        employeeObjet.put("firstname", firstName);
        employeeObjet.put("lastName", lastName);
        employeeObjet.put("userName", userName);
        employeeObjet.put("pass", pass);
        employeeObjet.put("confirmPass", confirmPass);


        jsonArray.add(employeeObjet);
        FileWriter writer = new FileWriter(file);
        writer.write(jsonArray.toJSONString());
        writer.flush();
        writer.close();

    }
}

package com.selenium.PageobjectModel;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadDataFromJsonFile {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		
		String str = "";
		JSONParser parser = new JSONParser();
        //JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(
              //  "E:\\JavaGit-Projects\\page-object-model\\PageobjectModel\\src\\main\\java\\com\\selenium\\PageobjectModel\\file.json"));
        
        JSONArray jsonArray = (JSONArray) parser.parse(new String(str));

        for (Object o : jsonArray) {
            JSONObject person = (JSONObject) o;

            String strName = (String) person.get("name");
            System.out.println("Name::::" + strName);

            String strCity = (String) person.get("city");
            System.out.println("City::::" + strCity);

            JSONArray arrays = (JSONArray) person.get("cars");
            for (Object object : arrays) {
                System.out.println("cars::::" + object);
            }
            String strJob = (String) person.get("job");
            System.out.println("Job::::" + strJob);
            System.out.println();

        }

    }
		/*
		JSONParser parser = new JSONParser();

        try {     
            Object obj = parser.parse(new FileReader("E:\\JavaGit-Projects\\page-object-model\\PageobjectModel\\src\\main\\java\\com\\selenium\\PageobjectModel\\file.json"));

            JSONObject jsonObject =  (JSONObject) obj;

            String name = (String) jsonObject.get("name");
            System.out.println(name);

            String city = (String) jsonObject.get("city");
            System.out.println(city);

            String job = (String) jsonObject.get("job");
            System.out.println(job);

            // loop array
            JSONArray cars = (JSONArray) jsonObject.get("cars");
            Iterator<String> iterator = cars.iterator();
            while (iterator.hasNext()) {
             System.out.println(iterator.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

	}



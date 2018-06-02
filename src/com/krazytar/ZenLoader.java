package com.krazytar;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class ZenLoader {
    
    public static void main(String args[]) {
        String version = "1.0";
        System.out.println("Welcome to ZenLoader " + version);
        loadJSON();
        
    }
    
    public static void loadJSON() {
        String basePath = new File("").getAbsolutePath();
        String userPath = "/Users/Troy/Downloads/LOLGM_League_1_2018_regular_season_0-0.json";
        try {
            byte[] data = Files.readAllBytes(Paths.get(userPath));
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(data);
            System.out.println(root.path("meta").path("name").asText());
            JsonNode players = root.path("players");
            Iterator<JsonNode> playersIterator = players.elements();
            while(playersIterator.hasNext()) {
                JsonNode player = playersIterator.next();
                System.out.println(player.path("userID").asText());
            }
            
        } catch (IOException ex) {
            System.out.println("IOException!");
        }
    }
}

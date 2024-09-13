package com.csc340.demo;

import com.fasterxml.jackson.core.JsonFactoryBuilder;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


@RestController
public class RestAPIController {

    @GetMapping("/games")
    public Object gameList() {
        try {
            String url = "https://www.freetogame.com/api/games";
            RestTemplate restTemplate = new RestTemplate();
            ObjectMapper mapper = new ObjectMapper();
            String jsonList = restTemplate.getForObject(url, String.class);
            JsonNode root = mapper.readTree(jsonList);
            List<Games> gamesList = new ArrayList<>();
            for (JsonNode rt : root)
            {
                String title = rt.get("title").asText();
                String genre = rt.get("genre").asText();
                String platform = rt.get("platform").asText();

                Games games = new Games(title, genre, platform);
                gamesList.add(games);
            }
            return gamesList;

        } catch (IOException ex) {
            Logger.getLogger(RestAPIController.class.getName()).log(Level.SEVERE,
                    null, ex);
            return ("error in /games");

        }
    }
}

package com.csc340.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class RestAPIController {

    @GetMapping("/Disney")
    public Object disneyRoster(@RequestParam(value = "name", defaultValue = "Aladdin") String characterName) {
        try {
            if (characterName.contains(" ")) {
                characterName.replace(" ", "%20");
            }
            String url = "https://api.disneyapi.dev/character?name=" + characterName;
            RestTemplate restTemplate = new RestTemplate();
            ObjectMapper mapper = new ObjectMapper();
            String jsonList = restTemplate.getForObject(url, String.class);
            JsonNode root = mapper.readTree(jsonList);
            List<DisneyCharacter> characterChart = new ArrayList<>();
            for (JsonNode rt : root) {
                String name = rt.get("name").asText();
                String films = rt.get("films").asText();
                String tvShows = rt.get("tvShows").asText();
                DisneyCharacter character = new DisneyCharacter(name, films, tvShows);
                characterChart.add(character);
            }
            return characterChart;
        } catch (JsonProcessingException ex) {
            Logger.getLogger(RestAPIController.class.getName()).log(Level.SEVERE,
                    null, ex);
            return ("error in /Disney");

        }
    }
}

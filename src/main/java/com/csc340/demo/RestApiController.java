package com.csc340.demo;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class RestApiController {

    @GetMapping("/gothouses")
    public Object getHouses() {
        try {
            //CONSUMING A RESTFUL WEB SERVICE (API)
            String url = "https://www.anapioficeandfire.com/api/houses";
            RestTemplate restTemplate = new RestTemplate();
            ObjectMapper mapper = new ObjectMapper();

            String jsonListResponse = restTemplate.getForObject(url, String.class);
            JsonNode root = mapper.readTree(jsonListResponse);

            List<GoTHouses> housesList = new ArrayList<>();

            //The response from the above API is a JSON Array, which we loop through.
            for (JsonNode rt : root) {
                //Extract relevant info from the response and use it for what you want, in this case build a Brewery object
                String name = rt.get("name").asText();
                String address = rt.get("region").asText();
                String type = rt.get("words").asText();

                GoTHouses house = new GoTHouses(name, address, type);
                housesList.add(house);
            }
            return housesList;
        } catch (JsonProcessingException ex) {
            Logger.getLogger(RestApiController.class.getName()).log(Level.SEVERE,
                    null, ex);
            return "error in /gothouses";
        }
    }
}

package org.springframework.samples.petclinic.care.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;


@Controller
public class CareController {

    @Value("${government.host}")
    private URL goHost;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/care")
    public String careList(Model model) throws IOException {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(goHost+"/OrganicAnimalProtectionFacilit")
            .queryParam("KEY", "772655a1030843bd95627ce47564255f")
            .queryParam("Type", "json")
            .queryParam("SUM_YY", "2019")
            .queryParam("pIndex", 1)
            .queryParam("pSize", 100);
        ResponseEntity<String> response = restTemplate.exchange(builder.toUriString()
            , HttpMethod.GET
            , HttpEntity.EMPTY.EMPTY
            , new ParameterizedTypeReference<String>() {});
        if(response.getStatusCode() == HttpStatus.OK){
            Map result = new ObjectMapper().readValue(response.getBody(), Map.class);
            model.addAttribute("facility", ((List)(((Map)((List)result.get("OrganicAnimalProtectionFacilit")).get(1)).get("row"))));
        }
        return "care/animalCareFacilities";
    }
}

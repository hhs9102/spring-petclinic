package org.springframework.samples.petclinic.care.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.samples.petclinic.care.model.AnimalCareFacilityResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URL;


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
        ResponseEntity<AnimalCareFacilityResponse> response = restTemplate.exchange(builder.toUriString()
            , HttpMethod.GET
            , HttpEntity.EMPTY.EMPTY
            , new ParameterizedTypeReference<AnimalCareFacilityResponse>() {});
        if(response.getStatusCode() == HttpStatus.OK){
            model.addAttribute("facility", response.getBody().getHeadOrRowList().get(1).getRow());
        }
        return "care/animalCareFacilities";
    }
}

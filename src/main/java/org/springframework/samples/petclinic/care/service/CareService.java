package org.springframework.samples.petclinic.care.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.samples.petclinic.care.model.AnimalCareFacilityResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URL;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class CareService {

    @Value("${government.host}")
    private URL goHost;

    public void setGoHost(URL goHost) {
        this.goHost = goHost;
    }

    @Autowired
    RestTemplate restTemplate;

    @CircuitBreaker(name = "careExternal", fallbackMethod = "careListFallback")
    public List<AnimalCareFacilityResponse.Row> careList() {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(goHost+ "/OrganicAnimalProtectionFacilit")
            .queryParam("KEY", "772655a1030843bd95627ce47564255f")
            .queryParam("Type", "json")
            .queryParam("SUM_YY", "2019")
            .queryParam("pIndex", 1)
            .queryParam("pSize", 100);
        ResponseEntity<AnimalCareFacilityResponse> response = restTemplate.exchange(builder.toUriString()
            , HttpMethod.GET
            , HttpEntity.EMPTY.EMPTY
            , new ParameterizedTypeReference<AnimalCareFacilityResponse>() {
            });
        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody().getHeadOrRowList().get(1).getRow();
        }
        return Collections.emptyList();
    }

    public List<AnimalCareFacilityResponse.Row> careListFallback(Exception e){
        log.info("api 상태가 불안정하다.");
        return Collections.emptyList();
    }
}

package org.springframework.samples.petclinic.config;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.samples.petclinic.config.intercepter.JsonMimeInterceptor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Configuration
public class BeanConfiguration {


    @Bean
    public HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory(){
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setConnectTimeout(3000);
        factory.setReadTimeout(5000);
        HttpClient httpClient = HttpClients.custom()
            .setMaxConnTotal(20)
            .setMaxConnPerRoute(10)
            .build();
        factory.setHttpClient(httpClient);
        return factory;
    }

    @Bean
    public RestTemplate restTemplate(){
        RestTemplate restTemplate = new RestTemplate(httpComponentsClientHttpRequestFactory());
        restTemplate.setInterceptors(Collections.singletonList(new JsonMimeInterceptor()));

        List<HttpMessageConverter<?>> converters = restTemplate.getMessageConverters();
        for(HttpMessageConverter converter : converters){
            if(converter instanceof MappingJackson2HttpMessageConverter){
                List<MediaType> mediaTypes = new ArrayList<>();
                mediaTypes.add(MediaType.TEXT_HTML);
                ((MappingJackson2HttpMessageConverter) converter).setSupportedMediaTypes(mediaTypes);
            }
        }
        return restTemplate;
    }
}

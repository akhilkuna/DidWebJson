package com.didweb.json.example.controller;

import java.io.IOException;

import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class DidWebJsonController {
	
	@GetMapping(value = "/well-known/{jsonfile}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Object getBeers(@PathVariable("jsonfile") String jsonfile) {
        Resource resource = new ClassPathResource("classpath:src/main/resources/" + jsonfile);
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(resource.getInputStream(), Object.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}

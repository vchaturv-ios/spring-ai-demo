package com.codevish.springaidemo.controllers;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codevish.springaidemo.services.SpringAiService;

@RestController
@RequestMapping("/api/v1")
public class SpringAiController {

    @Autowired SpringAiService aiService;

    @GetMapping("/joke")
    public String getJoke(@RequestParam String topic) {
        return aiService.getJoke(topic);
    }

    @GetMapping("/book")
    public String getBook(@RequestParam(name = "category") String category, @RequestParam(name = "year") String year) {
        return aiService.getBestBook(category, year);
    }

    @GetMapping(value = "/image", produces = "image/jpeg")
    public ResponseEntity<InputStreamResource> getImage(@RequestParam(name = "topic") String topic) throws URISyntaxException {
        return ResponseEntity.ok().body(aiService.getImage(topic));
    }
    
}

package com.example.elasticsearch.controller;

import com.example.elasticsearch.service.IndexService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/index")
@RequiredArgsConstructor
public class IndexController {
    private final IndexService indexService;

    @PostMapping("/reacreate")
    public void recreateAllIndices(){
        indexService.recreateIndices(true);
    }
}

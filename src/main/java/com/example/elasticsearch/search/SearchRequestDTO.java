package com.example.elasticsearch.search;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class SearchRequestDTO {
    private List<String> fields;
    private String searchTerm;


}

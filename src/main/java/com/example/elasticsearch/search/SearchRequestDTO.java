package com.example.elasticsearch.search;

import lombok.Getter;
import lombok.Setter;
import org.elasticsearch.search.sort.SortOrder;

import java.util.List;

@Getter @Setter
public class SearchRequestDTO {
    private List<String> fields;
    private String searchTerm;
    private String sortBy;
    private SortOrder order;

}

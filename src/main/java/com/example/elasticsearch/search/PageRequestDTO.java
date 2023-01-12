package com.example.elasticsearch.search;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PageRequestDTO {
    private static final int DEFAULT_SIZE = 100;

    private int page;
    private int size;

    public int getSize() {
        return size != 0 ? size : DEFAULT_SIZE;
    }

}

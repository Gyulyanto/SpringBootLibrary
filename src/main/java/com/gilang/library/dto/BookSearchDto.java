package com.gilang.library.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter@Setter
public class BookSearchDto {
    private String searchBookName;
    private String searchAuthor;
}

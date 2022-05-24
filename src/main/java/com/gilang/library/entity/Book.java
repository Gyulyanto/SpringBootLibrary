package com.gilang.library.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "mst_book")
@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor@ToString
public class Book {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid",strategy = "uuid")
@Column(name = "book_id")
    private String id;
    @Column(name = "book_name")
    private String bookName;
    private String author;
    private Integer stock;
}

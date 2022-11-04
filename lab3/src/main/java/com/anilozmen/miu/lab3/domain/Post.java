package com.anilozmen.miu.lab3.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(name = "title")
    String title;

    @Column(name = "content")
    String content;

    @Column(name = "author")
    String author;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id", referencedColumnName = "id")
    List<Comment> comments;
}

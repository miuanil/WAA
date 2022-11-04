package com.anilozmen.miu.lab2.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(name = "name")
    String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn
    List<Post> posts;

}

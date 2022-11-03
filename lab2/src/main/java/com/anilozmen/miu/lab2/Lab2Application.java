package com.anilozmen.miu.lab2;

import com.anilozmen.miu.lab2.domain.PostV1;
import com.anilozmen.miu.lab2.domain.User;
import com.anilozmen.miu.lab2.repository.PostRepository;
import com.anilozmen.miu.lab2.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Lab2Application implements CommandLineRunner {

    @Autowired
    PostRepository postRepository;

    @Autowired
    UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(Lab2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        PostV1 post1 = new PostV1();
        post1.setTitle("Post 1 Title");
        post1.setContent("Post Content 1");
        post1.setAuthor("John Doe");

        PostV1 post2 = new PostV1();
        post2.setTitle("Post 10 Title");
        post2.setContent("Post Content 10");
        post2.setAuthor("John Doe");
        List<PostV1> johnDoe = Arrays.asList(post1, post2);

        PostV1 post3 = new PostV1();
        post3.setTitle("Post 2 Title");
        post3.setContent("Post Content 2");
        post3.setAuthor("Alex Doe");
        List<PostV1> alexDoe = Arrays.asList(post3);

        PostV1 post4 = new PostV1();
        post4.setTitle("Post 3 Title");
        post4.setContent("Post Content 3");
        post4.setAuthor("Joseph Doe");

        PostV1 post5 = new PostV1();
        post5.setTitle("Post 8 Title");
        post5.setContent("Post Content 8");
        post5.setAuthor("Joseph Doe");

        PostV1 post6 = new PostV1();
        post6.setTitle("Post 9 Title");
        post6.setContent("Post Content 9");
        post6.setAuthor("Joseph Doe");
        List<PostV1> josephDoe = Arrays.asList(post4, post5, post6);

        PostV1 post7 = new PostV1();
        post7.setTitle("Post 4 Title");
        post7.setContent("Post Content 4");
        post7.setAuthor("Ethan Doe");
        List<PostV1> ethanDoe = Arrays.asList(post7);

        PostV1 post8 = new PostV1();
        post8.setTitle("Post 5 Title");
        post8.setContent("Post Content 5");
        post8.setAuthor("Henry Doe");
        List<PostV1> henryDoe = Arrays.asList(post8);

        PostV1 post9 = new PostV1();
        post9.setTitle("Post 6 Title");
        post9.setContent("Post Content 6");
        post9.setAuthor("Lucas Doe");

        PostV1 post10 = new PostV1();
        post10.setTitle("Post 7 Title");
        post10.setContent("Post Content 7");
        post10.setAuthor("Lucas Doe");
        List<PostV1> lucasDoe = Arrays.asList(post9, post10);

        // Users
        User user = new User();
        user.setName("John Doe");
        user.setPosts(johnDoe);

        User user2 = new User();
        user2.setName("Alex Doe");
        user2.setPosts(alexDoe);

        User user3 = new User();
        user3.setName("Joseph Doe");
        user3.setPosts(josephDoe);

        User user4 = new User();
        user4.setName("Ethan Doe");
        user4.setPosts(ethanDoe);

        User user5 = new User();
        user5.setName("Henry Doe");
        user5.setPosts(henryDoe);

        User user6 = new User();
        user6.setName("Lucas Doe");
        user6.setPosts(lucasDoe);

        List<User> users = Arrays.asList(user, user2, user3, user4, user5, user6);
        List<PostV1> posts = Arrays.asList(post1, post2, post3, post4, post5, post6, post7, post8, post9, post10);

        postRepository.saveAll(posts);
        userRepository.saveAll(users);

    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}

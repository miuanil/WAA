package com.anilozmen.miu.lab5;

import com.anilozmen.miu.lab5.repository.PostRepository;
import com.anilozmen.miu.lab5.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Lab5Application {

    @Autowired
    PostRepository postRepository;

    @Autowired
    UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(Lab5Application.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}

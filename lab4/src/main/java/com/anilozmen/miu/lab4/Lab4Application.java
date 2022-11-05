package com.anilozmen.miu.lab4;

import com.anilozmen.miu.lab4.repository.PostRepository;
import com.anilozmen.miu.lab4.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Lab4Application {

    @Autowired
    PostRepository postRepository;

    @Autowired
    UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(Lab4Application.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}

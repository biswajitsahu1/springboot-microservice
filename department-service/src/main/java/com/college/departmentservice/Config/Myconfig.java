package com.college.departmentservice.Config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Myconfig {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}

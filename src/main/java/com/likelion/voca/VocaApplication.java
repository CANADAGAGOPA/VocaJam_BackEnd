package com.likelion.voca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
public class VocaApplication {
	public static void main(String[] args) {
		SpringApplication.run(VocaApplication.class, args);
	}
}

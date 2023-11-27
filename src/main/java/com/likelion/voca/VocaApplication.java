package com.likelion.voca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
public class VocaApplication {


	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/vocaboard");
			System.out.println("mysql Connection Successful");
			conn.close();
			System.out.println("Disconnect");
		} catch(ClassNotFoundException error) {
			System.out.println("Driver not installed or driver name error");
		} catch(SQLException error) {
			System.out.println("Connection error");
		}

		SpringApplication.run(VocaApplication.class, args);
	}
}

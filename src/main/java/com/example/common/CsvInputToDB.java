package com.example.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
//csvファイルを読み込んでDBへinsert
public class CsvInputToDB {

	public static void main(String[] args) {
		
        Connection conn = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5433/student", "postgres", "postgres");
			
		    Statement stmt = conn.createStatement();
		
		try {
			File file = new File("/Users/yamadeayaka/arashi.csv");
			BufferedReader br = new BufferedReader((new InputStreamReader(new FileInputStream(file), "UTF-8")));

			List<String> bachList = new ArrayList<>();
			String str = br.readLine();
			while (str != null) {
			    String[] data = str.split(",",0);
				bachList.add(str);
				str = br.readLine();
				stmt.executeUpdate("INSERT INTO arashi (name, day, email, company_id) VALUES ('" + data[0] + "','" + data[1] + "','" + data[2] + "','" + data[3] + "')");
			}
			br.close();
			for(String work : bachList) {
				
				System.out.println(work);
			}
		} catch (IOException e) {
			System.out.println(e);
		}
		  stmt.close();
		  conn.close();

		} catch (Exception e) {
			System.out.println(e);
		}


	}

}

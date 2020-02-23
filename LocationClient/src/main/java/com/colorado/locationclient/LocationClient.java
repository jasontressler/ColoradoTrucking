package com.colorado.locationclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class LocationClient {

	public static void main(String[] args) {
		SpringApplication.run(LocationClient.class, args);
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET, params = "query")
    public Object dbQuery(@RequestParam String query) {
        List<String> names = new ArrayList<String>();
        try {
            Connection connection = DriverManager.getConnection("Server=tcp:jason-school.database.windows.net,1433;Initial Catalog=Enterprise;Persist Security Info=False;User ID=jwt11;Password=JwT#364075;MultipleActiveResultSets=False;Encrypt=True;TrustServerCertificate=False;Connection Timeout=30;");
            Statement statement = connection.createStatement();
            String sql = String.format("select legal_name from InService where Legal_Name like '%%%s%%'", query);
            ResultSet result = statement.executeQuery(sql);
            //connection.close();
            while (result.next()) {
                names.add(result.getString("Legal_Name"));
                //return new String(result.getString("legal_name");
            }
            return names;
        } catch (SQLException e) {
            return "Bad SQL query. " + e.getMessage();
        }
    }
}

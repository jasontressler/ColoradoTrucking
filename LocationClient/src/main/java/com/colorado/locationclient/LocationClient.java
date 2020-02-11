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
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://jason-school.database.windows.net:" +
                    "1433;database=ColoradoTrucking;user=jwt11@jason-school;password=JwT#364075;encrypt=true;" +
                    "trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
            Statement statement = connection.createStatement();
            String sql = String.format("select legal_name from OOS where legal_name like '%%%s%%'", query);
            ResultSet result = statement.executeQuery(sql);
            //connection.close();
            while (result.next()) {
                names.add(result.getString("legal_name"));
                //return new String(result.getString("legal_name");
            }
            return names;
        } catch (SQLException e) {
            return "Bad SQL query. " + e.getMessage();
        }
    }
}

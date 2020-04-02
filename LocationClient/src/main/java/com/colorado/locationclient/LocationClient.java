package com.colorado.locationclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class LocationClient {
    private String connectionString = "jdbc:sqlserver://jason-school.database.windows.net:1433;database=Enterprise2;user=jwt11@jason-school;password=JwT#364075;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";

    public static void main(String[] args) {
        SpringApplication.run(LocationClient.class, args);
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET, params = "query")
    public ResponseEntity<Response> dbQuery(@RequestParam String query) {
        List<Feature> responseBody = new ArrayList<Feature>();
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.setCacheControl("private, max-age=604800");
        int count = 0;

        try {
            Connection connection = DriverManager.getConnection(connectionString);
            PreparedStatement statement = connection.prepareStatement("exec GetCompaniesLike " + query);
            ResultSet result = statement.executeQuery();
            
            while (result.next()){
                responseBody.add(new Feature(
                    new FeatureProperties(
                        result.getInt("Flag"),
                        result.getInt("dayDiff"),
                        result.getString("inDOT"),
                        result.getString("inName"),
                        result.getString("inStreet"),
                        result.getString("inCity"),
                        result.getString("inState"),
                        result.getString("inZip"),
                        result.getString("inPhone"),
                        result.getString("inEmail"),
                        result.getString("inDate"),
                        result.getString("outDOT"),
                        result.getString("outName"),
                        result.getString("outDate"),
                        result.getString("outReason"),
                        result.getString("outStatus")
                        ),
                    new FeatureGeometry(
                        result.getDouble("inLat"),
                        result.getDouble("inLon")
                    )                        
                ));
                count++;
            }
            connection.close();    
        } catch (SQLException e) {
            return ResponseEntity.badRequest().headers(responseHeader).body(new Response(e.getMessage()));
        }

        return ResponseEntity.ok().headers(responseHeader).body(new FeatureResponse("Success! " + count + " records.", responseBody));
    }
}

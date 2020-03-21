package com.colorado.locationclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ohadr.common.utils.JsonUtils;

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
                        result.getInt("DOT_NUMBER"),
                        result.getString("LEGAL_NAME"),
                        result.getString("PHY_STREET"),
                        result.getString("PHY_CITY"),
                        result.getString("PHY_STATE"),
                        result.getString("PHY_ZIP"),
                        result.getString("TELEPHONE"),
                        result.getString("EMAIL_ADDRESS")),
                    new FeatureGeometry(
                        result.getDouble("gpsLatitude"),
                        result.getDouble("gpsLongitude"))
                ));
                count++;
            }
            connection.close();    
        } catch (SQLException e) {
            return ResponseEntity.badRequest().headers(responseHeader).body(new Response(e.getMessage()));
        }

        return ResponseEntity.ok().headers(responseHeader).body(new FeatureResponse("Success! " + count + " records.", responseBody));
    }
    /* 
    @RequestMapping(value = "/fetch", method = RequestMethod.GET, params = "values")
    public ResponseEntity<Response> fetchOos(@RequestParam String values) {
        List<Feature> responseBody = new ArrayList<Feature>();
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.setCacheControl("private, max-age=604800");
        int count = 0;

        try {
            Connection connection = DriverManager.getConnection(connectionString);
            PreparedStatement statement = connection.prepareStatement(SQL STATEMENT);
            ResultSet result = statement.executeQuery(); 
            */
}

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
    private String connectionString = "jdbc:sqlserver://jason-school.database.windows.net:1433;database=Enterprise;user=jwt11@jason-school;password=JwT#364075;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";

    public static void main(String[] args) {
        SpringApplication.run(LocationClient.class, args);
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET, params = "query")
    public ResponseEntity<Object> dbQuery(@RequestParam String query) {
        List<String> response = new ArrayList<String>();
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.setCacheControl("private, max-age=604800");

        try {
            Connection connection = DriverManager.getConnection(connectionString);
            Statement statement = connection.createStatement();
            String sql = String.format("select legal_name from InService where Legal_Name like '%%%s%%'", query);
            ResultSet result = statement.executeQuery(sql);
            // connection.close();
            while (result.next()) {
                response.add(result.getString("Legal_Name"));
                // return new String(result.getString("legal_name");
            }
        } catch (SQLException e) {
            response.add("Bad SQL or connection. " + e.getMessage());
        }

        return ResponseEntity.ok().headers(responseHeader).body(response);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<GetAllResponse> getAll() {
        List<Feature> responseBody = new ArrayList<Feature>();
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.setCacheControl("private, max-age=604800");
        int count = 0;

        try {
            Connection connection = DriverManager.getConnection(connectionString);
            Statement statement = connection.createStatement();
            //String sql = String.format("select top(10) * from InService");
            String sql = String.format("select top(50) * from InService where gpsLatitude is not null and gpsLongitude is not null");
            ResultSet result = statement.executeQuery(sql);
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

        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .headers(responseHeader)
                .body(new GetAllResponse(e.getMessage()));
        }

        return ResponseEntity.ok()
            .headers(responseHeader)
            .body(new GetAllResponse(
                "Success! Returned " + count + " records.",
                responseBody
            ));
    }
}

package com.studys.button_backend;


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonArray;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;


public class GeocalizationAdapter implements  LocationAdapterInterface{
    private String apiKey;

    public GeocalizationAdapter(String apiKey) {
        this.apiKey = apiKey;
    }

    public void setApiKey(String apiKey) {this.apiKey = apiKey;}

    public String getApiKey() {return apiKey;}

    public ResponseEntity<String> receiveLocation(@RequestBody LocationAdapter locationAdapter){
        String locationName = findLocation(locationAdapter.getLatitude(), locationAdapter.getLongitude());
        Location location = new Location(locationAdapter.getLatitude(), locationAdapter.getLongitude(), locationName);
        return ResponseEntity.ok(location.toString());
    }

    @Override
    public String findLocation(double latidude, double longitude) {
        String url = String.format(
                "https://maps.googleapis.com/maps/api/geocode/json?latlng=%s,%s&key=%s",
                latidude, longitude, apiKey
        );

        HttpClient httpClient = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(10)).build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .timeout(Duration.ofSeconds(15))
                .GET()
                .build();

        try{
            HttpResponse<String> response = httpClient.send(
                    request,
                    HttpResponse.BodyHandlers.ofString());
            String responseJsonString = response.body();
            if(response.statusCode() == 200){
                JsonObject json = JsonParser.parseString(responseJsonString).getAsJsonObject();
                String nameLocation = extractName(json);
                return nameLocation;
            }else{
                System.out.println("Erro na chamada da api: " +  response.statusCode());
            }
        } catch (Exception e){
            System.err.println(e);
        }
        return "";
    }

    public String extractName(JsonObject json){
        JsonArray results = json.getAsJsonArray("results");
        if(results != null && !results.isEmpty()){
            return results.get(0).getAsJsonObject().get("formatted_adress").getAsString();
        }
        return "Localidade Desconhecida";
    }



}

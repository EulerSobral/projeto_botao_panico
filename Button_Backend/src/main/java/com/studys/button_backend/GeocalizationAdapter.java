package com.studys.button_backend;
import button_backend.LocationAdapter;
import button_backend.Location;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GeocalizationAdapter implements  LocationAdapter{
    private String apiKey;

    public void setApiKey(String apiKey) {this.apiKey = apiKey;}

    public String getApiKey() {return apiKey;}

    @Override
    public Location findLocalion(double latidude, double longitude){
        String url = String.format(
                "https://maps.googleapis.com/maps/api/geocode/json?latlng=%s,%s&key=%s",
                latidude, longitude, getApiKey()
        );

        HttpRequest request = request = HttpRequest.newBuilder().uri(URI.create(url)).timeout(Duration.ofSeconds(15)).GET().build();

        try{
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            if(responde.statusCode() == 200){
                JsonObject json = JsonParse.parseString(response.body()).getAsJsonObject();
                String nameLocation = extractName(json);
                return new Location(getLatidude(), getLongitude(), nameLocation);
            }else{
                System.out.println("Erro na chamada da api: " response.statusCode());
            }
        } catch (Exception e){
            System.out.prinln(e);
        }
    }
}
public String extractName(json){
    JsonArray results = json.getAsJsonArray("results");
    if(results != null && !results.isEmpty()){
        return results.get(0).getAsJsonObject().get("formatted_adress").getAsString();
    }
    return "Localidade Desconhecida"
}
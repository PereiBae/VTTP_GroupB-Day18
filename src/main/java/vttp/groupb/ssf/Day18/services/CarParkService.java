package vttp.groupb.ssf.Day18.services;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import vttp.groupb.ssf.Day18.models.CarPark;
import vttp.groupb.ssf.Day18.repositories.CarParkRepository;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class CarParkService {

    private static final String CARPARK_RATE_URL = "https://data.gov.sg/api/action/datastore_search";

    @Autowired
    private CarParkRepository carparkRepo;

    public List<CarPark> getCarParks() {
        String url = UriComponentsBuilder.fromUriString(CARPARK_RATE_URL)
                .queryParam("resource_id","d_9f6056bdb6b1dfba57f063593e4f34ae")
                .toUriString();

        //Create the GET request
        RequestEntity<Void> request = RequestEntity
                .get(url)
                .accept(MediaType.APPLICATION_JSON)
                .build();

        //Use RestTemplate to send the request
        RestTemplate restTemplate = new RestTemplate();

        // Create the List
        List<CarPark> carParkRates = new ArrayList<>();

        try{
            // Fetch Response
            ResponseEntity<String> response = restTemplate.exchange(request, String.class);
            String payload = response.getBody();

            // Pare Json String to a JsonArray
            JsonReader jsonReader = Json.createReader(new StringReader(payload));
            JsonObject jsonObject = jsonReader.readObject();

            System.out.println("Processing Json object");
            JsonArray records = jsonObject.getJsonObject("result").getJsonArray("records");
            for (JsonObject record : records.getValuesAs(JsonObject.class)) {
                int id = record.getInt("_id");
                String carpark = record.getString("carpark");
                String category = record.getString("category");
                String weekdaysRate1 = record.getString("weekdays_rate_1");
                String weekdaysRate2 = record.getString("weekdays_rate_2", "-");
                String saturdayRate = record.getString("saturday_rate", "-");
                String sundayHolidayRate = record.getString("sunday_publicholiday_rate", "-");

                CarPark carPark = new CarPark(id, carpark, category,weekdaysRate1,sundayHolidayRate,weekdaysRate2,saturdayRate);
                carParkRates.add(carPark);
                carparkRepo.save(carPark);
            }


        } catch (Exception e){
            e.printStackTrace();
        }

        return carParkRates;

    }

}

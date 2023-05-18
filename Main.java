import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        var string = getJson("https://procodeday-01.herokuapp.com/meet-up/get-country-list");
        parse(string);
    }

    public static void parse(String parse) throws Exception {
        var places = Service.readFileDrivers(parse);
        var list = List.of(places);
        parseNew(list);
    }
    
    public static void parseNew(List<Place> places) throws Exception {
        var str = places.stream().collect(Collectors.groupingBy(Place::getCountry));
        List<NewPlace> nn = new ArrayList<>();
        str.forEach((k,v)->{
            var newPlace = new NewPlace();
            newPlace.setCountry(k);
            v.forEach(vv -> {
                newPlace.addToList(vv.getCity());
            });
            newPlace.setCities_count(newPlace.getCities().size());
            nn.add(newPlace);
        });
        nn.forEach(newPlace -> {
            List<String> cities = newPlace.getCities();
            Collections.sort(cities);
            newPlace.setCities(cities);
        });

        Student student = new Student("Vlad Blindar",557809309,"github.com/vBlindar");
        Result result = new Result(student,nn);

        sendPostRequest(Service.toJson(result));
    }

    public static String getJson(String urlString) throws Exception {
        URL url = new URL(urlString);
        URLConnection conn = url.openConnection();
        InputStream is = conn.getInputStream();

        StringBuilder result = new StringBuilder();
        BufferedReader rd = new BufferedReader(new InputStreamReader(is));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        rd.close();
        return result.toString();
    }

    public static void sendPostRequest(String jsonString) throws Exception {
        URL url = new URL("https://procodeday-01.herokuapp.com/meet-up/post-request");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setDoOutput(true);
        try (OutputStream os = conn.getOutputStream()) {
            byte[] input = jsonString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }
        int responseCode = conn.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            System.out.println("POST request sent successfully.");
        } else {
            System.out.println("Failed to send POST request. Response code: " + responseCode);
        }
        conn.disconnect();
    }
}

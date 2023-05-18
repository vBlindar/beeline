import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.nio.file.Files;

public class Service {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    public static Place[] readFileDrivers(String json){
        return GSON.fromJson(json,Place[].class);
    }

    public static String toJson(Result json){
        return GSON.toJson(json);
    }
}

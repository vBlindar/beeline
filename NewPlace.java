import java.util.ArrayList;
import java.util.List;

public class NewPlace {

    private String country;
    private List<String> cities = new ArrayList<>();
    private int cities_count = cities.size();

    public void addToList(String city){
        cities.add(city);
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "NewPlace{" +
                "country='" + country + '\'' +
                ", cities=" + cities +
                ", cities_count=" + cities_count +
                '}';
    }

    public List<String> getCities() {
        return cities;
    }

    public void setCities(List<String> cities) {
        this.cities = cities;
    }

    public int getCities_count() {
        return cities_count;
    }

    public void setCities_count(int cities_count) {
        this.cities_count = cities_count;
    }
}

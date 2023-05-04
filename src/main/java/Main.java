import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        List<City> cities = new ArrayList<>();
        Scanner scanner = new Scanner(new FileInputStream("ВС_Java_Сбер.csv"));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(";");
            if (parts.length == 6) {
                String name = parts[1];
                String region = parts[2];
                String district = parts[3];
                int population = Integer.parseInt(parts[4]);
                String foundation = parts[5];
                City city = new City(name, region, district, population, foundation);
                cities.add(city);
            }
        }
        for (City city : cities) {
            System.out.println(city);
        }
    }
}
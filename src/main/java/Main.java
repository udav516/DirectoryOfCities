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
//        cities.sort(Comparator.comparing(City::getName, String.CASE_INSENSITIVE_ORDER).reversed());
//        cities.sort(Comparator.comparing(City::getDistrict).thenComparing(City::getName).reversed());
        for (City city : cities) {
//            System.out.println(city);
        }
        City[] array = cities.toArray(new City[0]);
        int index = 0;
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].getPopulation() > max) {
                max = array[i].getPopulation();
                index = i;
            }
        }
//        System.out.println("[" + index + "]" + " = " + max);
        Map<String, Integer> regionCount = new HashMap<>();
        for (City city : cities) {
            String region = city.getRegion();
            if (!regionCount.containsKey(region)) {
                regionCount.put(region, 1);
            } else {
                int count = regionCount.get(region);
                regionCount.put(region, count + 1);
            }
        }
        for (Map.Entry<String, Integer> entry : regionCount.entrySet()) {
            String region = entry.getKey();
            int count = entry.getValue();
            System.out.println(region + " - " + count);
        }
    }
}
import org.json.JSONObject;

public class CarToJson {

    static class Car {
        String make;
        String model;
        int year;

        public Car(String make, String model, int year) {
            this.make = make;
            this.model = model;
            this.year = year;
        }

        public JSONObject toJSONObject() {
            JSONObject json = new JSONObject();
            json.put("make", make);
            json.put("model", model);
            json.put("year", year);
            return json;
        }
    }

    public static void main(String[] args) {
        Car myCar = new Car("Toyota", "Camry", 2023);
        JSONObject carJson = myCar.toJSONObject();
        System.out.println(carJson.toString());
    }
}
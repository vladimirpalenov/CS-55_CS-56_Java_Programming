import java.util.ArrayList; // import the ArrayList class

public class Main {

    public static void main(String[] args) {

        // Test cases

        Truck<Car> carTruck = new Truck<>();
        Car car1 = new Car();
        car1.setDescription("Toyota", "Prius", 2021);
        carTruck.load(car1);
        Car car2 = new Car();
        car2.setDescription("Tesla", "Model 3", 2020);
        carTruck.load(car2);
        //carTruck.load(new TreeLog()); // compile error!
        System.out.println(carTruck.unload(1).returnDescription());


        Truck<TreeLog> treeTruck = new Truck<>();
        //treeTruck.load(new Car()); // compile error!
        TreeLog tree1 = new TreeLog();
        tree1.setDescription("Pine Tree", 2500);
        treeTruck.load(tree1);
        System.out.println(treeTruck.unload(0).returnDescription());

        Truck<RefrigeratedStorage> refrigeratedTruck = new Truck<>();
        //refrigeratedTruck.load(new Car()); // compile error!
        //refrigeratedTruck.load(new TreeLog()); // compile error!
        RefrigeratedStorage storage1 = new RefrigeratedStorage();
        storage1.setDescription("Vanilla Ice Cream", -10, 450);
        refrigeratedTruck.load(storage1);
        System.out.println(refrigeratedTruck.unload(0).returnDescription());
    }

    // Tnterface for generic cargo load
    public interface  Load{
    }
    // Car class implements Load
    // Has variables to store make model and year of the vehicle
    public static class Car implements Load {
        private String make;
        private String model;
        private int year;
        // setter for the variables values
        public void setDescription(String mk, String mdl, int yr) {
            this.make = mk;
            this.model = mdl;
            this.year = yr;
        }
        //this function returns make, model and year as one String
        public String returnDescription() {
            return make + ' ' + model + ' ' + year;
        }
    }

    // TreeLog class implements Load
    // Has variables to store treeType and weight
    public static class TreeLog implements Load {
        String treeType;
        int weight;
        //setter for the variables
        public void setDescription(String description, int wght) {
            this.treeType = description;
            this.weight = wght;
        }
        //this function returns tree type and weight
        public String returnDescription() {
            return treeType + ' ' + weight;
        }
    }

    // RefrigeratedStorage class implements Load
    // Has variables to store description of the cargo, weight and required temperature
    public static class RefrigeratedStorage implements Load {
        private String descript;
        private float weight;
        private float temperature;
        //setter for the variables
        public void setDescription(String description, float temp, float wght) {
            this.descript = description;
            this.temperature = temp;
            this.weight = wght;
        }
        //this function returns the description of the cargo, weight and temperature in one string
        public String returnDescription() {
            return descript + ' ' + weight + ' ' + temperature;
        }
    }

    // Truck class with generic placeholder
    public static class Truck <T>{
        // An ArrayList variable to store elements of generic type T
        private ArrayList<T> freight;
        // Constructor
        public Truck (){
            freight = new ArrayList<T>();
        }
        // Method to load cargo to the vehicle
        // Allows to add only specific type of cargo based on the Truck type
        public void load(T cargo){
            this.freight.add(cargo);
        }
        // Method to unload the item using it's index in the array list. Returns the removed item.
        public T unload(int index){
            T removed = this.freight.remove(index);
            return removed;
        }
    }
}

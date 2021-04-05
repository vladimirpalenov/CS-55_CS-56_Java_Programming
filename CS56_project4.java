public class Main {
    // Main method with test cases
    public static void main(String[] args) {

        Car car1 = new Car("Toyota", "Prius", 2020, "blue");
        Car car2 = new Car("Dodge", "Charger", 2017, "black");
        Car car3 = new Car("Nissan", "Altima", 2012, "grey");
        Car car4 = new Car("BMW", "M3", 2019, "white");
        Valet bellagio = new Valet(3);

        try {
            bellagio.park(car1);
            System.out.println(car1.toString() + " was successfully parked");
        } catch (NoSpaceAvailableException sp){
            sp.printStackTrace();
        }

        try {
            bellagio.park(car2);
            System.out.println(car2.toString() + " was successfully parked");
        } catch (NoSpaceAvailableException sp){
            sp.printStackTrace();
        }

        try {
            bellagio.park(car3);
            System.out.println(car3.toString() + " was successfully parked");
        } catch (NoSpaceAvailableException sp){
            sp.printStackTrace();
        }

        try {
            System.out.println("The car on the spot #2 is: " + bellagio.get(1).toString());
        } catch(NoCarException empty){
            empty.printStackTrace();
        }

        try {
            System.out.println("The car on the spot #1 : " + bellagio.leave(0).toString() + " has left the valet");
        } catch(NoCarException empty){
            empty.printStackTrace();
        }

        // Exceptions

        /*
        try {
            bellagio.park(car4);
            System.out.println(car4.toString() + " was successfully parked");
        } catch (NoSpaceAvailableException sp){
            sp.printStackTrace();
        }

        try {
            System.out.println("The car on the spot #1 : " + bellagio.leave(0).toString() + " has left the valet");
        } catch(NoCarException empty){
            empty.printStackTrace();
        }

        try {
            bellagio.park(car4);
            System.out.println(car4.toString() + " was successfully parked");
        } catch (NoSpaceAvailableException sp){
            sp.printStackTrace();
        }

        try {
            System.out.println("The car on the spot #4 is: " + bellagio.get(3).toString());
        } catch(NoCarException empty){
            empty.printStackTrace();
        }

        try {
            System.out.println("The car on the spot #5 : " + bellagio.leave(6).toString() + " has left the valet");
        } catch(NoCarException empty){
            empty.printStackTrace();
        }
    */


    }

    // Car class with make, model year and color variables
    public static class Car {

        // Class local variables
        private String make;
        private String model;
        private int year;
        private String color;

        // Getters and setters for the variables
        public String getMake() {
            return make;
        }
        public void setMake(String make) {
            this.make = make;
        }
        public String getModel() {
            return model;
        }
        public void setModel(String model) {
            this.model = model;
        }
        public int getYear() {
            return year;
        }
        public void setYear(int year) {
            this.year = year;
        }
        public String getColor() {
            return color;
        }
        public void setColor(String color) {
            this.color = color;
        }
        // Default class constructor
        public Car() {
        }
        // Custom class constructor with passed in arguments
        public Car(String make, String model, int year, String color) {
            this.make = make;
            this.model = model;
            this.year = year;
            this.color = color;
        }
        // Overridden method returning the String description of the car
        @Override
        public String toString() {
            return make + " " + model + " " + year + " " + color;
        }
    }
    //Valet class represents valet parking with limited number of parking spots
    public static class Valet {
        private int numberOfSpots;
        private Car[] spots;
        // Custom constructor with number of parking spots passed as an argument
        public Valet(int num) {
            this.numberOfSpots = num;
            spots = new Car[numberOfSpots];
        }
        // Method to assign the car to available spot or throw an exception
        void park(Car car) throws NoSpaceAvailableException{
            boolean success = false;
            for (int i = 0; i < numberOfSpots; i++){

                if (spots[i] == null){
                    spots[i] = car;
                    success = true;
                    return;
                }
            }
            if (!success){
                throw new NoSpaceAvailableException("Parking is full. No space for " + car.toString());
            }
        }
        // Method returning the car object on the given spot or throwing an exception
        Car get (int spot) throws NoCarException{
            if (spot >= numberOfSpots){
                throw new NoCarException("Wrong parking spot number");
            } else{
                if (spots[spot] == null){
                    throw new NoCarException("Parking spot is empty");
                } else{
                    return spots[spot];
                }
            }
        }
        // Method returning the car object on the given spot and removing it from the spot
        Car leave (int spot) throws NoCarException{
            Car leavingCar;
            if (spot >= numberOfSpots){
                throw new NoCarException("Wrong parking spot number");
            } else{
                if (spots[spot] == null){
                    throw new NoCarException("Parking spot is empty");
                } else{
                    leavingCar = spots[spot];
                    spots[spot] = null;
                    return leavingCar;
                }
            }
        }

    }
    // Exception handling class
    public static class NoSpaceAvailableException extends  Exception{
        public NoSpaceAvailableException(String message) {
            super(message);
        }
    }
    // Exception handling class
    public static class NoCarException extends Exception{
        public NoCarException(String message) {
            super(message);
        }
    }
}

// importing libraries
import java.util.ArrayList;

public class Project_2 {
    // Main method
    public static void main(String[] args) {
    // Creating a new CargoShip object
    CargoShip ship1 = new CargoShip();
    // Creating a new CargoAirplane object
    CargoAirplane airplane1 = new CargoAirplane();
    // Creating a new MailTruck object
    MailTruck truck1 = new MailTruck();
    // Creating the first package
    Package package1 = new Package();
    // Creating the new named item of the TV class (a subclass if Item class)
    TV tv1 = new TV();
    // Setting the description for the item
    tv1.setDescription("Samsung 4k 50 inch LED TV");
    // Adding the TV #1 to the first package
    package1.add(tv1);
    // Loading the first package on the Ship #1
    ship1.load(package1);
    // Creating an Item using anonymous class.
    Item laptop1 = new Item() {
        @Override
        public String returnDescription() {
            return "MacBook Pro 2021 15 inch";
        }
    };
    // Creating the second package
    Package package2 = new Package();
    // Adding the laptop1 to the Package #2
    package2.add(laptop1);
    // Loading package2 on the airplane1
    airplane1.load(package2);
    // Creating a printer1 Item object using lambda expression.
    Item printer1 = () -> "HP M1050 Laser Printer";
    // Creating the third package
    Package package3 = new Package();
    // Adding the printer1 to the Package #3
    package3.add(printer1);
    // Loading package3 o the truck1
    truck1.load(package3);
    // Test cases
    TV tv2 = new TV();
    tv2.setDescription("Panasonic 4k 70 inch LED TV");
    package2.add(tv2);
    // Showing packages loaded in the vehicles and items in each package
    System.out.println("Ship #1");
    ship1.showCargo();
    System.out.println("----------------");
    System.out.println("Airplane #1");
    airplane1.showCargo();
    System.out.println("----------------");
    System.out.println("Mail truck #1");
    truck1.showCargo();
    System.out.println("----------------");
    }
    /**
     An abstract class for deliveries
    **/
    public static abstract class Delivery{
        private String address;
        public String getAddress() {
            return address;
        }
        public void setAddress(String address) {
            this.address = address;
        }
    }

     /**
      The Letter class, inherits Delivery class.
      It contains a variable to store letter's text
      and methods to set/get the text
     **/
    public static class Letter extends Delivery{
        private String letterText;
        public void setLetterText(String letterText) {
            this.letterText = letterText;
        }
        public String getLetterText() {
            return letterText;
        }
    }

     /**
      The Package class, inherits Delivery class.
      It contains an arraylist of objects of the Item type to store all the items in the
      package. It has an add() method to add new items to the package, and showPackage()
      method to show all the items in the package.
     **/
    public static class Package extends Delivery {
        private ArrayList <Item> newPackage = new ArrayList<>(1);
        public void add (Item nextItem){
            this.newPackage.add(nextItem);
        }
        public void showPackage() {
            int iter = 1;
            for (Item item: newPackage){
                System.out.println("Item #" + iter);
                System.out.println(item.returnDescription());
                iter++;
            }
        }
    }

     /**
      The Item interface, for creating item objects added to the packages.
      It has returnDescription() method for returning the item's description.
     **/
    public interface  Item{
        public String returnDescription ();
    }

     /**
      TV class (named subclass of the Item class), implements class Item.
      it has a variable descript to store the description text
      and two methods: setDescription() and method returnDescription()
      to override the Items' method and return the TV's description.
     **/
    public static class TV implements Item {
        String descript;
        public void setDescription(String description) {
            this.descript = description;
        }
        @Override
        public String returnDescription() {
            return descript;
        }
    }

     /**
      Vehicle abstract class.
      It has a variable arraylist cargo to store the packages in the vehicle.
      It has two methods: load() to load a package into the vehicle and method showCargo()
      display the packages loaded into the vehicle.
     **/
    public static abstract class Vehicle{
        private ArrayList <Package> cargo = new ArrayList<>(1);
        public void load (Package a){
            this.cargo.add(a);
        }
        public void showCargo() {
            int iter = 1;
            for (Package pack: cargo){
                System.out.println("Package #" + iter);
                pack.showPackage();
                iter++;
            }
        }
    }

     /**
      class CargoShip inherits from Vehicle
     **/
    public static class CargoShip extends Vehicle{
    }

     /**
      class CargoAirplane inherits from Vehicle
     **/
    public static class CargoAirplane extends Vehicle{
    }

     /**
      class MailTruck inherits from Vehicle
     **/
    public static class MailTruck extends Vehicle{
    }


}

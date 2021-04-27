import java.util.*;
import java.util.Map.Entry;


public class Main {
    /** Main method **/
    public static void main(String[] args) {
        FurnitureBusiness business1 = new FurnitureBusiness();
        Customer cus1 = new Customer();
        cus1.setId(1);
        cus1.setName("John Doe");
        cus1.setAddress("Los Angeles");
        Customer cus2 = new Customer();
        cus2.setId(2);
        cus2.setName("Sarah Lee");
        cus2.setAddress("San Diego");
        Customer cus3 = new Customer();
        cus3.setId(3);
        cus3.setName("Ann Wright");
        cus3.setAddress("Santa Clarita");
        Furniture coffeeTable = new Table();
        coffeeTable.setName("Small black coffee table");
        Furniture diningTable = new Table();
        diningTable.setName("Large wooden dining table");
        Furniture reclinerElectric = new Recliner();
        reclinerElectric.setName("Electric lazy boy recliner");
        Furniture reclinerManual = new Recliner();
        reclinerManual.setName("Manual lazy boy recliner");
        Furniture diningChair = new Chair();
        diningChair.setName("Wooden dining chair");
        business1.purchase(cus1, coffeeTable);
        business1.purchase(cus1, reclinerElectric);
        business1.purchase(cus1, diningChair);
        business1.purchase(cus2, diningTable);
        business1.purchase(cus3, reclinerManual);
        for (Customer cus: business1.getTracking().keySet()){
            for (Entry<Customer, List<Furniture>>entr: business1.getTracking().entrySet()){
                System.out.println(cus.name + " " + entr);
            }
        }
        for (Customer cus: business1.getTracking().keySet()){
            String result = "" + cus.getName() + ": ";
            for (Furniture piece: business1.getPurchases(cus)){
                result = result + piece.name + "; ";
            }
            System.out.println(result);
        }
    }

    /** Customer class
     * stores id, name and address in private variables
     * has getters and setters and overridden methods for HashCode and equals
     * **/
    public static class Customer {
        private int id;
        private String name;
        private String address;

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getAddress() {
            return address;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setAddress(String address) {
            this.address = address;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o){
                return true;
            }
            if (!(o instanceof Customer)){
                return false;
            }
            Customer other = (Customer)o;
            if (!Objects.equals(this.id, other.id)){
                return false;
            }
            if (!Objects.equals(this.name, other.name)){
                return false;
            }
            if (!Objects.equals(this.address, other.address)){
                return false;
            }
            return true;
        }

        @Override
        public int hashCode() {
            int hash = 31;
            hash = 31 * hash + id;
            hash = 31 * hash + (name == null ? 0 : name.hashCode());
            hash = 31 * hash + (address == null ? 0 : address.hashCode());
            return hash;
        }
    }

    public static abstract class Furniture{
        private String name;
        private int modelNr;
        private double price;

        public String getName() {
            return name;
        }

        public int getModelNr() {
            return modelNr;
        }

        public double getPrice() {
            return price;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setModelNr(int modelNr) {
            this.modelNr = modelNr;
        }

        public void setPrice(double price) {
            this.price = price;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o){
                return true;
            }
            if (!(o instanceof Furniture)){
                return false;
            }
            Furniture other = (Furniture) o;
            if (!Objects.equals(this.modelNr, other.modelNr)){
                return false;
            }
            if (!Objects.equals(this.name, other.name)){
                return false;
            }
            return true;
        }

        @Override
        public int hashCode() {
            int hash = 31;
            hash = 31 * hash + modelNr;
            hash = 31 * hash + (name == null ? 0 : name.hashCode());
            return hash;
        }
    }
    /**A class for the table piece of furniture. Inherits Furniture.**/
    public static class Table extends Furniture{
    }
    /**A class for the recliner piece of furniture. Inherits Furniture.**/
    public static class Recliner extends Furniture{
    }
    /**A class for the chair piece of furniture. Inherits Furniture.**/
    public static class Chair extends Furniture{
    }

    public static class FurnitureBusiness{
        /**HashMap which keeps track of each customer and the furniture the customer has bought.**/
        private Map<Customer, List<Furniture>> tracking = new HashMap<>();
        /**Getter for the HashMap**/
        public Map<Customer, List<Furniture>> getTracking() {
            return tracking;
        }

        /**
         * Called when customer purchases new furniture. It tracks the
         * purchased furniture in the private map. If the customer does not yet exist in
         * the map, put the customer as a key and an empty list as a value. Then, get the
         * list for that customer and add the given furniture f to the list.
         */
        public void purchase(Customer c, Furniture f){
            if (!tracking.containsKey(c)){
                tracking.put(c, new ArrayList<Furniture>());
                tracking.get(c).add(f);
            } else{
                tracking.get(c).add(f);
            }
        }

        /**
         * Checks if the given customer has bought the furniture f
         * @return true if customer has bought furniture, false otherwise
         */
        public boolean hasBought(Customer c, Furniture f){
            boolean result = false;
            for (Furniture fun: tracking.get(c)){
                if (fun.equals(f)){
                    result = true;
                }
            }
            return result;
        }

        /**
         * Gets the purchased furniture for the given customer
         * @return List of furniture bought by given customer
         */
        public List<Furniture> getPurchases(Customer c){
            return tracking.get(c);
        }
    }

}
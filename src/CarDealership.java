import java.util.*;
import java.sql.*;

class CarModel {
    static void addModel(Connection conn, int brandID, int modelID, String name, int generation, int mileage) throws SQLException{ 
            // Add a new Car Model to the database
            String query = "INSERT INTO CarModel VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query); // Create a PreparedStatement object
            ps.setInt(1, modelID); // Set the values for the PreparedStatement object
            ps.setInt(2, brandID);
            ps.setString(3, name);
            ps.setInt(4, generation);
            ps.setInt(5, mileage);
            ps.executeUpdate();
            System.out.println("Car Model added successfully");
    }

    static void removeModel(Connection conn, int modelID) throws SQLException{
            // Remove a Car Model from the database
            String query = "DELETE FROM CarModel WHERE ModelID = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, modelID);
            ps.executeUpdate();
            System.out.println("Car Model removed successfully");
    }

    static void getLatestModel(Connection conn, int brandID) throws SQLException{
            // Get the latest Car Models of a Brand
            String query = "SELECT b.Name, m.ModelID, m.Name, m.Generation, m.AvgMileage "+
            "FROM CarModel m inner join CarBrand b on m.BrandID = b.BrandID WHERE b.BrandID = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, brandID);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                System.out.println("Brand Name: "+rs.getString(1));
                System.out.println("ModelID: "+rs.getInt(2));
                System.out.println("Name: "+rs.getString(3));
                System.out.println("Generation: "+rs.getInt(4));
                System.out.println("Average Mileage: "+rs.getInt(5));
            }
    }

    static void updateModel(Connection conn, int modelID, int generation, int mileage) throws SQLException{
            // Update the Car Model's Generation and Mileage
            String query = "UPDATE CarModel SET Generation = ?, AvgMileage = ? WHERE ModelID = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, generation);
            ps.setInt(2, mileage);
            ps.setInt(3, modelID);
            ps.executeUpdate();
            System.out.println("Car Model updated successfully");
    }
}

class Car {
    static void addCar(Connection conn, int carID, int modelID, String VIN, String colour, String manufactureDate) throws SQLException{
            // Add a new Car to the database
            String query = "INSERT INTO Car VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, carID);
            ps.setInt(2, modelID);
            ps.setString(3, VIN);
            ps.setString(4, colour);
            ps.setString(5, manufactureDate);
            ps.executeUpdate();
            System.out.println("Car added successfully");
    }

    static void removeCar(Connection conn, int carID) throws SQLException{
            // Remove a Car from the database
            String query = "DELETE FROM Car WHERE CarID = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, carID);
            ps.executeUpdate();
            System.out.println("Car removed successfully");
    }

    static void viewCarDetails(Connection conn, int carID) throws SQLException{
            // View details of a Car
            String query = "SELECT m.Name, c.VIN, m.ModelID, m.AvgMileage, m.Generation, c.Color FROM Car c inner join CarModel m on c.ModelID = m.ModelID WHERE CarID = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, carID);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                System.out.println("Name: "+rs.getString(1));
                System.out.println("VIN: "+rs.getString(2));
                System.out.println("ModelID: "+rs.getInt(3));
                System.out.println("Generation: "+rs.getInt(4));
                System.out.println("Color: "+rs.getString(5));
            }
    }

    static void changeCarColour(Connection conn, int carID, String colour) throws SQLException{
            // Change the Car's Colour
            String query = "UPDATE Car SET Color = ? WHERE CarID = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, colour);
            ps.setInt(2, carID);
            ps.executeUpdate();
            System.out.println("Car colour changed successfully");
    }
}

class Customer {
    static void addCustomer(Connection conn, int customerID, String firstName, String lastName, String email, long contactNumber) throws SQLException{
            // Add a new Customer to the database
            String query = "INSERT INTO Customer VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, customerID);
            ps.setString(2, firstName);
            ps.setString(3, lastName);
            ps.setString(4, email);
            ps.setLong(5, contactNumber);
            ps.executeUpdate();
            System.out.println("Customer added successfully");
    }

    static void removeCustomer(Connection conn, long contact) throws SQLException{
            // Remove a Customer from the database
            String query = "DELETE FROM Customer WHERE Phone = ?";
            System.out.println(contact);
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, String.valueOf(contact));
            ps.executeUpdate();
            System.out.println("Customer removed successfully");
    }

    static void viewCustomerDetails(Connection conn, int custID) throws SQLException{
            // View details of a Customer
            String query = "SELECT * FROM Customer WHERE CustID = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, custID);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                System.out.println("CustomerID: "+rs.getInt(1));
                System.out.println("First Name: "+rs.getString(2));
                System.out.println("Last Name: "+rs.getString(3));
                System.out.println("Email: "+rs.getString(4));
            }
    }

    static void updateCustomer(Connection conn, long oldContact, long newContact, String email) throws SQLException{
            // Update the Customer's Contact Information
            String query = "UPDATE Customer SET Phone = ?, Email = ? WHERE Phone = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, String.valueOf(newContact));
            ps.setString(2, email);
            ps.setString(3, String.valueOf(oldContact));
            ps.executeUpdate();
            System.out.println("Customer updated successfully");
    }

}

class CustomerCar {
    static void addCustomerCar(Connection conn, int transID, int carID, int customerID, String saleDate, int price) throws SQLException{
            // Add a new Car to the Customer's Cars
            String query = "INSERT INTO CustomerCar VALUES (?, ?, ?, ?, ?)";
            String query2 = "UPDATE Customer SET CarCount = CarCount + 1 WHERE CustomerID = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            PreparedStatement ps2 = conn.prepareStatement(query2);
            ps.setInt(1, transID);
            ps.setInt(2, carID);
            ps.setInt(3, customerID);
            ps.setString(4, saleDate);
            ps.setInt(5, price);
            ps2.setInt(1, customerID);
            ps.executeUpdate();
            ps2.executeUpdate();
            System.out.println("Customer's Car added successfully");
    }

    static void viewCustomerCars(Connection conn, int custID) throws SQLException{
            // View the Customer's Cars
            String query = "SELECT c.CarID, m.Name, c.VIN, m.ModelID, m.Generation, c.Color, cc.SaleDate FROM Car c inner join CarModel m on "+
            "c.ModelID = m.ModelID inner join CustomerCar cc on c.CarID = cc.CarID inner join Customer cust on cc.CustomerID = cust.CustomerID WHERE cust.CustomerID = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, custID);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                System.out.println("CarID: "+rs.getInt(1));
                System.out.println("Name: "+rs.getString(2));
                System.out.println("VIN: "+rs.getString(3));
                System.out.println("ModelID: "+rs.getInt(4));
                System.out.println("Generation: "+rs.getInt(5));
                System.out.println("Color: "+rs.getString(6));
                System.out.println("Sale Date: "+rs.getString(7));
            }
    }

}


public class CarDealership {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/Car_Dealership?allowPublicKeyRetrieval=true&useSSL=false";

    // Database credentials
    static final String USER = "root";
    static final String PASSWORD = "admin";

    static String m1 = "|"+"-".repeat(26)+"MENU"+"-".repeat(27)+"|";
    static String m2 = "|"+"-".repeat(57)+"|";
    static String m3 = "|"+"_".repeat(57)+"|";
    static String[] m = {". Add a Car Model", ". Add a Car", ". Add Customer ", ". Add a Customer's Car", 
    ". Remove a Car Model", ". Remove a Car", ". Remove a Customer", 
    ". View details of a car", ". View details of a customer", ". View Customer's Cars", ". Get the Latest Car Models of a Brand",
    ". Change Car Model's Generation and Mileage", ". Change Car's Colour",". Update Customer Contact Information",
    ". Exit"};

    static void printMenu(){
        // Print the Menu
        System.out.println(m1);
        System.out.println(m2);
        for(int i=0; i<m.length; i++) {
            System.out.println("| "+String.format("%2d",(i+1))+String.format("%-54s", m[i])+"|");
        }
        System.out.println(m3);
    }

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        Scanner sc = new Scanner(System.in);

        try {
            Class.forName(JDBC_DRIVER);

            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD); // Establish connection to the database
            conn.setAutoCommit(false); // Set auto-commit to false
            stmt = conn.createStatement();
            String[] query = {"SELECT max(carID)+1 FROM Car", "SELECT max(CustomerID)+1 FROM Customer", "SELECT max(TransactionID)+1 FROM CustomerCar"};
            int[] nextCarCustTrans = new int[3]; // To store the next CarID, CustomerID and TransactionID
            for(int i=0; i<3; i++) {
                ResultSet rs = stmt.executeQuery(query[i]);
                rs.next();
                nextCarCustTrans[i] = rs.getInt(1);
            }
            printMenu();
            System.out.println("Enter your choice: ");
            String choice = sc.next();

            while(true) {
                String[] inp;
                sc.nextLine();
                switch(choice) {
                    case "1":
                        System.out.println("Enter the Car Model details, brandID, modelID, name, gen and mileage: ");
                        inp = sc.nextLine().split(" ");
                        CarModel.addModel(conn, Integer.parseInt(inp[0]), Integer.parseInt(inp[1]), inp[2], Integer.parseInt(inp[3]), Integer.parseInt(inp[4]));
                        conn.commit();
                        break;
                    case "2":
                        System.out.println("Enter the Car details, modelID, VIN, colour and manufactureDate: ");
                        inp = sc.nextLine().split(" ");
                        Car.addCar(conn, nextCarCustTrans[0]++, Integer.parseInt(inp[0]), inp[1], inp[2], inp[3]);
                        conn.commit();
                        break;
                    case "3":
                        System.out.println("Enter the Customer details, fname, lname, email, contact: ");
                        inp = sc.nextLine().split(" ");
                        Customer.addCustomer(conn, nextCarCustTrans[1]++, inp[0], inp[1], inp[2], Long.parseLong(inp[3]));
                        conn.commit();
                        break;
                    case "4":
                        System.out.println("Enter the Customer's Car details, carID, custID, saleDate, price: ");
                        inp = sc.nextLine().split(" ");
                        CustomerCar.addCustomerCar(conn, nextCarCustTrans[2]++, Integer.parseInt(inp[0]), Integer.parseInt(inp[1]), inp[2], Integer.parseInt(inp[3]));
                        conn.commit();
                        break;
                    case "5":
                        System.out.println("Enter the Car ModelID for the model to remove: ");
                        inp = sc.nextLine().split(" ");
                        CarModel.removeModel(conn, Integer.parseInt(inp[0]));
                        conn.commit();
                        break;
                    case "6":
                        System.out.println("Enter the CarID for the car to remove: ");
                        inp = sc.nextLine().split(" ");
                        Car.removeCar(conn, Integer.parseInt(inp[0]));
                        conn.commit();
                        break;
                    case "7":
                        System.out.println("Enter the Customer contact whose details to remove: ");
                        inp = sc.nextLine().split(" ");
                        Customer.removeCustomer(conn, Long.parseLong(inp[0]));
                        conn.commit();
                        break;
                    case "8":
                        System.out.println("Enter the CarID whose details are to be viewed: ");
                        inp = sc.nextLine().split(" ");
                        Car.viewCarDetails(conn, Integer.parseInt(inp[0]));
                        break;
                    case "9":
                        System.out.println("Enter the Customer's ID to view details: ");
                        inp = sc.nextLine().split(" ");
                        Customer.viewCustomerDetails(conn, Integer.parseInt(inp[0]));
                        break;
                    case "10":
                        System.out.println("Enter the Customer's ID to view cars: ");
                        inp = sc.nextLine().split(" ");
                        CustomerCar.viewCustomerCars(conn, Integer.parseInt(inp[0]));
                        break;
                    case "11":
                        System.out.println("Enter the Brand ID to get the latest Car Models: ");
                        inp = sc.nextLine().split(" ");
                        CarModel.getLatestModel(conn, Integer.parseInt(inp[0]));
                        break;
                    case "12":
                        System.out.println("Enter the Car Model's ID, Generation and Mileage to change: ");
                        inp = sc.nextLine().split(" ");
                        CarModel.updateModel(conn, Integer.parseInt(inp[0]), Integer.parseInt(inp[1]), Integer.parseInt(inp[2]));
                        conn.commit();
                        break;
                    case "13":
                        System.out.println("Enter the Car's ID to change colours: ");
                        inp = sc.nextLine().split(" ");
                        Car.changeCarColour(conn, Integer.parseInt(inp[0]), inp[1]);
                        conn.commit();
                        break;
                    case "14":
                        System.out.println("Enter the Customer old Phone, followed by new phone and email: ");
                        inp = sc.nextLine().split(" ");
                        Customer.updateCustomer(conn, Long.parseLong(inp[0]), Long.parseLong(inp[1]), inp[2]);
                        conn.commit();
                        break;
                    case "15":
                        System.out.println("Exiting...");
                        try {
                            if(stmt!=null) {
                                stmt.close();
                            }
                        }
                        catch(SQLException se) {
                            se.printStackTrace();
                        }
                        System.exit(0);
                        break;
                    case "m":
                        printMenu();
                        System.out.println("Enter choice: ");
                        choice = sc.next();
                        continue;
                    default:
                        System.out.println("Invalid choice");
                }
                System.out.println("Enter choice or 'm' to show menu: ");
                choice = sc.next();
            }

        } 
        catch(SQLException se) {
            se.printStackTrace();
            if (conn!=null) {
                try {
                    // Rollback the transaction
                    System.out.println("Rolling back the transaction...");
                    conn.rollback();
                }
                catch(SQLException se2) {
                    System.out.println("Error in rolling back the transaction");
                    se.printStackTrace();
                }
            }
        } 
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                if(stmt!=null) {
                    stmt.close();
                }
            }
            catch(SQLException se) {
                se.printStackTrace();
            }
            try {
                if(conn!=null) {
                    conn.close();
                }
            }
            catch(SQLException se) {
                se.printStackTrace();
            }
            sc.close();
        }

    }
}

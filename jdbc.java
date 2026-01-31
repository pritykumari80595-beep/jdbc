import java.sql.*;
import java.util.Scanner;

public class jdbc {

    static final String URL ="jdbc:mysql://localhost:3306/hotel";
    static final String USER = "root";
    static final String PASSWORD = "root";

    static Connection con;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to Database");

            int choice;
            do {
                System.out.println("1. int Guest");
                System.out.println("2. upd Guest");
                System.out.println("3. Del Guest");
                System.out.println("4. Ret Guests");
                
                System.out.print("Enter choice: ");
                choice = sc.nextInt();
                sc.nextLine(); 

                switch (choice) {
                    case 1:
                        ins();
                        break;
                    case 2:
                        upd();
                        break;
                    case 3:
                        del();
                        break;
                    case 4:
                        ret();
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice");
                }
            } while (choice != 5);

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    static void ins() throws SQLException {
        String sql =
                "INSERT INTO guest (Guestname, contactno, Address) VALUES (?, ?, ?)";

        PreparedStatement ps = con.prepareStatement(sql);

        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter contact: ");
        String contact = sc.nextLine();
        System.out.print("Enter address: ");
        String address = sc.nextLine();

        ps.setString(1, name);
        ps.setString(2, contactno);
        ps.setString(3, Address);

        ps.executeUpdate();
        System.out.println("Guest inserted successfully");
    }

    


    static void upd() throws SQLException {
        String sql =
                "UPDATE guest SET Guestname=?, contactno=?, Address=? WHERE regid=?";

        PreparedStatement ps = con.prepareStatement(sql);

        System.out.print("Enter regid to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter new name: ");
        String name = sc.nextLine();
        System.out.print("Enter new contact: ");
        String contact = sc.nextLine();
        System.out.print("Enter new address: ");
        String address = sc.nextLine();

        ps.setString(1, name);
        ps.setString(2, contact);
        ps.setString(3, address);
        ps.setInt(4, id);

        int rows = ps.executeUpdate();
        if (rows > 0)
            System.out.println("Guest updated successfully");
        else
            System.out.println("Guest not found");
    }




    static void del() throws SQLException {
        String sql = "DELETE FROM guest WHERE regid=?";

        PreparedStatement ps = con.prepareStatement(sql);

        System.out.print("Enter regid to delete: ");
        int id = sc.nextInt();

        ps.setInt(1, id);

        int rows = ps.executeUpdate();
        if (rows > 0)
            System.out.println("Guest deleted successfully");
        else
            System.out.println("Guest not found");
    }

    


    static void ret() throws SQLException {
        String sql = "SELECT * FROM guest";

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);

        System.out.println("\n--- Guest Records ---");
        while (rs.next()) {
            System.out.println(
                    "ID: " + rs.getInt("regid") +
                    ", Name: " + rs.getString("Guestname") +
                    ", Contact: " + rs.getString("contactno") +
                    ", Address: " + rs.getString("Address") +
                    ", Time: " + rs.getTimestamp("created_at")
            );
        }
    }
}

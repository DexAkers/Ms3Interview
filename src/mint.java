import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class mint {
    private Connection connect() {
        Connection conn = null;
        return conn;
    }

    /** Creates new database **/
    public static void createNewDatabase(String fileName) {
        String url = "jdbc:sqlite:C:\\Users\\Dexter\\Desktop\\MS3\\ms3files\\" + fileName;
        try {
            Connection conn = DriverManager.getConnection(url);
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("An error occurred while connecting SQLite database");
        }
    }

    public static void main(String[] args) {
        createNewDatabase("input-filename.db");
    }

    createTable data = new createTable();

    public createTable getData() {
        return data;
    }

    /** Inserts data into table**/
    public void insert(String a, String b, String c, String d, String e, String f, float g, String h, String i, String j) {
        String sql = "INSERT INTO data(name, capacity) VALUES(?,?,?,?,?,?,?,?,?,?)";

        try{
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, a);
            pstmt.setString(2, b);
            pstmt.setString(3, c);
            pstmt.setString(4, d);
            pstmt.setString(5, e);
            pstmt.setString(6, f);
            pstmt.setFloat(7, g);
            pstmt.setString(8, h);
            pstmt.setString(9, i);
            pstmt.setString(10, j);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main3(String[] args) {
        mint app = new mint();
        // insert 10 new rows
        app.insert("Aryan", "car","cae","sfS","wfw","gvadv",425,"the","end","here");
        app.insert("Robert", "error","cbbbae","sfdvS","wfbsdbw","gvbbsadv",44125,"thebhe","ebsnd","hewre");
        try {
            BufferedReader reader;
            File file = new File("C:\\Users\\Dexter\\Desktop\\MS3\\ms3files/input-filename.db");
            reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }catch (IOException e) {
            System.out.println("Data is: ");
        }

    }
}
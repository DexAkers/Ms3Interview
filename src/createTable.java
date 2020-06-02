import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class createTable {

    public static void createNewTable() {
        // SQLite connection string  
        String url = "jdbc:sqlite:C:\\Users\\Dexter\\Desktop\\MS3\\final\\input-filename.db";

        // SQL statement for creating a new table  
        String sql = "CREATE TABLE IF NOT EXISTS data (\n"
                + " A text PRIMARY KEY,\n"
                + " B text NOT NULL,\n"
                + " C text real,\n"
                + ");";

        /**
         *             CREATE TABLE data (
         *                     a INTEGER PRIMARY KEY,
         *                     b TEXT NOT NULL,
         *                     c TEXT NOT NULL,
         *                     d TEXT NOT NULL UNIQUE,
         *                     e TEXT NOT NULL UNIQUE,
         *                     f TEXT NOT NULL,
         *                     g TEXT NOT NULL,
         *                     h TEXT NOT NULL,
         *                     i TEXT NOT NULL,
         *                     j TEXT NOT NULL,
         *                     );
         */

        try{
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        createNewTable();
    }

}
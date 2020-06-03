import java.io.*;
import java.sql.*;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ms3int {
    private static Connection conn = null;
    private static Statement stmt = null;
    //
    //  Connect and create a new database below named: gooddata.db
    //
    public static void createnewDatabase(String fileName){
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:gooddata.db");
            stmt = conn.createStatement();
            stmt.execute("DROP TABLE IF EXISTS csv;");
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("An error occurred while connecting SQLite database");
        }
    }
    //
    //  Create a new table that will have 10 columns like the csv file
    //
    public static void createNewTable() {
        String sql = "CREATE TABLE IF NOT EXISTS csv("
                + " A text,"
                + " B text,"
                + " C text,"
                + " D text,"
                + " E text,"
                + " F text,"
                + " G text,"
                + " H text,"
                + " I text,"
                + " J text"
                + ");";
        try{
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    //
    // Gets data that is correct and inserts into the table in the gooddata.db
    //
    public static void insert(String[] goodinfo) {

        String sql = "INSERT INTO csv (A,B,C,D,E,F,G,H,I,J) VALUES (?,?,?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, goodinfo[0]);
            pstmt.setString(2, goodinfo[1]);
            pstmt.setString(3, goodinfo[2]);
            pstmt.setString(4, goodinfo[3]);
            pstmt.setString(5, goodinfo[4]);
            pstmt.setString(6, goodinfo[5]);
            pstmt.setString(7, goodinfo[6]);
            pstmt.setString(8, goodinfo[7]);
            pstmt.setString(9, goodinfo[8]);
            pstmt.setString(10,goodinfo[9]);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    //
    //     Main program that reads the initial .csv file and determines where to place the data
    //
    public static void main(String[] args) {
        createnewDatabase("gooddata.db");
        createNewTable();
        try {
            int count = -1;
            int goodcount = -1;
            int badcount = 0;
            BufferedReader reader;
            BufferedWriter writer;
            File file = new File("ms3Interview.csv");
            String line;

            /** writes to the file**/
            File bad = new File("C:\\Users\\Dexter\\Desktop\\MS3/bad.csv");
            writer = new BufferedWriter(new FileWriter(bad));
            try {
                reader = new BufferedReader(new FileReader(file));
                writer = new BufferedWriter(writer);
                writer.write("A,B,C,D,E,F,G,H,I,J" + "\n");
                while ((line = reader.readLine()) != null) {
                    count++;
                    String search = ",,";
                    if (line.toLowerCase().contains(search.toLowerCase())) {
                        writer.write(line + "\n");
                        badcount++;
                    } else if (line.endsWith(",")) {
                        writer.write(line + "\n");
                        badcount++;
                    } else {
                        String[] goodinfo = line.split(",");
                        insert(goodinfo);
                        ++goodcount;
                    }
                }
            } catch (FileNotFoundException e){
                e.printStackTrace();
            }
            //
            //    Prints data to a log file and to console
            //
            final Logger LOGGER = Logger.getLogger(ms3int.class.getName());
            FileHandler handler = new FileHandler("input-filename.log");
            Logger logger = Logger.getLogger("input-filename");
            LOGGER.setLevel(Level.INFO);
            logger.addHandler(handler);
            logger.info("The TOTAL number of records recieved: " + count);
            logger.info("The number of GOOD records recieved: " + goodcount);
            logger.info("The number of BAD records recieved: " + badcount);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

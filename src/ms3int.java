import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ms3int {
    public static void main(String[] args) {
        try {
            int count = -2;
            int goodcount = -2;
            int badcount = 0;
            BufferedReader reader;
            File file = new File("C:\\Users\\Dexter\\Desktop\\MS3/ms3Interview.csv");
            reader = new BufferedReader(new FileReader(file));
            String line;

            while ((line = reader.readLine()) != null) {
                //Counts total number of records
                ++count;

//Prints content of line
                System.out.println(line);

//Searches for missing values
                String search = ",,";
                if (line.toLowerCase().contains(search.toLowerCase())) {
                    System.out.println("Missing data");
                    ++badcount;
                    //TODO
                } else if (line.endsWith(",")) {
                    System.out.println("Missing data");
                    ++badcount;
                    //TODO add this data to bad sql database
                }

//If no missing data, data is good.
                else {
                    System.out.println("Data is good");
                    ++goodcount;
                    //TODO add this data to good sql database
                    //TODO insert (line)
                }
            }

/** Prints data to a log file and to console**/
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

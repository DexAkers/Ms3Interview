The purpose of this repo is to parse a csv file line by line, determine if all fields contain data, and insert the lines
with completed fields into a new SQLite database, and insert the lines with incomplete data into a new .csv file. At the 
end the program will then print the total number of lines, number of correct lines, and number of incorrect lines into a 
.log file.
*
*
*
STEPS TO RUN
If you don't already have it you will need a SQLite .jar file to run the program.
For download you can visit: https://bitbucket.org/xerial/sqlite-jdbc/downloads/
Download & extract zip files
Download sqlite-jdbc-3.30.1.jar  *** Or whatever is the newest at the time
Add the .jar file in your class path *Dragging and dropping the file into your project is a quick way to do this
Create MS3 folder on desktop
create bad.csv file inside MS3 folder
Run ms3int.java with a java compiler
At the end the program there will be a bad.csv file, input-filename.txt, and gooddata.db file in the MS3 folder

*
*
*

For my design approach I decided to first locate and read the initial .csv file that the info is stored in(ms3Interview.csv). While reading the file the program will determine
if all fields are populated by checking if there are two consecutive delimiters marked as (',,') or if there i a delimiter at the end of the line. If one or both of the two cases
are true then the program will count the line as bad and will write the line to the bad.csv file. If neither case is true then the program will count the line as good and write
the line to a new database (gooddata.db).  At the end of the file the app will create a .log file that will contain the total number of lines read, total bad lines, and total good lines.

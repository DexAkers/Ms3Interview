The purpose of this repo is to parse a csv file line by line, determine if all fields contain data, and insert the lines
with completed fields into a new SQLite database, and insert the lines with incomplete data into a new .csv file. At the 
end the program will then print the total number of lines, number of correct lines, and number of incorrect lines into a 
.log file.


*NOTE: I am using the free intellij idea software for this project.*

Before using the app you need to make sure that you have a sqlite .jar file downloaded and know where the location is.
For download you can visit: https://bitbucket.org/xerial/sqlite-jdbc/downloads/
or:  https://sqlite.com/download.html

To run the program first create a folder on your desktop named MS3.Inside that folder place the .csv file you want to run
named ms3Interview. Then place the SQLite download into the folder also. The folder and file names are hard coded into the 
program so if you wish to use different names you have to edit the names in the code. Once that is done, open the file, 
make sure your paths are correct and run.
*NOTE: You will have to change in the path from 'Dexter' to what the users name is on your computer.
For class ms3int found on line 16
for calss mint found on line 15
for class createDatabase found on line 10*


*
*
*

For my approach I decided to first locate the initial .csv file that the info is stored in.  The program will then read the
file and determine if all fields are populated by checking to see if there are two consecutive delimiters (marked as ',,')
or if there is a delimiter at the end of the line.  If neither cases are true then the program counts the line as good 
and writes the line to a new database.  If one or both of the two cases are true then the program counts the line as bad
and writes the line to a new .csv file.  At the end the app creates a .log file that prints the number total number of
lines, total bad, and total good.
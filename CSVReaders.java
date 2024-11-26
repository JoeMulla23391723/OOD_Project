import java.util.*;
import java.io.*;

    public class CSVReaders {
        Scanner input;


        public CSVReaders(String filename) throws FileNotFoundException {
            input = new Scanner(new File(filename));
        }

        //Method to read the file rows one by one and splits it at each comma
        //By convention, each piece of data is called a token
        //Can put into a loop to read each row in a CSV file
        public String[] getValuesFromCSVFile() {
            String[] tokens;
            String row = input.nextLine();
            //Splitting the comma separated values into an array of strings
            tokens = row.split(",");
            return tokens;
        }

        public ArrayList<FullTimeEmployee> readFullTimeEmployees(){
            int lineNum = 0;
            ArrayList <FullTimeEmployee> employeeDetails = new ArrayList<FullTimeEmployee>();
            //Skips the header line
            String header = input.nextLine();

            //Loop to create a new Employee from the data - will read every line of the csv file
            while (input.hasNext()) {
                //get individual values from each line
                String[] tokens = getValuesFromCSVFile();
                //add these values to one single employee
                employeeDetails.add(new FullTimeEmployee(tokens));
            }

            input.close();
            return employeeDetails;
        }
        public ArrayList<PartTimeEmployee> readPartTimeEmployees(){
            int lineNum = 0;
            ArrayList <PartTimeEmployee> employeeDetails = new ArrayList<PartTimeEmployee>();
            //Skips the header line
            String header = input.nextLine();

            //Loop to create a new Employee from the data - will read every line of the csv file
            while (input.hasNext()) {
                //get individual values from each line
                String[] tokens = getValuesFromCSVFile();
                //add these values to one single employee
                employeeDetails.add(new PartTimeEmployee(tokens));
            }

            input.close();
            return employeeDetails;
        }


    }


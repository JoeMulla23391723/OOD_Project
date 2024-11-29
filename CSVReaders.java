import java.util.*;
import java.io.*;

    public class CSVReaders {
        Scanner input;


        public CSVReaders(String filename) throws FileNotFoundException {
            input = new Scanner(new File(filename));
        }

        //Method to read the file rows one by one and splits it at each comma
        //Each piece of data is called a token
        public String[] getValuesFromCSVFile() {
            String[] tokens;
            String row = input.nextLine();
            //Splitting the comma separated values into an array of strings
            tokens  = row.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
            return tokens;
        }

        // Method to read a CSV of full-time employee details into an array of objects of type 'Employee'
        public ArrayList<FullTimeEmployee> readFullTimeEmployees(){
            int lineNum = 0;
            ArrayList <FullTimeEmployee> employeeDetails = new ArrayList<FullTimeEmployee>();
            String header = input.nextLine();
            while (input.hasNext()) {
                String[] tokens = getValuesFromCSVFile();
                employeeDetails.add(new FullTimeEmployee(tokens));
            }
            input.close();
            return employeeDetails;
        }

        // Method to read a CSV of part-time employee details into an array of objects of type 'Employee'
        public ArrayList<PartTimeEmployee> readPartTimeEmployees(){
            int lineNum = 0;
            ArrayList <PartTimeEmployee> employeeDetails = new ArrayList<PartTimeEmployee>();
            //Skips the header line
            String header = input.nextLine();
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


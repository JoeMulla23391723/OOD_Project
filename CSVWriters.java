import java.io.*;
import java.util.*;

public class CSVWriters {
//Incomplete!!!!!!!
    PrintWriter writer;
    public CSVWriters(String filename) throws FileNotFoundException{
        writer = new PrintWriter(filename);
    }

    public void writeToString(String s) {
        writer.println(s);
    }

    public void writeEmployeesToCSV(ArrayList<Employee> employees, int numOfTests) {

        for(Employee employee : employees) {
            writeToString(employees.toString());
        }
        writer.close();
    }

}

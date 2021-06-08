import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Class that handles all necessary input/output operations.
 *
 * Recommendation: Do not change this.
 *
 * @author Koitz-Hristov
 */
public class IOHandler {
    /**
     * Reads the input file and parses it such that each line in the input file is an element in the
     * returned List.
     * @param filename the input file.
     * @return list of lines
     */
    public List<String> readInput(String filename) {
        List<String> result = new ArrayList<>();
        String line;
        BufferedReader in;
        try {
            in = new BufferedReader(new FileReader(filename));
            while ((line = in.readLine()) != null) {
                result.add(line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }




    /**
     * Prints the result to an output file that has the same name as the input file but instead of the extension ".in"
     * the extension ".out".
     * @param result String representing the result of the calculation to be stored in an output file.
     * @param input_filename Name of the input file.
     */
    public void printResultToOutputFile(String result, String input_filename, boolean append){
        String output_filename=input_filename.replace(".in", ".out").replace("input","output");
        File outputFile = new File(output_filename);
        FileWriter fw;
        try {
            if(append) {
                result="--------------------------\n" + result;
                fw = new FileWriter(outputFile,true);
            }
            else {
                fw = new FileWriter(outputFile);
            }
            fw.write(result);
            fw.flush();
            fw.close();
        } catch (IOException e) {
            System.err.println("Error: Could not write to file "+outputFile.getAbsolutePath());
            System.exit(-1);
        }
    }

}

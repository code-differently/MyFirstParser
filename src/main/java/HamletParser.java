import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.regex.Pattern;



public class HamletParser {
    private static final String FILE_NAME = "hamlet.txt";

    private String hamletData;

//Adding patterns to work with regEx;

    Pattern hamletPattern = Pattern.compile("Hamlet", Pattern.CASE_INSENSITIVE);
    Pattern horatioPattern = Pattern.compile("Horatio", Pattern.CASE_INSENSITIVE);

//Defining a constructor with no parameters HamletParser
    public HamletParser(){
        this.hamletData = loadFile();
    }

    //Todo: Add you code Here
//Creating a method FindHoratio;
//Searching through a text for multiple occurrences of a regular expression, using matcher;
//Finding and returning all occurrences of Horatio;
    public Boolean FindHoratio() {
        return horatioPattern.matcher(hamletData).find();
    }
//Same steps for finding occurrences of Hamlet in text file;
    public Boolean FindHamlet() {
        return hamletPattern.matcher(hamletData).find();
    }

//Creating a method changeHamletToJordan with one parameter String s;
//Replace all occurrences of Hamlet with Jordan. Returning the result
    public String changeHamletToJordan(String s) {
        return hamletPattern.matcher(s).replaceAll("Jordan");
    }

//Same steps for replacing occurrences of Horatio with Tariq;
    public String changeHoratioToTariq(String s) {
        return horatioPattern.matcher(s).replaceAll("Tariq");
    }

    public static void main(String[] args) {
        HamletParser hamletParser = new HamletParser();
        System.out.println(hamletParser.hamletData);
    }

    /**
     * DO NOT CHANGE CODE BELOW THIS LINE
     *
     */
    private String loadFile(){
        InputStream is = getFileFromResourceAsStream(FILE_NAME);
        StringBuilder output = new StringBuilder();
        try(InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(streamReader)){
            String line;
            while((line = reader.readLine()) != null){
                output.append(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return output.toString();
    }

    public String getHamletData(){
        return hamletData;
    }


    private InputStream getFileFromResourceAsStream(String fileName) {

        // The class loader that loaded the class
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        // the stream holding the file content
        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return inputStream;
        }

    }

    private File getFileFromResource(String fileName) throws URISyntaxException {

        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {

            // failed if files have whitespaces or special characters
            //return new File(resource.getFile());

            return new File(resource.toURI());
        }

    }
}

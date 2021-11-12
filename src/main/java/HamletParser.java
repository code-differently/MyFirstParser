import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class HamletParser {
    private static final String FILE_NAME = "hamlet.txt";

    private String hamletData;

    public HamletParser(){
        this.hamletData = loadFile();
    }

    //Todo: Add you code Here


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

package test.csg;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;

public class AppMain {
    public static void main(String[] args) {

        try {
            FileReader reader = new FileReader(Constants.PROP_FILE_NAME);
            Properties prop=new Properties();
            prop.load(reader);
            String inputTextPath = prop.getProperty(Constants.IN_FILE_NAME);
            String outputTextPath = prop.getProperty(Constants.OUT_FILE_NAME);
            String startingChar = prop.getProperty(Constants.STARTING_CHAR);
            int lengthOfChar = Integer.parseInt(prop.getProperty(Constants.LENGTH_OF_CHAR));

            CountService countService = new CountService();
            List<String> countGreaterThaFiveChars = countService.wordCountGreaterThanGivenLength(Path.of(inputTextPath), lengthOfChar);
            long countStartsWithChar = countService.wordCountStartsWithChar(Paths.get(inputTextPath), startingChar);

            BufferedWriter  writer = new BufferedWriter( new FileWriter( outputTextPath));

            writer.write("Count of Char starting with " + startingChar + " are "+ countStartsWithChar +"\n");

            writer.write("Words are having length "+ lengthOfChar +" are " );

            countGreaterThaFiveChars.stream().forEach(word -> {
                try {
                    writer.write(word);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            writer.close();

        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

package test.csg;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountService implements CountOperation {

    @Override
    public long wordCountStartsWithChar(Path textFilePath, String startChar) {
        long wordCount = 0;
        try {
            Stream<String> fileLines = Files.lines(textFilePath);

            wordCount = fileLines.parallel().
                    flatMap(line -> Arrays.stream(line.split(" "))).
                    filter(word -> word.startsWith(startChar) == true).count();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        return wordCount;
    }

    @Override
    public List<String> wordCountGreaterThanGivenLength(Path textFilePath, int length) {
        List<String> words = null;
        try {
            Stream<String> fileLines = Files.lines(textFilePath);
            words = fileLines.parallel().
                    flatMap(line -> Arrays.stream(line.split(" "))).
                    filter(word -> word.length() > length).collect(Collectors.toList());
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return words;
    }


}

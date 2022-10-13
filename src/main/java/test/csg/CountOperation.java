package test.csg;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public interface CountOperation {

    long wordCountStartsWithChar(Path name, String startChar);

    List<String> wordCountGreaterThanGivenLength(Path name, int length);

}

package test.csg;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.nio.file.Path;
import java.util.List;

public class CountServiceTest {

        public CountService service ;

        public String textpath;
        @Before
        public void init()
        {
                service = new CountService();
                textpath = "C:\\Users\\Nagendra_Budda\\Desktop\\test-word-count\\src\\test\\java\\resources\\test.txt";
        }

        @Test
        public void testWordCountGreaterThanGivenLength() {
              List<String> res =   service.wordCountGreaterThanGivenLength(Path.of(textpath),5);
              Assert.assertEquals(1,res.size());
        }

        @Test
        public void testWordCountStartsWithChar() {
                long res =   service.wordCountStartsWithChar(Path.of(textpath),"M");
                Assert.assertEquals(1,res);
        }

}

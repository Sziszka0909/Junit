import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Created by sziszka on 2017.05.14..
 */
public class TestFilePartReader {

    String filePath = "/home/sziszka/codecool/Junit/src/test/resources/test.txt";

    @Test
    public void readLinesTest()throws IOException {
        String lines = "barack,\nalma,\nkörte,\n";
        FilePartReader filePartReader = new FilePartReader(filePath, 1, 3);
        assertEquals(lines, filePartReader.readlines());
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalArgumentExceptionTest() {
        FilePartReader filePartReader = new FilePartReader(filePath, 3, 1);
    }

    @Test(expected = FileNotFoundException.class)
    public void fileNotFoundExceptionTest() throws IOException {
        String fpath = "/home/sziszka/codecool/Junit/src/test/resources/testfajl.txt";
        FilePartReader fpr = new FilePartReader(fpath, 1, 3);
        fpr.readlines();
    }

}

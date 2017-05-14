import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by sziszka on 2017.05.14..
 */
public class TestFileWordAnalyzer {

    String filepath = "/home/sziszka/codecool/Junit/src/test/resources/test.txt";
    FilePartReader filePartReader = new FilePartReader(filepath, 1, 3);

    @Test
    public void sortFileWordsByAbcOrder() throws IOException {
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);
        ArrayList<String> lines = new ArrayList<String>();
        lines.add("alma");
        lines.add("barack");
        lines.add("körte");
        assertEquals(lines, fileWordAnalyzer.wordsByABC());
    }

    @Test
    public void substringInWords() throws IOException {
        FileWordAnalyzer fwa = new FileWordAnalyzer(filePartReader);
        ArrayList<String> words = new ArrayList<String>();
        words.add("barack");
        words.add("alma");
        assertEquals(words, fwa.wordsContainingSubString("a"));
    }
}

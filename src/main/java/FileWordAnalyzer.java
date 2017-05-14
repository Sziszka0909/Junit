import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by sziszka on 2017.05.14..
 */
public class FileWordAnalyzer {

    FilePartReader filePartReader;
    public FileWordAnalyzer(FilePartReader filePartReader) {
        this.filePartReader = filePartReader;
    }

    public ArrayList wordsByABC() throws IOException {

        String lines = filePartReader.readlines();
        lines = lines.replaceAll("[,|.]", "");
        ArrayList<String> order = new ArrayList<String>(Arrays.asList(lines.split("\\s")));
        Collections.sort(order, String.CASE_INSENSITIVE_ORDER);
        return order;
    }

    public ArrayList wordsContainingSubString(String substring) throws IOException {
        String linesFromFile = filePartReader.readlines();
        linesFromFile = linesFromFile.replaceAll("[,|.]", "");
        String[] lines = linesFromFile.split("\\s");
        ArrayList<String> wordsContainsSubsting = new ArrayList<String>();

        for (String e : lines) {
            if (e.toLowerCase().contains(substring.toLowerCase())) {
                wordsContainsSubsting.add(e);
            }

        }
        return wordsContainsSubsting;


    }
}

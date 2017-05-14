import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by sziszka on 2017.05.14..
 */
public class FilePartReader {

    String filepath;
    Integer fromLine;
    Integer toLine;

    public FilePartReader(String filepath, Integer fromLine, Integer toLine) {
        if (toLine < fromLine || fromLine < 1)
        {
            throw new IllegalArgumentException("Error");
        }
        this.filepath = filepath;
        this.fromLine = fromLine;
        this.toLine = toLine;
    }

    private String read() throws IOException {
        FileReader file = new FileReader(filepath);
        BufferedReader bfreader = new BufferedReader(file);

        String filecontent = "";
        String currentline;

        while ((currentline = bfreader.readLine()) != null) {
            filecontent += currentline + "\n";
        }
        return filecontent;

    }

    public String readlines()throws IOException {
        String result = "";

        String content = this.read();
        StringBuilder sBuilder = new StringBuilder();
        String[] lines = content.split("\n");

        for (int i = 0; i < content.length(); i++) {
            if (i >= (fromLine - 1) && i < toLine) {
                sBuilder.append(lines[i] + "\n");
            }
        }
        result = sBuilder.toString();

        return result;
    }
}

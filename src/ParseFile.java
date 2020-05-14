import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseFile {
    String path;
    String countLine;
    String lineForSearch;
    String lineForReplace;
    List<String> links1;

    public ParseFile(String path, String countLine, String lineForSearch, String lineForReplace) {
        this.path = path;
        this.countLine = countLine;
        this.lineForSearch = lineForSearch;
        this.lineForReplace = lineForReplace;
    }

    public int compare() throws IOException {
        int count = 0;
        String content = String.valueOf(Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8));
        Pattern pattern = Pattern.compile(countLine);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            count++;
        }
        return count;
    }

    public void replacement() throws IOException {
        links1 = java.nio.file.Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
        for (int i = 0; i < links1.size(); i++) {
            String line = links1.get(i);
            String str = line.replaceAll(lineForSearch, lineForReplace);
            links1.set(i, str);
        }
    }

    public void saveFile() throws IOException {
        FileOutputStream output = new FileOutputStream(path);
        final String LINE_SEPARATOR = System.getProperty("line.separator");
        for (String line1 : links1) {
            if (line1 != null) {
                output.write(line1.getBytes());
                output.write(LINE_SEPARATOR.getBytes());
            }
        }
    }
}

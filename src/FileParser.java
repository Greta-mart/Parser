import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileParser {
    String path;
    String searchPattern;
    String lineForReplace;
    List<String> allLines;

    public FileParser(String path, String searchPattern, String lineForReplace) {
        this.path = path;
        this.searchPattern = searchPattern;
        this.lineForReplace = lineForReplace;
    }

    public int compare() throws IOException {
        int count = 0;
        String content = String.valueOf(Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8));
        Pattern pattern = Pattern.compile(searchPattern);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            count++;
        }
        return count;
    }

    public void replacement() throws IOException {
        allLines = java.nio.file.Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
        for (int i = 0; i < allLines.size(); i++) {
            String line = allLines.get(i);
            allLines.set(i, line.replaceAll(searchPattern, lineForReplace));
        }
        FileOutputStream output = new FileOutputStream(path);
        final String LINE_SEPARATOR = System.getProperty("line.separator");
        for (String line1 : allLines) {
            if (line1 != null) {
                output.write(line1.getBytes());
                output.write(LINE_SEPARATOR.getBytes());
            }
        }

    }
}

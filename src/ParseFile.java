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
    String content;

    public ParseFile(String path, String countLine, String lineForSearch, String lineForReplace)  {
        this.path = path;
        this.countLine = countLine;
        this.lineForSearch = lineForSearch;
        this.lineForReplace = lineForReplace;
    }

    public int compare() throws IOException {
        int count = 0;
        String content  = String.valueOf(Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8));
        Pattern pattern = Pattern.compile(countLine);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            count++;
        }
        return count;
    }

    public void replacement() throws IOException {
        content  = String.valueOf(Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8));
        Pattern pattern = Pattern.compile(lineForSearch);
        Matcher matcher = pattern.matcher(content);
        content = matcher.replaceAll(lineForReplace);
    }

    public void saveFile() throws IOException {
        try(FileWriter writer = new FileWriter(path))
        {
            writer.write(content);
            writer.append('\n');
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}

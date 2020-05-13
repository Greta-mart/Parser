import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.List;

public class ParseFile {
    String path;
    String countLine;
    String lineForSearch;
    String lineForReplace;

    public ParseFile(String path, String countLine, String lineForSearch, String lineForReplace) {
        this.path = path;
        this.countLine = countLine;
        this.lineForSearch = lineForSearch;
        this.lineForReplace = lineForReplace;
    }

    public void compare() {
        int count = 0;
        try {
            List<String> links1 = java.nio.file.Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
            for (String line : links1) {
                if (line.equals(countLine)) {
                    count = count + 1;
                }
            }
            System.out.println("The number of founded line: " + count);
        } catch (IOException e) {
            System.out.println(e);
        }
        if (count == 0) {
            System.out.println("The entered line isn't founded in this file");
        }
    }

    public void replacement()  {
        StringBuilder sb = new StringBuilder();
        List<String> links1 = null;
        try {
            links1 = java.nio.file.Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String line : links1) {
            if (line.equals(lineForSearch)) {
                int i = links1.indexOf(line);
                links1.set(i, lineForReplace);
            }
        }
        FileOutputStream output = null;
        try {
            try {
                output = new FileOutputStream(path);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            final String LINE_SEPARATOR = System.getProperty("line.separator");
            for (String line1 : links1) {
                if (line1 != null) {
                    output.write(line1.getBytes());
                    output.write(LINE_SEPARATOR.getBytes());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException ignore) {
                }
            }
        }
    }
}

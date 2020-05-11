import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class ParseFile {
    String path;
    String countLine;
    String lineForSearch;
    String lineForReplace;
    Path fileName;

    public ParseFile(String path, String countLine, String lineForSearch, String lineForReplace) {
        this.path = path;
        this.countLine = countLine;
        this.lineForSearch = lineForSearch;
        this.lineForReplace = lineForReplace;
    }

    public void readPath() throws IOException {
        Scanner s = new Scanner(System.in);
        System.out.print("Please enter the address of the file : ");
        path = s.nextLine();
        Path testFilePath = Paths.get(path);

        fileName = testFilePath.getFileName();
        System.out.println(fileName);

        Path parent = testFilePath.getParent();
        System.out.println(parent);

      /*  System.out.print("Please enter the address of the line to count : ");
        countLine = s.nextLine();
*/
        System.out.print("Please enter the address of the line for search : ");
        lineForSearch = s.nextLine();

        System.out.print("Please enter the address of the line for replacement : ");
        lineForReplace = s.nextLine();

        try (FileReader reader = new FileReader(path)) {
            // читаем посимвольно и вывести - просто пробую работает ли
            int c;
            while ((c = reader.read()) != -1) {

                System.out.print((char) c);
            }
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }
/*    public void readFile() {
        try (FileReader reader = new FileReader(path)) {
            int c;
            while ((c = reader.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    public void compare() {
        try {
            int count = 0;
            List<String> links1 = java.nio.file.Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
            for (String line : links1) {
                if (line.equals(countLine)) {
                    count = count + 1;
                }
            }
            System.out.println(count);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void replacement() throws IOException {
        StringBuilder sb = new StringBuilder();
        List<String> links1 = java.nio.file.Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
        for (String line : links1) {
            if (line.equals(lineForSearch)) {
                line.replaceAll(lineForSearch, lineForReplace);
                FileWriter fileWriter = new FileWriter(String.valueOf(path));
            }
        }
    }
}
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

import static java.nio.file.Files.newBufferedReader;
import static java.nio.file.Files.readAllLines;

public class Files {
    String path;
    String countLine;

    public Files(String path, String countLine) {
        this.path = path;
        this.countLine = countLine;
    }

    public void readPath () throws IOException {
        Scanner s = new Scanner(System.in);
        System.out.print("Please enter the address of the file : ");
        String path = s.nextLine();
        Path testFilePath = Paths.get(path);

        Path fileName = testFilePath.getFileName();
        System.out.println(fileName);

        Path parent = testFilePath.getParent();
        System.out.println(parent);
        System.out.print("Please enter the address of the line to count : ");
        countLine = s.nextLine();
        
        try(FileReader reader = new FileReader(path))
        {
            // читаем посимвольно и вывести - просто пробую работает ли
            int c;
            while((c=reader.read())!=-1){

                System.out.print((char)c);
            }
        }
        catch(IOException ex){

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

            public void compare () {
                try {
                    List<String> links1 = java.nio.file.Files.readAllLines(Paths.get(path));
                    for (String line : links1) {
                        if (line.equals(countLine)) {
                            System.out.println(line);
                        }
                    }
                } catch (IOException e) {
                    System.out.println(e);
                }
            }
        }
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Files {


    public void readPath () throws IOException {
        Scanner s = new Scanner(System.in);
        System.out.print("Please enter the address of the file : ");
        String path = s.nextLine();
        Path testFilePath = Paths.get(path);

        Path fileName = testFilePath.getFileName();
        System.out.println(fileName);

        Path parent = testFilePath.getParent();
        System.out.println(parent);

        try(FileReader reader = new FileReader(String.valueOf(fileName)))
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
}


import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        String path = "";
        String countLine= "";
        /*if (args.length ==2) {
            try {
                path = args[0];
                countLine = args[1];
            } catch (Exception ex) {
                System.out.println(ex.getLocalizedMessage());
            }
            Files f = new Files(path, countLine);
           // f.readFile();
            f.compare();
        }
        else {
            System.out.println("Please insert width and length after name of class");
            System.exit(1);
        }*/
        Files f = new Files(path, countLine);
        //f.readFile();
        f.readPath();
        f.compare();
    }
}
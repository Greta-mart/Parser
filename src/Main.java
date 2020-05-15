import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String path = "";
        String searchPattern = "";
        String lineForReplace = "";

        if (args.length == 2) {
            path = args[0];
            searchPattern = args[1];

            FileParser f = new FileParser(path, searchPattern, lineForReplace);
            try {
                System.out.println(f.compare());
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else if (args.length == 3) {
            path = args[0];
            searchPattern = args[1];
            lineForReplace = args[2];

            FileParser f = new FileParser(path, searchPattern, lineForReplace);
            try {
                f.replacement();
                System.out.println("File was successfully saved with replacement data");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Please insert path for file, line for search or line for search and than line for replace");
            System.exit(1);
        }
    }
}
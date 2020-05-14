import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String path = "";
        String searchPattern = "";
        String lineForReplace = "";

        if (args.length == 2) {
            path = args[0];
            searchPattern = args[1];

            ParseFile f = new ParseFile(path, searchPattern, lineForReplace);
            System.out.println(f.compare());

        } else if (args.length == 3) {
            path = args[0];
            searchPattern = args[1];
            lineForReplace = args[2];

            ParseFile f = new ParseFile(path, searchPattern, lineForReplace);
            f.replacement();
            f.saveFile();
            System.out.println("File was successfully saved with replacement data");

        } else {
            System.out.println("Please insert path for file, line for search or line for search and than line for replace");
            System.exit(1);
        }
    }
}
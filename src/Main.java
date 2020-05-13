import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String path = "";
        String countLine = "";
        String lineForSearch = "";
        String lineForReplace = "";

        if (args.length == 2) {
            try {
                path = args[0];
                countLine = args[1];
            } catch (Exception ex) {
                System.out.println(ex.getLocalizedMessage());
            }
            ParseFile f = new ParseFile(path, countLine, lineForSearch, lineForReplace);
            f.compare();
        } else if (args.length == 3) {
            try {
                path = args[0];
                lineForSearch = args[1];
                lineForReplace = args[2];
            } catch (Exception ex) {
                System.out.println(ex.getLocalizedMessage());
            }
            ParseFile f = new ParseFile(path, countLine, lineForSearch, lineForReplace);
            f.replacement();
            System.out.println("File was successfully saved with replacement data");
        } else {
            System.out.println("Please insert path for file, line for search or line for search and than line for replace");
            System.exit(1);
        }
    }
}
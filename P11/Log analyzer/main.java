import java.nio.file.*;
import java.io.IOException;
import java.util.*;

public class main{
    public static void main(String[] args) throws IOException {
        Path folder = Paths.get("logs");
        Files.createDirectories(folder);

        Files.write(folder.resolve("app1.txt"), Arrays.asList(
            "User login successful",
            "Error in database",
            "User logout"
        ));

        Files.write(folder.resolve("app2.txt"), Arrays.asList(
            "Error in payment",
            "User login successful",
            "System started"
        ));

        String keyword = "error";
        int totalLines = 0;
        int matchedLines = 0;

        try (DirectoryStream<Path> files =
                Files.newDirectoryStream(folder, "*.txt")) {
            for (Path file : files) {
                List<String> lines = Files.readAllLines(file);
                int size = lines.size();
                int matches = 0;

                for (String line : lines) {
                    totalLines++;
                    if (line.toLowerCase().contains(keyword)) {
                        matchedLines++;
                        matches++;
                    }
                }

                System.out.println("File: " + file.getFileName());
                System.out.println("Size: " + Files.size(file) + " bytes");
                System.out.println("Lines: " + size);
                System.out.println("Keyword matches: " + matches);
            }
        }

        System.out.println("Total lines: " + totalLines);
        System.out.println("Lines containing error: " + matchedLines);
        System.out.println("Dhairy Chauhan 25ce015");
    }
}

import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.io.IOException;
import java.util.*;

public class main{
    public static void main(String[] args) throws IOException {
        Path folder = Paths.get("logs");
        Files.createDirectories(folder);
        Path report = Paths.get("folder_report.txt");

        List<String> details = new ArrayList<>();
        details.add("Folder Report");

        Files.walkFileTree(folder, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file,
                    BasicFileAttributes attrs) {
                try {
                    details.add("Name: " + file);
                    details.add("Size: " + attrs.size() + " bytes");
                    details.add("Modified: " + attrs.lastModifiedTime());
                } catch (Exception e) {
                    details.add("Could not read: " + file);
                }
                return FileVisitResult.CONTINUE;
            }
        });

        Files.write(report, details);

        System.out.println("Folder scan completed");
        System.out.println("Report saved to: " + report.toAbsolutePath());
        System.out.println("Files listed: " + (details.size() - 1) / 4);
        System.out.println("Dhairy Chauhan 25CE015");
    }
}

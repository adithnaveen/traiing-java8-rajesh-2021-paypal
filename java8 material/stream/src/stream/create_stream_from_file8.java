package stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class create_stream_from_file8 {
  public static void main(String[] args) {
    Path path = Paths.get("c:/javafromjavascript.js");
    try (Stream<String> lines = Files.lines(path)) {
      lines.forEach(System.out::println);
    } catch (IOException e) {
      e.printStackTrace();
    }
    
    //directory
    Path dir = Paths.get("c:/");
    System.out.printf("%nThe file tree for %s%n", 
        dir.toAbsolutePath());
    try (Stream<Path> fileTree = Files.walk(dir)) {
      fileTree.forEach(System.out::println);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
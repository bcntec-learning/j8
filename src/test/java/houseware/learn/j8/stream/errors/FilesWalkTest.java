package houseware.learn.j8.stream.errors;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author fphilip@houseware.es
 */
public class FilesWalkTest {

    @Test
    public void files_walk() throws IOException {
        Files.walk(Paths.get(System.getProperty("user.dir"))).forEach(System.out::println);
    }

    @Test
    public void files_walk8() throws IOException {
        Files.walk(Paths.get(".")).forEach(System.out::println);
    }


    @Test
    public void files_walk_error() throws IOException {
        Files.walk(Paths.get("."))
         .filter(p -> !p.toFile().getName().startsWith("."))
         .forEach(System.out::println);
    }



    @Test
    public void files_walk_ok() throws IOException {
        Files.walk(Paths.get("."))
             .filter(p -> !p.toString().contains(File.separator + "."))
             .forEach(System.out::println);


    }

}

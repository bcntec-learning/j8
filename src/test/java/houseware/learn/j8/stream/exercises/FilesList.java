package houseware.learn.j8.stream.exercises;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class FilesList {

    public static void main(String[] args) {

        getFile("j8/el-aleph.txt",System.out::println);
    }

    private static void getFile(String fileName, Consumer<? super String> action) {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            stream.forEach(action);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
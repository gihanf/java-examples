package nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.stream.Stream;

public class Nio2 {

    public static final Path NIO2_DIR_AS_PATH = Paths.get("./src/main/java/nio2");

    public static void main(String[] args) {

        try {
            Files.find(Paths.get("./src/main/java/nio2"), 3, (p, a) -> !p.endsWith(".java"))
                    .filter(path -> path.toFile().isFile())
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            System.out.println("Listing the contents of the nio2 directory");
            Files.list(NIO2_DIR_AS_PATH)
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String file1pathString = NIO2_DIR_AS_PATH.toFile().getPath() + "/depth1/file1";

        Path path = Paths.get("/user/.././root");
        System.out.println("path.normalize() = " + path.normalize());
        path.resolve(path);

        try {
            BasicFileAttributes attributes = Files.readAttributes(Paths.get(file1pathString), BasicFileAttributes.class);
            System.out.println("attributes = " + attributes);
            System.out.println("attributes.size() = " + attributes.size());
        } catch (IOException e) {
            e.printStackTrace();
        }

        Path path1 = Paths.get("/turkey");
        Path path2 = Paths.get("duck");
        System.out.println(path1.resolve(path2));

        Path p = Paths.get("./boo.txt").normalize();
        System.out.println("p = " + p);

        try {
            System.out.println("Reading the contents of a file using functionalProgramming.streams");
            Path file1Path = Paths.get(NIO2_DIR_AS_PATH.toString(), "/depth1/file1");
            Files.lines(file1Path)
                    .flatMap(line -> Stream.of(line.split(",")))
                    .map(String::toUpperCase)
                    .forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }

        Path path3 = Paths.get(".", "depth2");
//        path3 = path3.toAbsolutePath();
        path3 = path3.resolve("./depth1");
        try {
            path3 = path3.toRealPath(LinkOption.NOFOLLOW_LINKS);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("path3 = " + path3);
    }
}

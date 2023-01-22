package thinking.files;

import java.io.*;
import java.nio.file.Files;
import java.util.Scanner;

public class CreateAndWriteToFile {
    private static final String DATA = "This is just some text that java program writes to file";

    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\tgeor\\Downloads\\";
        System.out.print("Name your file: ");
        String fileName = new Scanner(System.in).nextLine();
        File file = createFile(path, fileName);
        writeToFile(file);
        readFile(file);

    }

    private static void readFile(File file) {
        try {
            Files.lines(file.toPath()).forEach(line -> {
                String replace = line.replace("writes to file", "reads from file");
                System.out.println(replace);
            });
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (IOException e) {
            System.out.println("Can't read that");
        }
    }

    private static void writeToFile(File file) throws IOException {
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(DATA.getBytes());
        fos.flush();
        fos.close();
    }

    private static File createFile(String path, String fileName) throws IOException {
        File file = new File(path + fileName);
        if (file.createNewFile()) {
            System.out.println(file.getPath());
        } else System.out.println("e");
        return file;
    }
}

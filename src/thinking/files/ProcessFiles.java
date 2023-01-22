package thinking.files;

import javax.swing.*;
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;

import static thinking.files.ProcessFiles.chooseDate;
import static thinking.files.ProcessFiles.doubleBufferDemo;
import static thinking.files.SynchronizedRunner.getTime;

public class ProcessFiles {
    private static final int BSIZE = 1024;


    public static void main(String[] args) throws IOException {


       // doubleBufferDemo();
        File selectedFile = getFile();
        Scanner sc = new Scanner(System.in);
        int[] date = chooseDate(sc);
        int day = date[0];
        int month = date[1];
        int year = date[2];
        long time = getTime();
        listAllFilesFromDirToBottomFilterLastModified(selectedFile,day,month,year);
        long result = getTime()-time;
        System.out.println(result);
        /*
        Exercise 11: (2) In the innerclasses/GreenhouseController.java example,
GreenhouseController contains a hard-coded set of events. Change the program so that it
reads the events and their relative times from a text file, ((difficulty level 8): Use a Factory
Method design pattern to build the events
         */
        EnumFromTextFile enumFromTextFile = new EnumFromTextFile();
/*
Exercise 17: (4) Using TextFile and a Map<Character,Integer>, create a program
that counts the occurrence of all the different characters in a file. (So if there are 12
occurrences of the letter ‘a’ in the file, the Integer associated with the Character
containing ‘a’ in the Map contains ‘12’).
 */
        TextFile path = new TextFile("path");
/*
Exercise 23: (6) Create and test a utility method to print the contents of a CharBuffer
up to the point where the characters are no longer printable.
 */
       // doubleBufferDemo();
    }

    protected static int[] chooseDate(Scanner sc) {
        int[] date = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        return date;
    }

    protected static File getFile() {
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("."));
        chooser.setDialogTitle("choosertitle");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);

        File selectedFile = null;
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
            selectedFile = chooser.getSelectedFile();
            System.out.println("getSelectedFile() : " + selectedFile);
        } else {
            System.out.println("No Selection ");
        }
        return selectedFile;
    }

    protected static void doubleBufferDemo() {
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);
        DoubleBuffer ib = bb.asDoubleBuffer();
        // Store an array of int:
        ib.put(new double[]{11.123, 42.541, 47.003, 99.045, 143.123, 811.524, 1016.758});
        // Absolute location read and write:
        System.out.println(ib.get(3));
        ib.put(3, 1811);
        // Setting a new limit before rewinding the buffer.
        ib.flip();
        while (ib.hasRemaining()) {
            double d = ib.get();
            System.out.println(d);
        }
    }


    protected static   void listAllFilesFromDirToBottomFilterLastModified(File file, int day, int month, int year) {
        List<File> files = new ArrayList<>();
        LocalDateTime of = LocalDateTime.of(year, month, day, 0, 0);
        long timeLastModifiedFilter = of.toEpochSecond(ZoneOffset.UTC);

        List<File> walk = walk(file, files, timeLastModifiedFilter);



        int sum = 0;
        for (File file1 : walk) {
            System.out.println(file1);
            sum++;
        }
//        System.out.println(sum+" files are modified after: "+ new SimpleDateFormat("dd-MM-yyyy",LocalDate.of()));
    }

    public static List<File> walk(File file, List<File> files) {
        assert file != null;
        if (file.isDirectory()) {
            for (File listFile : (file.listFiles())) {
                if (listFile == null) {
                    return files;
                }
                if (listFile.isDirectory()) {
                    walk(listFile, files);
                }
                files.add(listFile);
            }
        }
        return files;
    }

    public static List<File> walk(File file, List<File> files, long time) {
        assert file != null;

        if (file.isDirectory()) {
            for (File listFile : (file.listFiles())) {
                if (listFile == null) {
                    return files;
                }
                if (listFile.isDirectory()) {
                    walk(listFile, files, time);
                }
                long lastModified = listFile.lastModified();
                if (lastModified / 1000 > time)
                    files.add(listFile);
            }
        }
        return files;
    }

}


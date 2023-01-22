package thinking.files;

import java.io.File;
import java.util.Scanner;

import static thinking.files.ProcessFiles.*;

public class SynchronizedRunner {
    public void run() {
        synchronized (this) {
            File selectedFile = getFile();
            Scanner sc = new Scanner(System.in);
            int[] date = chooseDate(sc);
            int day = date[0];
            int month = date[1];
            int year = date[2];
            long time = getTime();
            listAllFilesFromDirToBottomFilterLastModified(selectedFile, day, month, year);
            long result = getTime() - time;
            System.out.println(result);
        }
    }

    protected static long getTime() {
        return System.nanoTime();
    }

    public static void main(String[] args) {
        SearchFiles searchFiles = new SearchFiles(new SynchronizedRunner());
        SearchFiles searchFiles2 = new SearchFiles(new SynchronizedRunner());
        searchFiles.start();
        System.out.println(searchFiles.getName());
        searchFiles2.start();
        System.out.println(searchFiles2.getName());
    }
}

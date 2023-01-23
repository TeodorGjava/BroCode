package thinking.concurrency;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static thinking.files.ProcessFiles.getFile;

public class FileWalker {
    private static final Executor pool = Executors.newFixedThreadPool(5);

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            pool.execute(new Walk());
        }

    }

    static File file = getFile();

    static class Walk implements Runnable {


        public static List<File> walk(File f, List<File> files) {
            assert f != null;
            if (f.isDirectory()) {
                for (File listFile : (f.listFiles())) {
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

        @Override
        public void run() {
            System.out.println(Thread.currentThread());
            ArrayList<File> fileList = new ArrayList<>();
            walk(file, fileList);
            extracted(fileList);
        }

        private static void extracted(ArrayList<File> fileList) {
            for (File file1 : fileList) {
                System.out.println(file1.getName());
            }
        }
    }
}
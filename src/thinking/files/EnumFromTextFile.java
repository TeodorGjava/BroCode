package thinking.files;

import java.io.*;
import java.util.TreeMap;

public class EnumFromTextFile {

    public static void main(String[] args) throws IOException {
        String ENUM_TEMPLATE = "package thinking.files; " +
                "public enum Colors { ";
        java.util.Map<Integer, String> colors = new TreeMap<>();
        File file = new File("C:\\Users\\tgeor\\Documents\\GitHub\\Android Studio\\BroCode\\src\\thinking\\files\\Colors.java");
        File data = new File("C:\\Users\\tgeor\\Documents\\GitHub\\Android Studio\\BroCode\\src\\thinking\\files\\data.txt");
        boolean newFile = file.createNewFile();
        if (!newFile) {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(data));
            String[] split = bufferedReader.readLine().split(" ");
            int id = 0;
            for (String s : split) {
                colors.put(++id, s);
                ENUM_TEMPLATE = ENUM_TEMPLATE.concat(s);
            }
            ENUM_TEMPLATE = ENUM_TEMPLATE.concat(" }");
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(ENUM_TEMPLATE.getBytes());
            fos.flush();
            fos.close();
        }
    }
}

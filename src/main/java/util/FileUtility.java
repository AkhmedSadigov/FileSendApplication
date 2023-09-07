package util;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileUtility {

    public static byte[] readBytesFromStream(DataInputStream dataInputStream) throws Exception {
        int length = dataInputStream.readInt();
        byte[] bytes = new byte[length];
        dataInputStream.readFully(bytes);
        return bytes;
    }

    public static void writeBytes(String fileName, byte[] data) throws Exception {
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName)) {
            fileOutputStream.write(data);
            fileOutputStream.flush();
        }
    }

    public static byte[] readBytesFromFile(String fileName) throws Exception {
        File file = new File(fileName);

        try (FileInputStream fileInputStream = new FileInputStream(file);) {
            byte[] bytes = new byte[(int) file.length()];
            fileInputStream.read(bytes);
            return bytes;
        }
    }
}

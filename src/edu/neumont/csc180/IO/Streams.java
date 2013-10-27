package edu.neumont.csc180.IO;

import java.io.*;
import java.util.Arrays;

public class Streams {
    static final int maxBuffer = 1024 * 10; //10K Bytes
    private static final String INPUT_FILE = "input.txt";
    private static final String OUTPUT_FILE = "output.txt";

    public static void inputStreamExample() {
        try (InputStream inStream = new FileInputStream("relative.txt");
             OutputStream outStream = new FileOutputStream(OUTPUT_FILE)) {
            int readIn;
            do {
                readIn = inStream.read();
                System.out.println(readIn);
                if (readIn != -1) outStream.write(readIn);
            } while (readIn != -1);
        } catch (IOException ex) {
        }
//        Use input/output streams for binary data (bytes)
        try (InputStream inStream = new FileInputStream(INPUT_FILE);
             OutputStream outStream = new FileOutputStream(OUTPUT_FILE)) {
            int available = inStream.available();
            byte[] buffer = new byte[available]; //this could be very big. Be careful
            int bytesRead = inStream.read(buffer);
            System.out.println(bytesRead);
            System.out.println(Arrays.toString(buffer));
            outStream.write(buffer);
        } catch (IOException ex) {
        }
        try (InputStream inStream = new FileInputStream(INPUT_FILE);
             OutputStream outStream = new FileOutputStream(OUTPUT_FILE)) {
            byte[] buffer = new byte[maxBuffer];
            int bytesRead;
            do {
                bytesRead = inStream.read(buffer);
                outStream.write(buffer, 0, bytesRead);
            } while (bytesRead == maxBuffer);
        } catch (IOException ex) {
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_FILE));
             PrintWriter out = new PrintWriter("writing.txt")) {
            String record;
            while ((record = reader.readLine()) != null) {
                out.println(record);
                String[] parts = record.split(",\\s?");
                System.out.println("Name: " + parts[0]);
                System.out.println("Phone: " + parts[1]);
            }
        } catch (IOException ex) {

        }
    }

    public static void main(String[] args) {

        Contact[] contacts = new Contact[]{new Contact("Jake", 27), new Contact("Bob", 55)};
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream("data.bin"))) {
            for (Contact c : contacts) {
                c.write(out);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            System.out.println("out done");
        }
        try (DataInputStream in = new DataInputStream(new FileInputStream("data.bin"))) {
            System.out.println("reading");
            while (in.available() > 0) {
                Contact record = new Contact(in.readUTF(), in.readInt());
                System.out.println(record);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


}

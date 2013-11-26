package edu.neumont.csc180.Networking.example2;

import java.io.*;
import java.net.Socket;


public class MyClient {
    public static void main(String[] args) {
        System.out.println((char) 2654);
        try (Socket connection = new Socket("localhost", 8000);) {

            OutputStream out = connection.getOutputStream();
            PrintWriter write = new PrintWriter(out, true);
            write.println("Tom");

            InputStream in = connection.getInputStream();
            BufferedReader read = new BufferedReader(new InputStreamReader(in));

            String line;
            do {
                line = read.readLine();
                System.out.println("Server says: " + line);
                //	write.println("ok");
            } while (line != null);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

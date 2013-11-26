package edu.neumont.csc180.Networking.example2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class MyServer {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8000);) {
            server.setSoTimeout(1000 * 15);
            try (Socket client = server.accept();) {
                System.out.println("Got example2 connection!");
                System.out.println(client.getInetAddress());
                InputStream in = client.getInputStream();
                BufferedReader read = new BufferedReader(new InputStreamReader(in));
                String name = read.readLine();
                System.out.println("name: " + name);
                OutputStream out = client.getOutputStream();
                PrintWriter write = new PrintWriter(out, true);
                write.println("Hello " + name);
                write.println("The time is " + new Date());
                //read.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

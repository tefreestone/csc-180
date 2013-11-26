package edu.neumont.csc180.Networking.example1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class MyServer {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8001);) {
            server.setSoTimeout(1000 * 20); //seconds gives up
            System.out.println("Waiting for connection");

            while (true) {
                try (Socket client = server.accept();) {
                    System.out.println("Got example2 connection!");
                    BufferedReader reader =
                            new BufferedReader(new InputStreamReader(client.getInputStream()));
                    PrintWriter print = new PrintWriter(client.getOutputStream(), true);

                    String name = reader.readLine();
                    print.println("Hello " + name + ". The time is " + new Date());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

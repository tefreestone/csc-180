package edu.neumont.csc180.Networking.example1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MyClient {
    public static void main(String[] args) {
        System.out.println("Connecting to server");
        try (Socket connection = new Socket("localhost", 8001);) {
            System.out.println("Connected");
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(connection.getInputStream()));
            PrintWriter print = new PrintWriter(connection.getOutputStream(), true);

            print.println("Tom");
            System.out.println("Server says: " + reader.readLine());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

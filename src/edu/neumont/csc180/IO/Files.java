package edu.neumont.csc180.IO;

import java.io.File;
import java.io.IOException;

public class Files {
    private static final String PATH = "/projects/csc-180-docs/";

    public static void main(String[] args) {

        File stupid = new File(PATH + "../.");
        File smart = new File(PATH);
        System.out.println(smart.equals(stupid));
        try {
            System.out.println(stupid.getCanonicalPath());
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        File relative = new File(PATH + "relative.txt");
        System.out.println(relative.getName());
        System.out.println(relative.getAbsolutePath());
        if (!relative.exists()) {
            try {
                relative.createNewFile();
            } catch (IOException e) {
                System.out.println("Cannot create file??? " + PATH + "relative.txt");
                e.printStackTrace();
            }
        }

        File relativeFolder = new File(PATH + "folder");
        if (!relativeFolder.exists()) {
            relativeFolder.mkdir();
        }

        File inDir = new File(relativeFolder, "inDir");
        try {
            inDir.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        File java = new File(PATH + "/Java");
        File[] inJava = java.listFiles();
        for (File f : inJava) {
            try {
                System.out.println(f.getCanonicalPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

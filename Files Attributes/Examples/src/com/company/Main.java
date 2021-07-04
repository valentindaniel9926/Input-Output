package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Main {

    public static void main(String[] args) {

        try{
            //Create file2.txt
            /*Path fileToCreate = FileSystems.getDefault().getPath("Examples","file2.txt");
            Files.createFile(fileToCreate);*/
            //Create Dir4
          /*  Path dirToCreate = FileSystems.getDefault().getPath("Examples","Dir4");
            Files.createDirectory(dirToCreate);*/
            //Create Dir6
           /* Path dirToCreate = FileSystems.getDefault().getPath("Examples","Dir2\\Dir3\\Dir4\\Dir5\\Dir6");
            Files.createDirectories(dirToCreate);*/
           Path filePath= FileSystems.getDefault().getPath("Examples","Dir1\\file1.txt");
           long size = Files.size(filePath);
            System.out.println("Size = " + size);


            System.out.println("Last modified = " + Files.getLastModifiedTime(filePath));
            BasicFileAttributes attrs = Files.readAttributes(filePath,BasicFileAttributes.class);
            System.out.println("Size = " + attrs.size());
            System.out.println("Last modified = " + attrs.lastModifiedTime());
            System.out.println("Created= " + attrs.creationTime());
            System.out.println("Is directory = " + attrs.isDirectory());
            System.out.println("Is regular file = " + attrs.isRegularFile());







        }catch(IOException e){
            System.out.println(e.getMessage());
        }


    }
    private static  void printFile(Path path){
        try(BufferedReader fileReader = Files.newBufferedReader(path)){
        String line;
        while((line=fileReader.readLine()) != null){
            System.out.println(line);
        }
        }catch (IOException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}

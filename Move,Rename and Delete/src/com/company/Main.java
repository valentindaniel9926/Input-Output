package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class Main {

    public static void main(String[] args) {

        try{
            //Delete
            Path fileToDelete = FileSystems.getDefault().getPath("Examples","Dir1","file1copy.txt");
            Files.delete(fileToDelete);

            //Rename
            Path fileToMove = FileSystems.getDefault().getPath("Examples" , "file1.txt");
            Path destination = FileSystems.getDefault().getPath("Examples","file2.txt");
            Files.move(fileToMove,destination);

             //Move
           /* Path fileToMove = FileSystems.getDefault().getPath("Examples","file1copy.txt");
            Path destination = FileSystems.getDefault().getPath("Examples","Dir1","file1copy.txt");
            Files.move(fileToMove,destination);*/

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

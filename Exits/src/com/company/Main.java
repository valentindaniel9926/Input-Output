package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
    Path path = FileSystems.getDefault().getPath("WorkingDirectoryFile.txt");
   printFile(path);
    //Path filePath = FileSystems.getDefault().getPath("files" ,"subdirectoryFile.txt");
        Path filePath =Paths.get(".","files" ,"subdirectoryFile.txt");
    printFile(filePath);
    filePath = Paths.get("F:\\Java projects","Basic Input & Output including java.util" ,"OutThere.txt");
    printFile(filePath);
    filePath = Paths.get(".");
        System.out.println(filePath.toAbsolutePath());
    Path path2 = FileSystems.getDefault().getPath(".","files","..","files","subdirectoryFile.txt");
        System.out.println(path2.normalize().toAbsolutePath());
        printFile(path2.normalize());

        Path path3 = FileSystems.getDefault().getPath("thisfiledoesntexist.txt");
        System.out.println(path3.toAbsolutePath());

        Path path4 = Paths.get("F:\\Test", "ABCDF" , "whatever.txt");
        System.out.println(path4.toAbsolutePath());

        filePath = FileSystems.getDefault().getPath("files");
        System.out.println("Exists = " + Files.exists(filePath));
        System.out.println("Exists = " + Files.exists(path4));
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

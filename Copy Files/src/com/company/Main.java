package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class Main {

    public static void main(String[] args) {
        try{
            Path sourceFile = FileSystems.getDefault().getPath("Examples","file1.txt");
            Path copyFile = FileSystems.getDefault().getPath("Examples" , "file1copy.txt");
            Files.copy(sourceFile, copyFile,StandardCopyOption.REPLACE_EXISTING);
            sourceFile= FileSystems.getDefault().getPath("Examples","Dir1");
            copyFile=FileSystems.getDefault().getPath("Examples","Dir4");
            Files.copy(sourceFile, copyFile,StandardCopyOption.REPLACE_EXISTING);
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

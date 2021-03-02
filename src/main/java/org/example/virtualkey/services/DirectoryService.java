package org.example.virtualkey.services;

import java.io.File;

import org.example.virtualkey.entities.Directory;


public class DirectoryService {

    private static Directory fileDirectory = new Directory();
    
    public static void PrintFiles() {
    	
    	fileDirectory.fillFiles();

        for (File file : DirectoryService.getFileDirectory().getFiles())
        {
            System.out.println(file.getName());
        }
    }
    public static Directory getFileDirectory() {
        return fileDirectory;
    }

    public static void setFileDirectory(Directory fileDirectory) {
        DirectoryService.fileDirectory = fileDirectory;
    }


}

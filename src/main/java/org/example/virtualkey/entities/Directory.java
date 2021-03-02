package org.example.virtualkey.entities;

import java.util.ArrayList;
import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;


public class Directory {

   public static final String name = "src/main/directory/";

   //TODO: Possibly use a HashMap? Too complex for now.
    private ArrayList<File> files = new ArrayList<File>();
    
    Path path = FileSystems.getDefault().getPath(name).toAbsolutePath();
    
    File Dfiles = path.toFile();
    
    File[] directoryFiles = Dfiles.listFiles();
    
    public String getName() {
        return name;
    }
    
    public void print() {
    	System.out.println("Existing Files: ");
    	files.forEach(f -> System.out.println(f));
    }

    public ArrayList<File> fillFiles(){
    	files.clear();
    	for (int i = 0; i < directoryFiles.length; i++) {
    		if (directoryFiles[i].isFile()) {
    			files.add(directoryFiles[i]);
    		}
    	}
    	return files;
    }

    public ArrayList<File> getFiles(){
    	return this.files;
    }

}

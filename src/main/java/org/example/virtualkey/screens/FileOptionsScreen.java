package org.example.virtualkey.screens;


import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.example.virtualkey.entities.Directory;
import org.example.virtualkey.services.ScreenService;


public class FileOptionsScreen implements Screen {
	
	private Directory dir = new Directory();

    private ArrayList<String> options = new ArrayList<>();


    // Scanner in = new Scanner(System.in);

    public FileOptionsScreen() {
    	
    	//this.dir = dir;
    	
        options.add("1. Add a File");
        options.add("2. Delete A File");
        options.add("3. Search A File");
        options.add("4. Return to Menu");
    }

    @Override
    public void Show()
    {
        System.out.println("\nChanged menu");

        for (String s : options)  {
            System.out.println(s);
        }

    }

    public void GetUserInput()
    {
        int selectedOption;
        while ((selectedOption = this.getOption()) != 4) {
            this.NavigateOption(selectedOption);
        }
    }

    @Override
    public void NavigateOption(int option)
    {
        switch(option) {

            case 1: // Add File
                this.AddFile();
                break;
            case 2: // Delete File
                this.DeleteFile();
                break;
            case 3: // Search File
                this.SearchFile();
                break;
            default:
                System.out.println("Invalid Option");
                break;

        }

    }
    
    //TODO: Add functionality to all 

    public void AddFile() {
        System.out.println("Please Enter the Filename:");

        String fileName = this.getInputString();

        System.out.println("You are adding a file named: " + fileName);
        
		try {
			Path path = FileSystems.getDefault().getPath(Directory.name + fileName).toAbsolutePath();
			File file = path.toFile();
			
		      if (file.createNewFile()) {
		    	  System.out.println("File created: " + file.getName());
		    	  dir.getFiles().add(file);
		      } else {
		        System.out.println("This File Already Exits, no need to add another");
		      }
		}catch (IOException e){
			System.out.println(e);
		}
	}
        
    
    
    public void DeleteFile() {
    	dir.getFiles();
    	
    	System.out.println("Please Enter the Filename:");

        String fileName = this.getInputString();

        System.out.println("You are deleting a file named: " + fileName);
        
        
	     //TODO: Delete file
		Path path = FileSystems.getDefault().getPath("src/main/resources/"+fileName).toAbsolutePath();
		File file = path.toFile();
	      if (file.delete()) {
	    	  System.out.println("Deleted File: " + file.getName());
	    	  dir.getFiles().remove(file);
	      } else {
	        System.out.println("Failed to delete file:" + fileName);
	      }
    }
    
    public void SearchFile() {
    	
    	Boolean found = false;
    	
    	System.out.println("Please Enter the Filename:");

        String fileName = this.getInputString();

        System.out.println("You are searching for a file named: " + fileName);
        
        ArrayList<File> files = dir.getFiles();
        
        for(int i = 0; i <files.size(); i++) {
			if(files.get(i).getName().equals(fileName)) {
				System.out.println("Found " + fileName);
				found = true;
			}
        }
        if (found == false) {
        	System.out.println("File not found");
        }
    }
    
    private String getInputString(){

        Scanner in = new Scanner(System.in);
        return(in.nextLine());

    }
    
    private int getOption(){
        Scanner in = new Scanner(System.in);

        int returnOption = 0;
        try {
            returnOption = in.nextInt();
        }
        catch (InputMismatchException ex) {
        	System.out.println("Invalid input");
        }
        return returnOption;

    }

}

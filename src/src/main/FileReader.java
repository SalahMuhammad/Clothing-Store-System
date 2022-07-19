package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class FileReader {
    
    FileWriter writer = null;
    File file = null;
    Scanner scan = null;
    String fileContent;
    
    public void createFile(String text) {
        try {
            
            writer = new FileWriter("./data/ini.dll");
            // text in file
            writer.write(text);
            // closee writer thet will create the file
            writer.close();
            
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", 0);
            System.exit(1);
        }
    }
    
    public String getFileData(String fileName) {
        // get file from specific path
        file = new File(fileName);
        try {
            // create scanner to scan the file
            scan = new Scanner(file);
            
            fileContent = "";
            while (scan.hasNextLine()) {
                // get the file's info
                fileContent = fileContent.concat(scan.nextLine() + "\n");
            }
            
            scan.close();
            
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", 0);
            System.exit(1);
        }
        
        return fileContent;
    }
}

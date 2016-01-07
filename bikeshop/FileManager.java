/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bikeshop;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


/**
 *
 * @author daniel
 */
public class FileManager {
    private File file;
    public FileManager(String filename) throws IOException {
        this.file = new File(filename);                
    }        

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
    
    
    
    public void writeLine(String line)  {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(this.getFile(), true));
            bw.write(line + '\n');
            bw.close();            
        } catch (IOException ex) {
            System.out.println("couldn't write to disk.");
        }        
    }
    
    public void writeList(ArrayList<String> lines) {
        try (
            BufferedWriter bw = new BufferedWriter(new FileWriter(this.getFile(), true))) {
            for (String line: lines) {
                this.writeLine(line);
            }
            bw.close();
        } catch (IOException ex) {
            System.out.println("coudln't write to file");
        }
    }
    
    public ArrayList<String> read() throws FileNotFoundException {
        ArrayList<String> lines = new ArrayList();
        String line;
        BufferedReader br = new BufferedReader(new FileReader(this.getFile()));
        try {
            while((line = br.readLine()) != null) {
                lines.add(line);                
            }
        } catch (IOException ex) {
            System.out.println("couldn't read from the file");
        }
        return lines;
    }
}

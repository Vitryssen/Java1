/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labb1;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


/**
 *
 * @author André
 */
public class PublicReader {
    private List<String> lines = Collections.emptyList();  
    private void loadTextFromFile(String fileName){
       String basePath = "C:\\Users\\André\\Desktop\\labb1\\public\\";
        try
        {  
            lines = Collections.emptyList();  
            lines = Files.readAllLines(Paths.get(basePath+fileName+".log"), StandardCharsets.UTF_8); 
        } 
        catch (IOException e) 
        {
           // do something
            System.out.println(e);
        } 
    }
    public static List<String> getHistory(){
        return lines;
    }
}

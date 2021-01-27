/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labb1;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 *
 * @author André
 */
public class PublicReader {
    private List<String> lines = new ArrayList<String>();
    private String workingPath;
    public PublicReader(String fileUrl){
        try
        {  
            this.workingPath = System.getProperty("user.dir");
            File file=new File(this.workingPath+"\\logs\\public\\"+fileUrl+".log");    //creates a new file instance  
            FileReader fr=new FileReader(file);   //reads the file  
            BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream  
            String line;  
            while((line=br.readLine())!=null)  {
                String text = line.substring(line.indexOf('>')+1);
                String username = line.substring(1,line.indexOf('>'));
                this.lines.add(username);
                this.lines.add(text);
            }
        }
        catch (FileNotFoundException ex) 
        {
            System.out.println("Not found");
        } 
        catch (IOException ex) 
        {
            System.out.println(ex);
        }
    }
    public void GetHistory(){
        Iterator<String> test = this.lines.iterator();
        while(test.hasNext()){
            System.out.println(test.next());
        }
    }
}

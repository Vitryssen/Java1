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
public class LogReader {
    private List<String> lines = new ArrayList<>();
    private String workingPath;
    public LogReader(String fileUrl){
        try
        {  
            this.workingPath = System.getProperty("user.dir");
            File file=new File(this.workingPath+"\\logs\\");    //creates a new file instance
            String[] pathnames = file.list();
            fileUrl = fileUrl+".log";
            for(int i = 0; i < pathnames.length;i++){
                if(pathnames[i].indexOf('[') != -1){
                    pathnames[i] = pathnames[i].substring(0, pathnames[i].indexOf('['))+pathnames[i].substring(pathnames[i].indexOf(']')+1, pathnames[i].length());
                }
                if(fileUrl.equals(pathnames[i])){
                    file=new File(this.workingPath+"\\logs\\"+pathnames[i]);
                }
            }
            FileReader fr=new FileReader(file);   //reads the file  
            BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream  
            String line; 
            String username;
            while((line=br.readLine())!=null)  {
                String tag = "";
                String text = line.substring(line.indexOf('>')+1);
                if(line.indexOf(']') != -1){
                    username = line.substring(1,line.indexOf('['));
                    tag = line.substring(line.indexOf('['),line.indexOf(']')+1);
                }
                else{
                    username = line.substring(1, line.indexOf('>'));
                }
                this.lines.add(tag);
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
            String output = test.next();
            if(!output.isBlank()){
                if(output.contains("]")){
                    System.out.println(test.next()+output);
                }
                else{
                    System.out.println(output);
                }
            }
        }
    }
}

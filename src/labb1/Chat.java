/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labb1;

import java.util.Iterator;
import java.util.List;

/**
 *
 * @author André
 */
public class Chat {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            switch(args[0]) 
            { 
                case "-pf" -> System.out.println("one");  //Prints a list of the friends nicknames and real names ordered by nicknames
                case "-qf" -> { 
                    System.out.println("two");  //-qf nickname | prints all the information related to the given nickname or Not found
                    System.out.println(args[1]);
                }
                case "-ql" -> System.out.println("three");
                //or Not found
                //-ql nickname | display private chat log to given nickname
                case "-qpl" -> { 
                    if(!args[1].isEmpty()){
                        PublicReader publicParser = new PublicReader(args[1]);
                        publicParser.GetHistory();
                    }
                    else
                        System.out.println("Not found");
                }
                //-qpl <nickname of current user>.log prints the information of the public chat log or "Not found"
                default -> System.out.println("no match"); //print help message describing the parameters
            } 
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
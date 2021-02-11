/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labb1;

/**
 * @author André Nordlund
 * @date 2021-02-10
 * @course name Java 2
 * @Lab number 1
 */
public class Chat {

    /**
     * @param args the command line arguments
     */
    private static String currentUser = "Eurakarte";
    public static void main(String[] args) {
        try{
            if(args.length == 0){
                System.out.println("-pf: Prints a list of the friends nicknames and real names ordered by nicknames.");
                System.out.println("-qf nickname: Prints all the information related to the given nickname.");
                System.out.println("-ql nickname: Displays the private chat log related to the given nickname.");
                System.out.println("-qpl: Displays the public chat log.");  
                return;
            }
            switch(args[0]) 
            { 
                case "-pf" -> {
                    FriendsReader friends = new FriendsReader();
                    friends.GetFriends();
                }  //Prints a list of the friends nicknames and real names ordered by nicknames
                case "-qf" -> { //-qf nickname | display all info about current user or Not found
                    if(args.length >= 2){
                        FriendsReader friends = new FriendsReader();
                        friends.GetFriend(args[1]);
                    }
                    else
                        System.out.println("Missing argument for nickname");
                }
                case "-ql" -> { //-ql nickname | display private chat log or Not found
                    if(args.length >= 2){
                        LogReader publicParser = new LogReader(args[1]);
                        publicParser.GetHistory();
                    }
                    else
                        System.out.println("Missing argument for nickname");
                }
                case "-qpl" -> { 
                    LogReader publicParser = new LogReader(currentUser);
                    publicParser.GetHistory();
                }
                default -> System.out.println("Invalid argument(s)");
            } 
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
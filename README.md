Overview


Your objective is to create a console based application* that accesses chat log files**. The application serves as a prototype for a "chat application".
This lab is a prerequisite to the lab "Layout managers".

*- Console based application = application that is called from the terminal (commandline) and has no GUI of its own. An example call would be "$> java MyApp -argument1 argument2".

**- Chat log files = special text files, described below. By "access", it is meant that the application will read from the text files.
Requirements
User interaction

The console based application understands the following parameters, with the corresponding action
none: Prints a help message describing the parameters
-pf: Prints a list of the friends nicknames and real names ordered by nicknames.
-qf nickname: Prints all the information related to the given nickname. If nickname not found the text "Not found." is given.
-ql nickname: Displays the private chat log related to the given nickname. If nickname not found the text "Not found." is given.
-qpl: Displays the public chat log. If not found the text "Not found" is given.
Chat design

The chat can be held in two modes. A public mode that include all connected/logged on clients and a private mode where
only 2 people can chat.  

Log files

There are two types of log files, friends lists log and chat logs
The format of the log files are given by the sample files given below. The format of the private logs are identical to the public ones.

Collections

It is important to select the proper collection implementation for each of the different logs.

Chat logs collection

Note that a chat transcript is written in cronological order and that order needs to be preserved.
Naturally a collection that maintains that order is necessary; hence all instances of Map and Set can be ruled out.
The List interface has a few implementations that are good candidates.

Friends list collection

No order needs to be maintained in the friends list. An alphabetical listing of the friends can be useful but is not required by the collection.
The friends list collection will mostly be used to obtain connection information to this particular friend. A key/value pair container is useful.
The Map interface provides this functionality. Both HashMap and TreeMap classes are good candidates for the implementation.
Make sure you understand the difference between these classes before making your choice.

Implementation

 
Files

The logfiles are located in a directory named logs at the same level as the application .jar file or executable.
The filenames are as follows:
- The private chats are named as "nickname.log", where nickname is the name of the chat partner.
- The public chat is named as "nickname.log", where nickname is the name of the application user.
Note that the application must in some way store the nickname of the current user.
- The friends list is stored as "friends.list"

Design

Implement a Reader class for each of the different types of files. This will make it easier to extend the functionality of your readers.
In particular the lab "inheritance and interfaces" extends and abstracts this class. This makes for 2 reader classes, one implementing the friends list and one implementing the log files. A suggestion is to use an argument to the constructor to indicate which filename that should be read..

The Main class, the class containing the main(String[]args) method, should only contain code that parses the command line arguments.
No Collections code or file IO code is allowed here. The Main class should only interact with Collections classes provided by you.
This is to make sure that each of the Collections you define for the different log types are completely reusable, and does not require your Main class.
The Main class you define in this lab will be scrapped for the lab "Layout managers", the rest of the classes will be reused.

The collection classes should implement the proper interface and keep the actual collection implementation as a private member.

Sample log files

Note that the format of these files are subject to change in the following labs. Make sure you contain your parsing code and prepare for this. The "[AFK]" tag can currently be treated as part of the username, or as a separate tag. If you handle it as a separate tag, then you have to handle "collision" cases such as DonutAFK.log / Donut[AFK].log / Donut.log ...

Friends list log

<Donut[AFK]>
[FULLNAME]Donald Donutsson
[LASTIP]193.164.85.111
[IMAGE]
<Miles_Prower>
[FULLNAME]Davis Trumpetsson
[LASTIP]224.12.8.94
[IMAGE]

Note that a friend entry is starting with and described by [key]value pairs. This requires that the stored nickname cannot contain the character > and any stored key cannot contain the character ].
No entry can contain newlines.

Public chat log filename "Eurakarte.log"
<Donut[AFK]>HEY EURAKARTE
<Donut[AFK]>INSULT
<EURAKARTE>RETORT
<Donut[AFK]> COUNTER-RETORT
<EURAKARTE>QUESTIONING OF SEXUAL PREFERENCE
<Donut[AFK]>SUGGESTION TO SHUT THE FUCK UP
<Donut[AFK]>NOTATION THAT YOU CREATE A VACUUM
<EURAKARTE>RIPOSTE
<EURAKARTE>ADDON RIPOSTE
<Donut[AFK]>COUNTER-RIPOSTE
<EURAKARTE>COUNTER-COUNTER RIPOSTE
<Donut[AFK]>NONSENSICAL STATEMENT INVOLVING PLANKTON
<Miles_Prower>RESPONSE TO RANDOM STATEMENT AND THREAT TO BAN OPPOSING SIDES
<Donut[AFK]>WORDS OF PRAISE FOR FISHFOOD
<EURAKARTE>ACKNOWLEDGEMENT AND ACCEPTENCE OF TERMS

Same caveats as in the friends list log. The stored representation of a nickname can't contain a >. No entry can contain a newline.


Sample private chat log "Donut[AFK].log"
<EURAKARTE>Hey Nice one
<Donut[AFK>]Yeah lol
<Donut[AFK>]I'm sending this to bash.org =)

Same as public chat in content type and format.

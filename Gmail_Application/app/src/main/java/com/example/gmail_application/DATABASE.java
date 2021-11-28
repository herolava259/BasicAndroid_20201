package com.example.gmail_application;

import java.util.ArrayList;

class DATABASE {
    public String[] gmailArray = {"chopperman259@gmail.com", "congchuatuyet247@gmail.com", "hoangtubanh136@gmail.com"};
    public String[] messageArryay = {"How are you", "Hello", "Call me back if you can", "Thousand and one night", "The Old Man and Sea", "No Home", "Sherlock Home"};


    public class DbRecord{
        public String gmail;
        public String message;
        public String firstLetter = "A";

        public DbRecord(String _mail, String _message){
            this.gmail = _mail;
            this.message = _message;
            this.firstLetter = getFirstLetterName();

        }
        public String getFirstLetterName(){
            return this.gmail.substring(0,1);
        }



    }
    public ArrayList<DbRecord>  dbList = new ArrayList<DbRecord>();
    public DATABASE(){
        for(int i=0; i < gmailArray.length; i++){
            for(int j=0; j < messageArryay.length; j++){
                dbList.add(new DbRecord(gmailArray[i],messageArryay[j]));
            }
        }
        // Init Database
    }
}

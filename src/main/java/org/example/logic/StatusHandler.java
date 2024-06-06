package org.example.logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StatusHandler {
    ArrayList<Status> statuses;
    public StatusHandler(){
        statuses=new ArrayList<>();
    }
    public void addStatus(String name,String inReport,Checkable checkable){
        statuses.add(new Status(name,inReport,checkable));
    }
    public Status getStatusByOldValAndNewMap(Map.Entry<String,String> entry, HashMap<String,String> newMap){
        for(Status s:statuses){
            if(s.checkable.checkOldAndNew(entry, newMap))
                return s;
        }
        return null;
    }
    public Status getStatusByNewValAndOldMap(Map.Entry<String,String> entry, HashMap<String,String> oldMap){
        for(Status s:statuses){
            if(s.checkable.checkNewAndOld(entry, oldMap))
                return s;
        }
        return null;
    }
}

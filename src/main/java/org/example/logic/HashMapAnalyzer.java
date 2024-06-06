package org.example.logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HashMapAnalyzer {
    private StatusHandler statusHandler;
    public HashMapAnalyzer(StatusHandler statusHandler){
        this.statusHandler=statusHandler;
    }
    public HashMap<Status, ArrayList<String>> findDifference(HashMap<String,String> oldMap, HashMap<String,String> newMap){
        HashMap<Status,ArrayList<String>> result= new HashMap<>();
        for(Map.Entry<String,String> entry:oldMap.entrySet()){
            Status status=statusHandler.getStatusByOldValAndNewMap(entry,newMap);
            if(status==null)
                continue;
            if(!result.containsKey(status)){
                result.put(status,new ArrayList<>());
            }
            result.get(status).add(entry.getKey());
        }
        for(Map.Entry<String,String> entry:newMap.entrySet()){
            Status status=statusHandler.getStatusByNewValAndOldMap(entry,oldMap);
            if(status==null)
                continue;
            if(!result.containsKey(status)){
                result.put(status,new ArrayList<>());
            }
            result.get(status).add(entry.getKey());
        }
        return result;
    }
}

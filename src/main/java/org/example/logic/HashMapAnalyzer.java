package org.example.logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HashMapAnalyzer {
    public HashMap<String, ArrayList<String>> findDifference(HashMap<String,String> oldMap, HashMap<String,String> newMap){
        HashMap<String,ArrayList<String>> result= new HashMap<>();
        for(Map.Entry<String,String> entry:oldMap.entrySet()){
            String status=null;
            if(!newMap.containsKey(entry.getKey()))
                status="исчезли";
            else if (!newMap.get(entry.getKey()).equals(entry.getValue())) {
                status="изменились";
            }
            if(status==null)
                continue;
            if(!result.containsKey(status)){
                result.put(status,new ArrayList<>());
            }
            result.get(status).add(entry.getKey());
        }
        for(Map.Entry<String,String> entry:newMap.entrySet()){
            String status=null;
            if(!oldMap.containsKey(entry.getKey()))
                status="появились";
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

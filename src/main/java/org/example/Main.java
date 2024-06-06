package org.example;

import org.example.logic.HashMapAnalyzer;
import org.example.logic.Report;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMapAnalyzer analyzer=new HashMapAnalyzer();
        HashMap<String,String> oldMap=new HashMap<>();
        oldMap.put("/1","1");
        oldMap.put("/2","2");
        oldMap.put("/3","3");
        HashMap<String,String> newMap=new HashMap<>();
        newMap.put("/1","1");
        newMap.put("/2","8");
        newMap.put("/4","4");
        System.out.println(Report.createReport("имя","отчество",analyzer.findDifference(oldMap,newMap)));
    }
}
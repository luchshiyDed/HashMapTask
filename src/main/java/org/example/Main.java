package org.example;

import org.example.logic.Checkable;
import org.example.logic.HashMapAnalyzer;
import org.example.logic.Report;
import org.example.logic.StatusHandler;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        StatusHandler statusHandler=new StatusHandler();
        //Трудоемко но гибко можно было решить с меньшим кол-вом кода но и гибкости было бы меньше
        statusHandler.addStatus("delete", "исчезли следующие страницы:", new Checkable() {
            @Override
            public Boolean checkOldAndNew(Map.Entry<String, String> entry, HashMap<String, String> newMap) {
                return !newMap.containsKey(entry.getKey());
            }
        });
        statusHandler.addStatus("create", "Появились следующие новые страницы:", new Checkable() {

            @Override
            public Boolean checkNewAndOld(Map.Entry<String, String> entry, HashMap<String, String> oldMap) {
                return !oldMap.containsKey(entry.getKey());
            }
        });
        statusHandler.addStatus("change", "изменились следующие страницы:", new Checkable() {
            @Override
            public Boolean checkOldAndNew(Map.Entry<String, String> entry, HashMap<String, String> newMap) {
                if(newMap.containsKey(entry.getKey())){
                    return !newMap.get(entry.getKey()).equals(entry.getValue());
                }
                return false;
            }
        });
        HashMapAnalyzer analyzer=new HashMapAnalyzer(statusHandler);
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
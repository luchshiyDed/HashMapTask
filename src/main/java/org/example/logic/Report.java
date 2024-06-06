package org.example.logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Report {
    public static String createReport(String name, String fatherName, HashMap<String, ArrayList<String>> info){

        StringBuilder builder = new StringBuilder("Здравствуйте, дорогая "+name+" "+fatherName+" секретаря\n" +
                "За последние сутки во вверенных Вам сайтах произошли следующие изменения:\n");
        for (Map.Entry<String,ArrayList<String>> entry:info.entrySet()){
            builder.append(entry.getKey());
            builder.append(" следующие страницы:");
            boolean first=true;
            for (String e: entry.getValue()){
                if(first){
                    builder.append(e);
                    first=false;
                    continue;
                }
                builder.append(",");
                builder.append(e);
            }
            builder.append("\n");
        }
        builder.append("""
                С уважением,
                автоматизированная система
                мониторинга.""");
        return builder.toString();
    }
}

package org.example.logic;

import java.util.HashMap;
import java.util.Map;

public abstract class Checkable {
    public Boolean checkNewAndOld(Map.Entry<String,String> entry, HashMap<String,String> oldMap){return false;}
    public Boolean checkOldAndNew(Map.Entry<String,String> entry, HashMap<String,String> newMap){return false;}
}

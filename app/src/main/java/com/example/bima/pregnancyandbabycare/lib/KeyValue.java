package com.example.bima.pregnancyandbabycare.lib;

import java.util.ArrayList;

/**
 * Created by RAHMA on 11/8/2016.
 */

public class KeyValue {
    String key;
    Object value;

    public KeyValue(String key, Object value){
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString(){
        return  this.key + "=" + this.value.toString();
    }

    public static String makeURIFormat(ArrayList<KeyValue> keyValues){
        String uri = "";
        for(KeyValue kv : keyValues){
            uri += (kv.toString() + "&");
        }
            uri = uri.substring(0, (uri.length() -1));

            return  uri;
    }

    public String getKey(){
        return key;
    }

    public void setKey(String key){
        this.key = key;
    }

    public Object getValue(){
        return value;
    }

    public void setValue(Object value){
        this.value = value;
    }
}

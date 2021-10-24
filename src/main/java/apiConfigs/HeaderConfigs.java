package apiConfigs;

import java.util.HashMap;
import java.util.Map;

public class HeaderConfigs {

    public Map<String,String> defaultHeaders(){

        Map<String,String> defaultHeaders = new HashMap<String,String>();
        defaultHeaders.put("key","69bf0be1ac70778b539c992911406263");
        defaultHeaders.put("token","8c6fef35b520de02941e860a25b8652e981406b5eac3c8b180ac865829fd34a3");

        return defaultHeaders;

    }
    public Map<String,Object> headersWithToken(String name){

        Map<String,Object> defaultHeaders = new HashMap<String,Object>();
        defaultHeaders.put("key","69bf0be1ac70778b539c992911406263");
        defaultHeaders.put("token","8c6fef35b520de02941e860a25b8652e981406b5eac3c8b180ac865829fd34a3");
        defaultHeaders.put("name",name);

        Map<String,String> newMap =new HashMap<String,String>();
        for (Map.Entry<String, Object> entry : defaultHeaders.entrySet()) {
            if(entry.getValue() instanceof String){
                newMap.put(entry.getKey(), (String) entry.getValue());
            }
        }
        return defaultHeaders;

    }
    public Map<String,Object> headerForCard(String id){

        Map<String,Object> defaultHeaders = new HashMap<String,Object>();
        defaultHeaders.put("key","69bf0be1ac70778b539c992911406263");
        defaultHeaders.put("token","8c6fef35b520de02941e860a25b8652e981406b5eac3c8b180ac865829fd34a3");
        defaultHeaders.put("idList",id);

        Map<String,String> newMap =new HashMap<String,String>();
        for (Map.Entry<String, Object> entry : defaultHeaders.entrySet()) {
            if(entry.getValue() instanceof String){
                newMap.put(entry.getKey(), (String) entry.getValue());
            }
        }
        return defaultHeaders;

    }
}

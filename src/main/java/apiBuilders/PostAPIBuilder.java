package apiBuilders;

import java.util.HashMap;
import java.util.Map;

public class PostAPIBuilder {

    public Map<String,String> postRequestBody(String name){

        Map<String,String> body = new HashMap<String,String>();

          body.put("key","69bf0be1ac70778b539c992911406263");
          body.put("token","8c6fef35b520de02941e860a25b8652e981406b5eac3c8b180ac865829fd34a3");
          body.put("name",name);

        return body;

    }
    public Map<String,String> getRequestBody(){

        Map<String,String> body = new HashMap<String,String>();

        body.put("key","69bf0be1ac70778b539c992911406263");
        body.put("token","8c6fef35b520de02941e860a25b8652e981406b5eac3c8b180ac865829fd34a3");

        return body;

    }

}

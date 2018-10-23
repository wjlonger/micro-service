package com.coder.consumer.util;

import com.alibaba.fastjson.JSONObject;
import com.coder.consumer.enumeration.State;
/**
 * @author 吴俊龙
 * @version 1.0
 * @createdate 2018-09-22 07:45
 */
public class JsonUtils {

    public static void addMessage(int i, JSONObject json){
        if(i > 0){
            json.put("code", State.SUCCESS.getValue());
            json.put("state",State.SUCCESS);
            json.put("msg",State.SUCCESS);
        }else{
            json.put("code",State.FAIL.getValue());
            json.put("state",State.FAIL);
            json.put("msg",State.FAIL);
        }
    }

}

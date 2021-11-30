package com.cimon.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/**
 * @Author chenrenbing
 * @Date 2021 11 30 16:00
 * 模仿flink parametertool类，写一个简化的入参读取工具
 * */
public class ParameterTools {

    public static Map<String,String> fromArgs(String args[]){
        Map<String,String> param = new HashMap();
        int i = 0;
        while(i<args.length){
            String key="";
            if(args[i].startsWith("--")){
                key = args[i].substring(2);
            }else if(args[i].startsWith("-")){
                key = args[i].substring(1);
            }else{
                throw new IllegalArgumentException(
                        String.format("Error parsing arguments '%s' on '%s'. Please prefix keys with -- or -.",
                                Arrays.toString(args), args[i]));
            }
            if(key.length()==0){
                    throw new IllegalArgumentException(
                            "The input " + Arrays.toString(args) + " contains an empty argument");
            }
            i+=1;

            if (i >= args.length) {
                param.put(key, null);
            } else if (args[i].startsWith("--") || args[i].startsWith("-")) {
                param.put(key, null);
            } else {
                param.put(key, args[i]);
                i += 1;
            }

        }
        return param;
    }
}

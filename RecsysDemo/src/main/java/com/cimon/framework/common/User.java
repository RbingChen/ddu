package com.cimon.framework.common;

import lombok.Getter;
import lombok.Setter;

public class User {
    @Setter
    @Getter
    private int id;

    @Setter
    @Getter
    private FieldContext fieldContext;

    public User(int id){
        this.id = id;

        this.fieldContext = new FieldContext();
    }

    public String  toString(){
        return "userId:"+String.valueOf(this.id);
    }
}

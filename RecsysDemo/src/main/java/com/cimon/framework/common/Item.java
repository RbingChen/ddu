package com.cimon.framework.common;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class Item {
    @Setter
    @Getter
    private int id;
    @Getter
    @Setter
    private String itemType;
    @Setter
    @Getter
    private FieldContext fieldContext;

    public Item(int id,String itemType){
        this.id = id;
        this.itemType = itemType;
        this.fieldContext = new FieldContext();
    }

    public String  toString(){
        return "itemId:"+String.valueOf(this.id)+","+"itemType:"+itemType;
    }

}

package com.fyh.enums;

/**
 * Created by a on 2017/1/10.
 */
public enum RentType {
    ASC("asc",1),DESC("desc",2);
// 成员变量  
    private String name;
    private int index;
   private  RentType(String asc, int i) {
       this.name = asc;
       this.index =i;
    }
    public static String getName(int index){
        for (RentType r:RentType.values()
             ) {
            if(r.getIndex()==index){
                return r.name;
            }
        }
       return null;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}

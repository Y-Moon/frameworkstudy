package com.nettyTest.pojo;

import java.io.ObjectStreamField;
import java.io.Serializable;

public class Bean1 {
    public String s;
    public Integer d;
//    private static final ObjectStreamField[] serialPersistentFields = {
//            new ObjectStreamField("s", String.class),
//            new ObjectStreamField("d", Double.class)
//    };


    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public Integer getD() {
        return d;
    }

    public void setD(Integer d) {
        this.d = d;
    }
}

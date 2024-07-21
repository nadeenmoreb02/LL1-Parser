package com.example.comp439projectnadeenmoreb1203437;

//token class
public class Tkn {
    //    the type of the token
    private String t;

    //    the value of the token
    private String v;

    public int line;
    public String rawValue;

    public Tkn(String t, String v, int line, String rawValue) {
        this.t = t;
        this.v = v;
        this.line = line;
    this.rawValue = rawValue;
    }

    //    return type
    public String getT() {
        return t;
    }


    //    return value
    public String getV() {
        return v;
    }

}


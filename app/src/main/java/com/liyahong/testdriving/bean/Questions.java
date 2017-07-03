package com.liyahong.testdriving.bean;

/**
 * Created by liyahong0327 on 2017/6/21.
 */

public class Questions {
    private String title;
    private String a;
    private String b;
    private String c;
    private String d;
    private String answer;
    private String type;

    public String getDescription() {
        return description;
    }

    private String description;

    public Questions(String title,String a,String b, String c, String d, String answer, String type,String description) {
        this.b = b;
        this.title = title;
        this.a = a;
        this.c = c;
        this.d = d;
        this.answer = answer;
        this.type = type;
        this.description=description;
    }

    public String getTitle() {
        return title;
    }

    public String getA() {
        return a;
    }

    public String getB() {
        return b;
    }

    public String getC() {
        return c;
    }

    public String getD() {
        return d;
    }

    public String getAnswer() {
        return answer;
    }

    public String getType() {
        return type;
    }
}

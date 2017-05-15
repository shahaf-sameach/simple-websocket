package Sample;

import java.util.Random;

public class Message {
    private String msg;
    private int id;

    public Message() {
    }

    public Message(String message) {
        Random ran = new Random();
        this.msg = message;
        this.id = ran.nextInt(100);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString(){
        return "message[" + this.id + "]: " + this.msg;
    }
}

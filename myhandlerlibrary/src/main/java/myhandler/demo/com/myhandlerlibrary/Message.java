package myhandler.demo.com.myhandlerlibrary;

/**
 * Created by alex on 02/02/2018.
 */

public class Message {

    Handler target;

    static Message obtain(Handler handler){
        Message msg = new Message();
        msg.target = handler;
        return msg;
    }

    public void sendToTarget() {
        target.sendMessage(this);
    }

}

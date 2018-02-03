package myhandler.demo.com.myhandlerlibrary;

/**
 * Created by alex on 02/02/2018.
 */

public class Handler {

    final Looper mLooper;
    final MessageQueue mMessageQueue;

    public Handler(Looper looper){
        mLooper = looper;
        mMessageQueue = looper.mQueue;
    }

    public Message obtainMessage(){
        return Message.obtain(this);
    }

    public void handleMessage(Message msg){
    }

    void dispatchMessage(Message msg) {
        handleMessage(msg);
    }

    public void sendMessage(Message msg){
        if(msg.target == null) msg.target = this;
        mMessageQueue.enqueueMessage(msg);
    }

}

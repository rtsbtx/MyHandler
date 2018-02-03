package myhandler.demo.com.myhandlerlibrary;

/**
 * Created by alex on 02/02/2018.
 */

public class Looper {

    static final ThreadLocal<Looper> sThreadLocal = new ThreadLocal<>();
    final MessageQueue mQueue;

    public Looper(){
        mQueue = new MessageQueue();
    }

    public static Looper myLooper(){
        return sThreadLocal.get();
    }

    public static void prepare(){
        sThreadLocal.set(new Looper());
    }

    public static void loop(){
        final Looper me = myLooper();
        if (me == null) {
            throw new RuntimeException("Looper.prepare() wasn't called.");
        }
        MessageQueue messageQueue = me.mQueue;
        Message msg;
        for(;;){
            msg = messageQueue.next();
            if(msg == null) return;
            msg.target.dispatchMessage(msg);
        }
    }

}

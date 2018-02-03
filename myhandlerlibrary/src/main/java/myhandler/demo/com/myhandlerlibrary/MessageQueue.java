package myhandler.demo.com.myhandlerlibrary;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by alex on 02/02/2018.
 */

public class MessageQueue {

    private static final int MAX_POOL_SIZE = 50;
    final BlockingQueue<Message> blockingQueue;

    public MessageQueue(){
        blockingQueue = new ArrayBlockingQueue<>(MAX_POOL_SIZE);
    }

    Message next(){
        return blockingQueue.poll();
    }

    void enqueueMessage(Message msg) {
        blockingQueue.add(msg);
    }

}

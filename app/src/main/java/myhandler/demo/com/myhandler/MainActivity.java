package myhandler.demo.com.myhandler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import myhandler.demo.com.myhandlerlibrary.Handler;
import myhandler.demo.com.myhandlerlibrary.Looper;
import myhandler.demo.com.myhandlerlibrary.Message;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public static void main(String[] args) {

        Looper.prepare();

        final Handler handler = new Handler(Looper.myLooper()){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                System.out.println("handle id : " + Thread.currentThread().getId());
            }
        };

        for(int i=0; i<50; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("send id : " + Thread.currentThread().getId());
                    handler.obtainMessage().sendToTarget();
                }
            }).start();
        }

        Looper.loop();

    }

}

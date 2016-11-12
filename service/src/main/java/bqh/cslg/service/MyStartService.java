package bqh.cslg.service;

import android.app.Service;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by baiqihui on 2016/11/11.
 */

public class MyStartService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e("qwe","Bind Service--onBind()");
        return new MyBinder();
    }

    class MyBinder extends Binder{
        MyStartService getService(){
            return MyStartService.this;
        }
    }

    @Override
    public void onCreate() {
        Log.e("qwe","Service--onCreate()");
        super.onCreate();
        Message message = new Message();
        message.what = 1;
        message.obj = "start方式启动";
        MainActivity.myhandler.sendMessage(message);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("qwe","Start Service--onStartCommand()");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.e("qwe","Start Service--onDestroy()");
        Message message = new Message();
        message.what = 1;
        message.obj = "start方式销毁";
        MainActivity.myhandler.sendMessage(message);
        super.onDestroy();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e("qwe","Bind Service--onUnbind()");
        return super.onUnbind(intent);
    }

    void Play(){
            Log.e("qwe", "播放");
    }
    void Pause(){
        Log.e("qwe","暂停");
    }
    void Pervious(){
        Log.e("qwe","上一首");
    }
    void Next(){
        Log.e("qwe","下一首");
    }
}

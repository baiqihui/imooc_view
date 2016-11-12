package bqh.cslg.service;

import android.app.ActivityManager;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView text1,text2;

    static MyHandler myhandler;

    Intent intent1;

    Intent intent2;

    MyStartService startService;

    ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            text2.setText("bind service成功");
            startService = ((MyStartService.MyBinder)service).getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            startService=null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = (TextView) findViewById(R.id.textView1);
        text2 = (TextView) findViewById(R.id.textView2);
        myhandler = new MyHandler();
    }

    public void doClick(View v) throws InterruptedException {
        switch (v.getId()) {
            case R.id.start:
                intent1 = new Intent(MainActivity.this, MyStartService.class);
                startService(intent1);
                break;
            case R.id.stop:
                stopService(intent1);
                break;
            case R.id.play:
                if (startService==null){
                    Log.e("qwe","启动服务");
                    intent2 = new Intent(MainActivity.this,MyStartService.class);
                    bindService(intent2,connection, Service.BIND_AUTO_CREATE);
                }
                startService.Play();
                break;
            case R.id.pause:
                startService.Pause();
                break;
            case R.id.pervious:
                startService.Pervious();
                break;
            case R.id.next:
                startService.Next();
                break;
            case R.id.bind:
                intent2 = new Intent(MainActivity.this,MyStartService.class);
                bindService(intent2,connection, Service.BIND_AUTO_CREATE);
                break;
            case R.id.unbind:
                unbindService(connection);
                break;
        }
    }

    class MyHandler extends Handler{
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 1:
                    text1.setText((String)msg.obj);
                    break;
                case 2:
                    text2.setText((String)msg.obj);
                    break;
            }
        }
    }

    private boolean isWorked(String className) {
        ActivityManager myManager = (ActivityManager) MainActivity.this
                .getApplicationContext().getSystemService(
                        Context.ACTIVITY_SERVICE);
        ArrayList<ActivityManager.RunningServiceInfo> runningService = (ArrayList<ActivityManager.RunningServiceInfo>) myManager
                .getRunningServices(30);
        for (int i = 0; i < runningService.size(); i++) {
            if (runningService.get(i).service.getClassName().toString()
                    .equals(className)) {
                return true;
            }
        }
        return false;
    }
}

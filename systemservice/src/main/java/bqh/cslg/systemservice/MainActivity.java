package bqh.cslg.systemservice;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doClick(View v){
        switch (v.getId()){
            case R.id.network:
                if (isNetWorkConnected(MainActivity.this)){
                    Toast.makeText(MainActivity.this,"网络连接正常",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this,"无连接",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.wifi:
                WifiManager manager = (WifiManager) MainActivity.this.getSystemService(WIFI_SERVICE);
                if (manager.isWifiEnabled()){
                    manager.setWifiEnabled(false);
                    Toast.makeText(MainActivity.this,"wifi guanbi",Toast.LENGTH_SHORT).show();
                }else {
                    manager.setWifiEnabled(true);
                    Toast.makeText(MainActivity.this,"wifi dakai",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.voice:
                AudioManager manager1 = (AudioManager) MainActivity.this.getSystemService(AUDIO_SERVICE);
                int max = manager1.getStreamMaxVolume(AudioManager.STREAM_SYSTEM);
                int current = manager1.getStreamVolume(AudioManager.STREAM_RING);
                Toast.makeText(MainActivity.this,"最大音量：" +max+" 当前音量："+current,Toast.LENGTH_SHORT).show();
                break;
            case R.id.getPackage:
                ActivityManager manager2 = (ActivityManager) MainActivity.this.getSystemService(ACTIVITY_SERVICE);
                String pack = manager2.getRunningTasks(1).get(0).topActivity.getPackageName();
                Toast.makeText(MainActivity.this,pack,Toast.LENGTH_SHORT).show();
        }
    }

    public boolean isNetWorkConnected(Context context){
        if (context!=null){
            ConnectivityManager manager = (ConnectivityManager) context.getSystemService(CONNECTIVITY_SERVICE);
            NetworkInfo info = manager.getActiveNetworkInfo();
            if (info!=null){
                return info.isAvailable();
            }
        }
        return false;
    }
}

package bqh.cslg.broadcast;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.send1);
        button.setOnClickListener(this);

        Log.e("qwe",getTaskId()+"1");

        IntentFilter filter = new IntentFilter();
        filter.addAction("aaa.bbb.ccc");
        registerReceiver(new Receiver1(),filter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.send1:
                Intent intent = new Intent();
                intent.putExtra("msg","这时一条普通广播");
                intent.setAction("aaa.bbb.ccc");
                sendBroadcast(intent);
        }
    }
}

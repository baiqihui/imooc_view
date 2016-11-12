 package bqh.cslg.seekbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

 public class MainActivity extends AppCompatActivity {

    SeekBar seekBar;
     TextView tv;
     int current;

     Button button;
     ViewStub stub;

     boolean first=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        stub = (ViewStub) findViewById(R.id.viewstub);

        Log.e("qwe","GONE是："+View.GONE);
        Log.e("qwe","VISIABLE是:"+View.VISIBLE);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (first){
                    stub.inflate();
                    Log.e("qwe","inflate后："+stub.getVisibility());
                    first=false;
                }else {
                    switch (stub.getVisibility()){
                        case View.VISIBLE:
                            Log.e("qwe","click前："+stub.getVisibility());
                            stub.setVisibility(View.GONE);
                            Log.e("qwe","click后："+stub.getVisibility());
                            break;
                        case View.GONE:
                            Log.e("qwe","click前："+stub.getVisibility());
                            stub.setVisibility(View.VISIBLE);
                            Log.e("qwe","click后："+stub.getVisibility());
                            break;
                    }
                }

            }
        });

        seekBar = (SeekBar) findViewById(R.id.seek);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.e("qwe",progress+"");
                current = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.e("qwe","开始拖动了");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.e("qwe","结束");
                tv.setText(current+"");
            }
        });
    }
}

package bqh.cslg.progress_bar;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener{

    ProgressBar progress;
    Button add;
    Button minute;
    Button reset;
    TextView first,second;

    ProgressDialog dialog;

    Button show;

    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progress = (ProgressBar) findViewById(R.id.progress);
        add = (Button) findViewById(R.id.add);
        minute = (Button) findViewById(R.id.minute);
        reset = (Button) findViewById(R.id.reset);
        first = (TextView) findViewById(R.id.first);
        second = (TextView) findViewById(R.id.second);
        show = (Button) findViewById(R.id.dialog);

        progress.setMax(100);
        progress.setProgress(10);
        progress.setSecondaryProgress(30);
        first.setText("第一进度条：10%");
        second.setText("第二进度条：30%");

        add.setOnClickListener(this);
        minute.setOnClickListener(this);
        reset.setOnClickListener(this);
        show.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.add:
                progress.incrementProgressBy(30);
                Toast.makeText(MainActivity.this,"Max:"+progress.getMax()+" first:"+progress.getProgress(),Toast.LENGTH_SHORT).show();
                break;
            case R.id.minute:
                progress.incrementProgressBy(-60);
                Toast.makeText(MainActivity.this,"Max:"+progress.getMax()+" first:"+progress.getProgress(),Toast.LENGTH_SHORT).show();
                break;
            case R.id.reset:
                break;
            case R.id.dialog:
                dialog = new ProgressDialog(MainActivity.this);
                dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                dialog.setTitle("慕课网");
                dialog.setMessage("欢迎");
                dialog.setIcon(R.mipmap.ic_launcher);

                dialog.setMax(100);
                dialog.show();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i=1;i<101;i++){
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    dialog.incrementProgressBy(12);
                                }
                            },3000);
                        }
                    }
                }).start();
                break;
        }
    }
}

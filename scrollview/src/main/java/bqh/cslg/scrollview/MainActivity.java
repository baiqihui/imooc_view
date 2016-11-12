package bqh.cslg.scrollview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView tv;
    ScrollView scroll;
    Button up,down;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.content);
        tv.setText(getResources().getString(R.string.content));

        up = (Button) findViewById(R.id.up);
        down = (Button) findViewById(R.id.down);

        up.setOnClickListener(this);
        down.setOnClickListener(this);

        scroll = (ScrollView) findViewById(R.id.scroll);
        scroll.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_UP:
                        break;
                    case MotionEvent.ACTION_MOVE:
                        if (scroll.getScrollY()<=0){
                            Log.e("qwe","顶部");
                        }
                        if (scroll.getChildAt(0).getMeasuredHeight()==scroll.getHeight()+scroll.getScrollY()){
                            Log.e("qwe","底部");
                        }
                        break;
                    case MotionEvent.ACTION_DOWN:
                        break;
                }
                return false;
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.up:
                scroll.scrollBy(0,-30);
                break;
            case R.id.down:
                scroll.scrollBy(0,30);
                break;
        }
    }
}

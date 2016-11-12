package bqh.cslg.gridview;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends Activity {

    GridView gridView;

    int[] imgs = {R.drawable.address_book,R.drawable.calendar,R.drawable.camera,
            R.drawable.clock,R.drawable.games_control,R.drawable.messenger,
            R.drawable.ringtone,R.drawable.settings,R.drawable.speech_balloon,
            R.drawable.weather,R.drawable.world,R.drawable.world};
    String[] desc = {"联系人","日历","相机","时钟","游戏中心","短信",
            "闹铃","设置","演讲","天气","浏览器","浏览器"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = (GridView) findViewById(R.id.gridiew);
        MyAdapter adapter = new MyAdapter(this,imgs,desc);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,"我是"+desc[position],Toast.LENGTH_SHORT).show();
            }
        });
    }
}

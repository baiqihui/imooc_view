package bqh.cslg.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by baiqihui on 2016/11/8.
 */

public class MainActivity extends Activity {

    public static HashMap<String,String> dataMap = new HashMap<>();
    List<String> peopleList;

    ListView peopleLV;
    TextView poetry;

    ArrayAdapter adapter;

    PoetryFragment poetryFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        initData();

        initView();

        poetryFrag = new PoetryFragment();

        peopleLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                poetry.setText(dataMap.get(peopleList.get(position)));
            }
        });
    }

    private void initView() {
        peopleLV = (ListView) findViewById(R.id.people_list);
        poetry = (TextView) findViewById(R.id.poetry);
        adapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,peopleList);
        peopleLV.setAdapter(adapter);
    }

    private void initData() {
        dataMap.put("李白","望庐山瀑布\n日照香炉生紫烟，遥看瀑布挂前川。\n" +
                "飞流直下三千尺，疑是银河落九天。");
        dataMap.put("杜甫","春夜喜雨\n好雨知时节，当春乃发生。\n" +
                "随风潜入夜，润物细无声。\n" +
                "野径云俱黑，江船火独明。\n" +
                "晓看红湿处，花重锦官城。");
        dataMap.put("白居易","大林寺桃花\n人间四月芳菲尽，山寺桃花始盛开。\n" +
                "长恨春归无觅处，不知转入此中来。");

        peopleList = new ArrayList<>();
        for (Map.Entry entry : dataMap.entrySet()){
            String key = (String) entry.getKey();
            peopleList.add(key);
        }
    }
}

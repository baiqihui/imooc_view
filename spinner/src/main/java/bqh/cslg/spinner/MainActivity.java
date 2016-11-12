package bqh.cslg.spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Spinner spinner;
    List<String> list = new ArrayList<>();
    ArrayAdapter<String> adapter;
    SimpleAdapter simpleAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.text);
        spinner = (Spinner) findViewById(R.id.spinner);

        list.add("北京");
        list.add("上海");
        list.add("广东");
        list.add("无锡");

//        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        simpleAdapter = new SimpleAdapter(this,getData(),R.layout.item,new String[]{"img","city"},new int[]{R.id.img,R.id.city});
        simpleAdapter.setDropDownViewResource(R.layout.item);
        spinner.setAdapter(simpleAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                textView.setText(list.get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                textView.setText(list.get(0));
            }
        } );

    }
    public List<Map<String,Object>> getData(){
        List<Map<String,Object>> dataLists = new ArrayList<>();
        for (int i=0;i<list.size();i++){
            HashMap<String,Object> map = new HashMap<>();
            map.put("img",R.mipmap.ic_launcher);
            map.put("city",list.get(i));
            dataLists.add(map);
        }
        Log.e("qwe","daya："+dataLists.size());
        return dataLists;
    }
}

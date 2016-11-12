package bqh.cslg.autocompletetextview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView acText;
    List<String> data;

    MultiAutoCompleteTextView mulText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        acText = (AutoCompleteTextView) findViewById(R.id.auto);
        data = new ArrayList<>();
        data.add("aaa");
        data.add("afd");
        data.add("aaewr");
        data.add("aere");
        data.add("a2345");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,data);
        acText.setAdapter(adapter);

        mulText = (MultiAutoCompleteTextView) findViewById(R.id.mulText);
        mulText.setAdapter(adapter);
        mulText.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

    }
}

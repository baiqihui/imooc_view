package bqh.cslg.radiogroup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup group;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        group = (RadioGroup) findViewById(R.id.group);
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radioButton1:
                        Toast.makeText(MainActivity.this,"男",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioButton2:
                        Toast.makeText(MainActivity.this,"女",Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }
}

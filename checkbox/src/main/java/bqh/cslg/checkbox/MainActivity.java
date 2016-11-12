package bqh.cslg.checkbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox check;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        check = (CheckBox) findViewById(R.id.checkBox);
        check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Toast.makeText(MainActivity.this,"选择"+buttonView.getText(),Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this,"没有选择"+buttonView.getText(),Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

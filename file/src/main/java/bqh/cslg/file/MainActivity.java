package bqh.cslg.file;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText editText;
    Button write,read;
    TextView show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        write = (Button) findViewById(R.id.write);
        read = (Button) findViewById(R.id.read);
        show = (TextView) findViewById(R.id.textView);

        write.setOnClickListener(this);
        read.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.write:
                String content = editText.getText().toString();
                writeToFile(content);
                break;
            case R.id.read:
                readFromFile();
                break;
        }
    }

    private void readFromFile() {
        try {
            FileInputStream in = openFileInput("a.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder response = new StringBuilder();
            String line;
            if ((line=reader.readLine())!=null){
                response.append(line);
            }
            show.setText(response);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeToFile(String content) {
        try {
            FileOutputStream out= openFileOutput("a.txt",MODE_APPEND);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
            writer.write(content);
            writer.close();
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

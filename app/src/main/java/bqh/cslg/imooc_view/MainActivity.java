package bqh.cslg.imooc_view;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    DatePicker datePicker;
    TimePicker timePicker;

    Calendar cal;

    int year;
    int month;
    int day;
    int hour;
    int minute;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cal = Calendar.getInstance();
        year = cal.get(Calendar.YEAR);
        month = cal.get(Calendar.MONTH) + 1;
        day = cal.get(Calendar.DAY_OF_MONTH);
        hour = cal.get(Calendar.HOUR_OF_DAY);
        minute = cal.get(Calendar.MINUTE);
        setTitle(year+"-"+month+"-"+day+"-"+hour+":"+minute);

        datePicker = (DatePicker) findViewById(R.id.datePicker);
        timePicker = (TimePicker) findViewById(R.id.timePicker);

        //datePicker初始化
        datePicker.init(year, cal.get(Calendar.MONTH), day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                setTitle(year+"-"+(monthOfYear+1)+"-"+dayOfMonth);
            }
        });

        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                setTitle(hourOfDay+":"+minute);
            }
        });

//        new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
//                setTitle(year+"-"+(month+1)+"-"+dayOfMonth);
//            }
//        },year,cal.get(Calendar.MONTH), day).show();
        new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                setTitle(hourOfDay+":"+minute);
            }
        },hour,minute,true).show();
    }
}

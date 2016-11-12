package bqh.cslg.broadcast;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

/**
 * Created by baiqihui on 2016/11/10.
 */

public class Activity2 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main2);

        Log.e("qwe",getTaskId()+"1");
    }
}

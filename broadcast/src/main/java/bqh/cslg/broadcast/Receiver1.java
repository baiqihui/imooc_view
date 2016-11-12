package bqh.cslg.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by baiqihui on 2016/11/10.
 */

public class Receiver1 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        intent.setClass(context,Activity2.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}

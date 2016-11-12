package bqh.cslg.viewpager;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by baiqihui on 2016/11/9.
 */

public class Fragment4 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.view4,container,false);
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("qwe","4销毁了");
    }
}

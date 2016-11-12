package bqh.cslg.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by baiqihui on 2016/11/8.
 */

public class PoetryFragment extends Fragment {

    TextView tv;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.poetry,container,false);
        tv = (TextView) view.findViewById(R.id.poetry);
        return view;
    }

    public void changePoetry(String key){
        String poetryContent = MainActivity.dataMap.get(key);
        tv.setText(poetryContent);
    }
}

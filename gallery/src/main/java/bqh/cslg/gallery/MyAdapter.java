package bqh.cslg.gallery;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

/**
 * Created by baiqihui on 2016/11/10.
 */

public class MyAdapter extends BaseAdapter {
    int[] res;
    Context context;

    public MyAdapter(int[] res, Context context) {
        this.res = res;
        this.context = context;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public Object getItem(int position) {
        return res[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(context);
        imageView.setBackgroundResource(res[position%res.length]);
        imageView.setLayoutParams(new Gallery.LayoutParams(400,300));
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        return imageView;
    }
}

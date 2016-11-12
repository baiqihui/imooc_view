package bqh.cslg.gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by baiqihui on 2016/11/7.
 */

public class MyAdapter extends BaseAdapter {

    LayoutInflater mInflater;
    int[] imgs;
    String[] desc;

    public MyAdapter(Context context,int[] imgs,String[] desc){
        mInflater = LayoutInflater.from(context);
        this.imgs = imgs;
        this.desc = desc;
    }

    @Override
    public int getCount() {
        return imgs.length;
    }

    @Override
    public Object getItem(int position) {
        return imgs[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyViewHolder myViewHolder;
        if (convertView==null){
            myViewHolder = new MyViewHolder();
            convertView = mInflater.inflate(R.layout.item,null);
            myViewHolder.img = (ImageView) convertView.findViewById(R.id.img);
            myViewHolder.desc = (TextView) convertView.findViewById(R.id.desc);
            convertView.setTag(myViewHolder);
        }else {
            myViewHolder = (MyViewHolder) convertView.getTag();
        }
        myViewHolder.img.setImageResource(imgs[position]);
        myViewHolder.desc.setText(desc[position]);
        return convertView;
    }

    class MyViewHolder{
        ImageView img;
        TextView desc;
    }
}

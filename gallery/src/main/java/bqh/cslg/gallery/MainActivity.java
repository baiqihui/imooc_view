package bqh.cslg.gallery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener,ViewSwitcher.ViewFactory{

    Gallery gallery;
    ImageSwitcher img;
    int[] res = {R.drawable.item1,R.drawable.item2,R.drawable.item3,R.drawable.item4,
            R.drawable.item5,R.drawable.item6,R.drawable.item7,R.drawable.item8,
            R.drawable.item9,R.drawable.item10,R.drawable.item11,R.drawable.item12};
    MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gallery = (Gallery) findViewById(R.id.gallery);
        img = (ImageSwitcher) findViewById(R.id.img);
        adapter = new MyAdapter(res,this);
        gallery.setAdapter(adapter);
        gallery.setOnItemSelectedListener(this);
        img.setFactory(this);
        img.setInAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_in));
        img.setOutAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_out));
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        img.setImageResource(res[position%res.length]);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public View makeView() {
        ImageView image = new ImageView(this);
        image.setScaleType(ImageView.ScaleType.FIT_CENTER);
        return image;
    }
}

package bqh.cslg.viewflipper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {
    ViewFlipper flipper;
    int[] resId = {R.drawable.pic1,R.drawable.pic2,R.drawable.pic3,R.drawable.pic4};

    float startX;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flipper = (ViewFlipper) findViewById(R.id.flipper);
        for (int i=0;i<resId.length;i++){
            flipper.addView(getImageView(resId[i]));
        }
        //flipper.setInAnimation(this,R.anim.left_in);
        //flipper.setOutAnimation(this,R.anim.left_out);
        //flipper.setFlipInterval(3000);
        //flipper.startFlipping();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                startX = event.getX();
                break;
            case MotionEvent.ACTION_MOVE:

                break;
            case MotionEvent.ACTION_UP:
                //向右滑动
                if (event.getX()-startX>100){
                    flipper.setInAnimation(this,R.anim.left_in);
                    flipper.setOutAnimation(this,R.anim.left_out);
                    flipper.showPrevious();//显示前一页
                }
                //向左滑动
                if (startX-event.getX()>100){
                    flipper.setInAnimation(this,R.anim.right_in);
                    flipper.setOutAnimation(this,R.anim.right_out);
                    flipper.showNext();//显示后一页
                }
                break;
        }
        return super.onTouchEvent(event);
    }

    private ImageView getImageView(int resId){
        ImageView image = new ImageView(this);
        //image.setImageResource(resId);
        image.setBackgroundResource(resId);
        return  image;
    }
}

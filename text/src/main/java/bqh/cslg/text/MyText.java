package bqh.cslg.text;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by baiqihui on 2016/11/9.
 */

public class MyText extends TextView {
    public MyText(Context context) {
        super(context);
    }

    public MyText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean isFocused() {
        return true;
    }
}

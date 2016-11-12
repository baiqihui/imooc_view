package bqh.cslg.viewpager;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by baiqihui on 2016/11/9.
 */

public class MyPagerAdapter extends PagerAdapter {

    List<View> viewList;
    List<String> titleList;

    public MyPagerAdapter(List<View> viewList,List<String> titleList) {
        this.viewList = viewList;
        this.titleList = titleList;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }

    /**
     * 返回页卡数量
     * @return
     */
    @Override
    public int getCount() {
        return viewList.size();
    }

    /**
     * View是否来自对象
     * @param view
     * @param object
     * @return
     */
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    /**
     * 实例化一个页卡
     * @param container
     * @param position
     * @return
     */
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(viewList.get(position));
        return viewList.get(position);
    }

    /**
     * 销毁一个页卡
     * @param container
     * @param position
     * @param object
     */
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(viewList.get(position));
    }
}

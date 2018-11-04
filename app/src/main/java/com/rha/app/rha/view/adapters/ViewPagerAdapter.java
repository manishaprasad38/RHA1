package com.rha.app.rha.view.adapters;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rha.app.rha.R;

public class ViewPagerAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    private int [] txtHeaders;
    private int [] txtHeadersdesc1;
    private int [] txtHeadersdesc2;
    private int [] txtHeadersdesc3;
    private int [] txtHeadersdesc4;


    public ViewPagerAdapter(Context context, int[] txtHeaders,int[] txtHeadersdesc1,int[] txtHeadersdesc2,int[] txtHeadersdesc3,int[] txtHeadersdesc4) {
        this.context = context;
        this.txtHeaders = txtHeaders;
        this.txtHeadersdesc1 = txtHeadersdesc1;
        this.txtHeadersdesc2 = txtHeadersdesc2;
        this.txtHeadersdesc3 = txtHeadersdesc3;
        this.txtHeadersdesc4 = txtHeadersdesc4;
    }

    @Override
    public int getCount() {
        return txtHeaders.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.activity_intro_items, null);
        TextView txtHeader = (TextView) view.findViewById(R.id.txtDesciption);
        TextView txtHeader2 = (TextView) view.findViewById(R.id.txtDesciption1);
        TextView txtHeader3 = (TextView) view.findViewById(R.id.txtDesciption2);
        TextView txtHeader4 = (TextView) view.findViewById(R.id.txtDesciption3);
        TextView txtHeader5 = (TextView) view.findViewById(R.id.txtDesciption4);
      //  imageView.setImageResource(images[position]);
        txtHeader.setText(txtHeaders[position]);
        txtHeader2.setText(txtHeadersdesc1[position]);
        txtHeader3.setText(txtHeadersdesc2[position]);
        txtHeader4.setText(txtHeadersdesc3[position]);
        txtHeader5.setText(txtHeadersdesc4[position]);
        ViewPager vp = (ViewPager) container;
        vp.addView(view, 0);
        return view;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);

    }
}
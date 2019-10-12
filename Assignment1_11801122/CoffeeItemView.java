package org.yuri.coffeeapp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by user on 2016-08-10.
 */
public class CoffeeItemView extends LinearLayout {
    TextView textView;
    TextView textView2;
    TextView textView3;
    ImageView imageView;

    public CoffeeItemView(Context context) {
        super(context);

        init(context);
    }

    public CoffeeItemView(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    public void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.coffee_item, this, true);

        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);
        imageView = (ImageView) findViewById(R.id.imageView);
    }

    public void setName(String name) {
        textView.setText(name);
    }

    public void setMobile(String content) {
        textView2.setText(content);
    }

    public void setAge(int price) {
        textView3.setText(String.valueOf(price));
    }

    public void setImage(int resId) {
        imageView.setImageResource(resId);
    }
}

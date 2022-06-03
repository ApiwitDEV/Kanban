package com.example.kanban.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.BindingAdapter;

public class Adapter {

    @BindingAdapter({"DimentionH","DimentionW","DimentionType"})
    public static void setDimention(View view,int w,int h,int type) {

        if (type == 1) {
            view.getLayoutParams().width = (int)(w*0.5*0.92);
            view.getLayoutParams().height = (int)(w*0.46*0.5);
        }
        else {
            view.getLayoutParams().width = (int)(w*0.5*0.92);
            view.getLayoutParams().height = (int)(w*0.46*0.45);
        }

    }

    @BindingAdapter("firstItemMargin")
    public static void firstItemMargin(View view,boolean firstPosition) {

        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        if ( firstPosition ) {
            params.setMargins(0,100,0,20);
        }
        else {
            params.setMargins(0,20,0,20);
        }
        view.setLayoutParams(params);
    }
}
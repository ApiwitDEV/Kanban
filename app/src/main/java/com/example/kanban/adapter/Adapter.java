package com.example.kanban.adapter;

import android.view.View;
import androidx.databinding.BindingAdapter;

public class Adapter {
    @BindingAdapter({"DimentionH","DimentionW"})
    public static void setDimention(View view,int w,int h) {
        view.getLayoutParams().width = (int)(w*0.46);
        view.getLayoutParams().height = (int)(w*0.46*0.5);
    }
}
package com.example.kanban.viewModel;

import android.view.View;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LayoutInfo extends ViewModel {

    private MutableLiveData<Boolean> _visible =  new MutableLiveData<>(true);
    public LiveData<Boolean> visible = _visible;

    private MutableLiveData<String> _title = new MutableLiveData<>("เพิ่มแท็บ");
    public LiveData<String> title = _title;

    public int heightPx;

    public int widthPx;

    public String name = "";

    public void submitTabName(View view) {
        if (!name.equals("")) {
            _visible.setValue(false);
            _title.setValue("เพิ่มรายการ");
            Toast.makeText(view.getContext(),"เพื่มแท็บ "+name, Toast.LENGTH_SHORT).show();
        }
    }
}

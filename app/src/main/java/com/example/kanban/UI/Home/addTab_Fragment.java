package com.example.kanban.UI.Home;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.kanban.R;
import com.example.kanban.UI.MainActivity;
import com.example.kanban.databinding.FragmentAddTabBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link addTab_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class addTab_Fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public addTab_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment addTab_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static addTab_Fragment newInstance(String param1, String param2) {
        addTab_Fragment fragment = new addTab_Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentAddTabBinding binding = DataBindingUtil
                .inflate(inflater, R.layout.fragment_add_tab,container,false);
        View v = binding.getRoot();

        binding.setLayoutinfo(MainActivity.info);
        binding.setLifecycleOwner(this);
        return v;
    }

    @Override
    public void onStart() {
        super.onStart();
        Toast.makeText(getContext(), "START", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResume() {
        super.onResume();
        Toast.makeText(getContext(), "RESUME", Toast.LENGTH_SHORT).show();
    }
}
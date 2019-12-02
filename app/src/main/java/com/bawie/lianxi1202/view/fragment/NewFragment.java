package com.bawie.lianxi1202.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.bawie.lianxi1202.R;
import com.bawie.lianxi1202.base.BaseFragment;
import com.bawie.lianxi1202.view.activity.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewFragment extends BaseFragment {

    private Button button;

    @Override
    protected void initView(View inflate) {
        button = inflate.findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.tiao();
            }
        });
    }

    @Override
    protected int layouId() {
        return R.layout.fragment_newe;
    }

    @Override
    protected void initData() {

    }

}

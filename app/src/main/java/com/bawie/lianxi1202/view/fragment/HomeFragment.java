package com.bawie.lianxi1202.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawie.lianxi1202.R;
import com.bawie.lianxi1202.base.BaseFragment;
import com.bawie.lianxi1202.util.NetUtil;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment {

    private TextView tv;
    private ImageView iv;

    @Override
    protected void initView(View inflate) {
        tv = inflate.findViewById(R.id.tv);
        iv = inflate.findViewById(R.id.iv);
    }

    @Override
    protected int layouId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initData() {
        if (NetUtil.getInstance().isWang(getActivity())){

        }else {
            iv.setVisibility(View.VISIBLE);
        }
    }

}

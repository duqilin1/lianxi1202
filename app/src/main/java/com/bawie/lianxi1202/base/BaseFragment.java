package com.bawie.lianxi1202.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/*
 *@auther:杜其林
 *@Date: 2019/12/2
 *@Time:14:34
 *@Description:${DESCRIPTION}
 * */
public abstract class BaseFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(layouId(), null);
        initView(inflate);
        return inflate;
    }

    protected abstract void initView(View inflate);

    protected abstract int layouId();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    protected abstract void initData();
}

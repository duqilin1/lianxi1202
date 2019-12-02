package com.bawie.lianxi1202.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.Toast;

import com.bawie.lianxi1202.R;
import com.bawie.lianxi1202.base.BaseFragment;
import com.bawie.lianxi1202.contract.IMyContract;
import com.bawie.lianxi1202.model.bean.Bean;
import com.bawie.lianxi1202.presenter.MyPresenter;
import com.bawie.lianxi1202.view.adapter.MyAdapter;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment extends BaseFragment implements IMyContract.IView {

    private GridView gridView;

    @Override
    protected void initView(View inflate) {
        gridView = inflate.findViewById(R.id.gv);
    }

    @Override
    protected int layouId() {
        return R.layout.fragment_my;
    }

    @Override
    protected void initData() {
        MyPresenter myPresenter = new MyPresenter();
        myPresenter.getMyData(this);
    }

    @Override
    public void onMySuccess(Bean bean) {
        List<Bean.DataBean> data = bean.getData();
        MyAdapter myAdapter = new MyAdapter(data);
        gridView.setAdapter(myAdapter);
    }

    @Override
    public void onMyFailure(String throwable) {
        Toast.makeText(getActivity(),"请求失败",Toast.LENGTH_SHORT).show();
    }
}

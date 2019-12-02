package com.bawie.lianxi1202.view.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawie.lianxi1202.R;
import com.bawie.lianxi1202.model.bean.Bean;
import com.bawie.lianxi1202.util.NetUtil;

import java.util.List;

/*
 *@auther:杜其林
 *@Date: 2019/12/2
 *@Time:14:59
 *@Description:${DESCRIPTION}
 * */ public class MyAdapter extends BaseAdapter{
    private List<Bean.DataBean> data;

    public MyAdapter(List<Bean.DataBean> data) {

        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null){
            viewHolder = new ViewHolder();
            convertView = View.inflate(parent.getContext(), R.layout.item,null);
            viewHolder.name = convertView.findViewById(R.id.name);
            viewHolder.imageView = convertView.findViewById(R.id.im);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Bean.DataBean dataBean = data.get(position);
        viewHolder.name.setText(dataBean.getGoods_name());
        String goods_thumb = dataBean.getGoods_thumb();
        NetUtil.getInstance().getPath(goods_thumb,viewHolder.imageView);
        return convertView;
    }
    class ViewHolder{
        private TextView name;
        private ImageView imageView;
    }
}

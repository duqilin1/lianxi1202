package com.bawie.lianxi1202.model;

import com.bawie.lianxi1202.contract.IMyContract;
import com.bawie.lianxi1202.model.bean.Bean;
import com.bawie.lianxi1202.util.NetUtil;
import com.google.gson.Gson;

/*
 *@auther:杜其林
 *@Date: 2019/12/2
 *@Time:14:03
 *@Description:${DESCRIPTION}
 * */ public class MyModel {
     public void getMyData(final IMyContract.IModel iModel){
          NetUtil.getInstance().getJson("http://blog.zhaoliang5156.cn/api/shop/shop1.json", new NetUtil.HttpUri() {
               @Override
               public void ongetJson(String json) {
                    Gson gson = new Gson();
                    Bean bean = gson.fromJson(json, Bean.class);
                    iModel.onMySuccess(bean);
               }

               @Override
               public void onSheBai(String throwable) {
                    iModel.onMyFailure(throwable);
               }
          });
     }
}

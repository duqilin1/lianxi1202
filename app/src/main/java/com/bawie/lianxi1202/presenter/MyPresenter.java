package com.bawie.lianxi1202.presenter;

import com.bawie.lianxi1202.contract.IMyContract;
import com.bawie.lianxi1202.model.MyModel;
import com.bawie.lianxi1202.model.bean.Bean;

/*
 *@auther:杜其林
 *@Date: 2019/12/2
 *@Time:14:31
 *@Description:${DESCRIPTION}
 * */ public class MyPresenter {
     public void getMyData(final IMyContract.IView iView){
         MyModel myModel = new MyModel();
         myModel.getMyData(new IMyContract.IModel() {
             @Override
             public void onMySuccess(Bean bean) {
                 iView.onMySuccess(bean);
             }

             @Override
             public void onMyFailure(String throwable) {
                iView.onMyFailure(throwable);
             }
         });
     }
}

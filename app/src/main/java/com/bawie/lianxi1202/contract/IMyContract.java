package com.bawie.lianxi1202.contract;

import com.bawie.lianxi1202.model.bean.Bean;

/*
 *@auther:杜其林
 *@Date: 2019/12/2
 *@Time:14:08
 *@Description:${DESCRIPTION}
 * */
public interface IMyContract {
    interface IView{
        void onMySuccess(Bean bean);

        void onMyFailure(String throwable);
    }

    interface IModel{
        void onMySuccess(Bean bean);

        void onMyFailure(String throwable);
    }
}

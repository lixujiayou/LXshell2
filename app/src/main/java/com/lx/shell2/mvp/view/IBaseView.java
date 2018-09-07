package com.lx.shell2.mvp.view;

/**
 * IBaseView
 *
 * @author ZhongDaFeng
 */

public interface IBaseView {

    //显示loading
    void showLoading();

    //关闭loading
    void closeLoading();

    //显示吐司
    void showToast(String msg);

}

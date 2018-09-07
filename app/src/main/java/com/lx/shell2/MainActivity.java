package com.lx.shell2;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.lx.shell2.core.Constance;
import com.lx.shell2.mvp.presenter.impl.WorkListPresenterImpl;
import com.lx.shell2.mvp.view.IWorkListView;
import com.lx.shell2.utils.base.BaseActivity;
import com.lx.shell2.utils.tools.AlertDialogUtils;
import com.lx.shell2.utils.tools.LogUtils;
import com.lx.shell2.utils.tools.ToastUtil;
import com.lx.shell2.utils.tools.WaitingDialog;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<WorkListPresenterImpl> implements IWorkListView, WaitingDialog.onMyDismissListener {


    @BindView(R.id.bt_list)
    Button btList;
    @BindView(R.id.bt_1)
    Button bt1;
    @BindView(R.id.bt_2)
    Button bt2;
    @BindView(R.id.bt_3)
    Button bt3;
    @BindView(R.id.bt_4)
    Button bt4;

    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
    }

    @Override
    public void initViews() {
    }

    @Override
    public void initData() {
    }

    @Override
    protected WorkListPresenterImpl initPresener() {
        return new WorkListPresenterImpl(this, this);
    }


    @Override
    protected void initBundleData() {
    }


    @OnClick({R.id.bt_list,R.id.bt_1, R.id.bt_2, R.id.bt_3, R.id.bt_4})
    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()) {
            case R.id.bt_list:
                HashMap hashMap = new HashMap();
                hashMap.put(Constance.List_UID_MVP, "B3A12D94EE62E0A9E7C707043C904996");
                hashMap.put(Constance.List_PAGE_MVP, "1");
                hashMap.put(Constance.List_PAGESIZE_MVP, "10");

                WaitingDialog.createLoadingDialog(mContext, this);
                mPresener.loadWorkList(hashMap);
                break;
            case R.id.bt_1:
                AlertDialogUtils.showDialog(mContext, "提示", "这个AlertDialog怎么样", "还好", "不错", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ToastUtil.showToast(mContext,"i");
                    }
                }, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ToastUtil.showToast(mContext,"i");
                    }
                });
                break;
            case R.id.bt_2:
                AlertDialogUtils.showDialog(mContext, "提示", "这个AlertDialog怎么样", "还好", "不错", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ToastUtil.showToast(mContext,"i");
                    }
                }, null);
                break;
            case R.id.bt_3:
                AlertDialogUtils.showDialog(mContext, "提示", "这个AlertDialog怎么样", null, null, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ToastUtil.showToast(mContext,"i");
                    }
                }, null);
                break;
            case R.id.bt_4:
                AlertDialogUtils.showDialog(mContext, "提示", "这个AlertDialog怎么样", null, "不错",null,null);
                break;
        }
    }


    @Override
    public void showList(List<?> workList) {
        LogUtils.d("返回数据多少条==" + workList.size());
    }

    @Override
    public void showMoreList(List<?> moreWorkList) {
    }

    @Override
    public void showListErro(Object erroInfo) {
        LogUtils.d("请求错误=" + erroInfo);
    }

    @Override
    public void showLoading() {
        LogUtils.d("弹出加载框=");
    }

    @Override
    public void closeLoading() {
        WaitingDialog.closeDialog();
    }

    @Override
    public void showToast(String msg) {
        ToastUtil.showToast(mContext, msg);
        LogUtils.d("showToast==" + msg);
    }

    //手动取消加载时
    @Override
    public void onDismiss() {
        mPresener.cancleLoad();
    }


}

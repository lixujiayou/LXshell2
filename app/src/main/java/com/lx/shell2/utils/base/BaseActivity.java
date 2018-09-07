package com.lx.shell2.utils.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;


import com.lx.shell2.R;
import com.lx.shell2.core.http.api.MallRequest;
import com.lx.shell2.core.http.converter.RxApiManager;
import com.lx.shell2.entity.eventbean.NetWorkEvent;
import com.lx.shell2.mvp.model.callback.LifeCycleListener;
import com.lx.shell2.mvp.presenter.BasePresenter;
import com.lx.shell2.utils.ActivityStackManager;
import com.trello.rxlifecycle2.components.RxActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import timber.log.Timber;

/**
 * Created by lixu on 2016/11/29.
 */
public abstract class BaseActivity<p extends BasePresenter> extends RxActivity implements View.OnClickListener{

    public p mPresener;

    public Toolbar mToolbar;
    public boolean isSHOW;//记录本Activity是否可视区域


    public LifeCycleListener mListener;
    protected Unbinder unBinder;
    protected Context mContext;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (mListener != null) {
            mListener.onCreate(savedInstanceState);
        }
        ActivityStackManager.getManager().push(this);

        mPresener = initPresener();
        //把所有继承此类的Activity都绑定到这里了，这样View就和Present联系起来了。
        mPresener.attachView(this);

        initContentView(savedInstanceState);

        mContext = this;
        unBinder = ButterKnife.bind(this);

        isSHOW = true;
        mToolbar = findViewById(R.id.toolbar);
        if(mToolbar != null) {
            mToolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.white));
        }
        initViews();
        if(mToolbar != null) {
            mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
        initData();
    }


    /**
     * 设置生命周期回调函数
     *
     * @param listener
     */
    public void setOnLifeCycleListener(LifeCycleListener listener) {
        mListener = listener;
    }


    @Override
    public void onClick(View view) {
    }


    @Override
    protected void onStart() {
        super.onStart();
        isSHOW = true;
        if (mListener != null) {
            mListener.onStart();
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if (mListener != null) {
            mListener.onRestart();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mListener != null) {
            mListener.onResume();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        isSHOW = false;
        if (mListener != null) {
            mListener.onPause();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        isSHOW = false;
        if (mListener != null) {
            mListener.onStop();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        isSHOW = false;
        EventBus.getDefault().unregister(this);
        overridePendingTransition(R.anim.anim_none, R.anim.trans_center_2_right);
        if (mListener != null) {
            mListener.onDestroy();
        }


        //移除view绑定
        if (unBinder != null) {
            unBinder.unbind();
        }

        //删除Activity
        ActivityStackManager.getManager().remove(this);


        //解除View关联
        mPresener.detachView();
        //View消除时取消订阅关系
        RxApiManager.getInstance().cancelall();
    }

    // 初始化UI，setContentView
    protected abstract void initContentView(Bundle savedInstanceState);
    public abstract void initViews();
    public abstract void initData();
    protected abstract p initPresener();
    /**
     * 获取上一个界面传送过来的数据
     */
    protected abstract void initBundleData();

}

package com.example.ruby.fhapp.mvp.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;

import com.example.ruby.fhapp.AppActivity;
import com.example.ruby.fhapp.R;
import com.example.ruby.fhapp.app.utils.FragmentUtils;
import com.example.ruby.fhapp.di.component.DaggerMainComponent;
import com.example.ruby.fhapp.di.module.MainModule;
import com.example.ruby.fhapp.mvp.contract.MainContract;
import com.example.ruby.fhapp.mvp.presenter.MainPresenter;
import com.example.ruby.fhapp.mvp.ui.fragment.FindFragment;
import com.example.ruby.fhapp.mvp.ui.fragment.HomeFragment;
import com.example.ruby.fhapp.mvp.ui.fragment.MineFragment;
import com.example.ruby.fhapp.mvp.ui.fragment.PutFragment;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;
import com.tbruyelle.rxpermissions2.RxPermissions;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.ruby.fhapp.app.EventBusTags.ACTIVITY_FRAGMENT_REPLACE;
import static com.jess.arms.utils.Preconditions.checkNotNull;


public class MainActivity extends AppActivity<MainPresenter> implements MainContract.View {

    @BindView(R.id.main_frame)
    FrameLayout mainFrame;
    @BindView(R.id.nbottomBar)
    BottomBar bottomBar;
    private FragmentManager mFragmentManager;

    private RxPermissions mRxPermissions;

    private List<Fragment> mFragments;
    private int mReplace = 0;


    private OnTabSelectListener mOnTabSelectListener =tabId ->
  {
        switch (tabId) {
            case R.id.tab_end_home:
                mReplace = 0;
                break;
            case R.id.tab_end_put:
                mReplace = 1;
                break;
            case R.id.tab_end_find:
                mReplace = 2;
                break;
            case R.id.tab_end_mine:
                mReplace = 3;
                break;
        }
        Log.e(TAG,"tabId="+tabId);
        FragmentUtils.hideAllShowFragment(mFragments.get(mReplace));
    };


    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        this.mRxPermissions = new RxPermissions(this);
        DaggerMainComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .mainModule(new MainModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {

        return R.layout.activity_main; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        HomeFragment homeFragment;
        MineFragment mineFragment;
        PutFragment putFragment;
        FindFragment findFragment;
        if (savedInstanceState == null) {
            homeFragment = HomeFragment.newInstance();
            mineFragment = MineFragment.newInstance();
            putFragment=PutFragment.newInstance();
            findFragment=FindFragment.newInstance();
        } else {
            mReplace = savedInstanceState.getInt(ACTIVITY_FRAGMENT_REPLACE);
            FragmentManager fm = getSupportFragmentManager();
            homeFragment = (HomeFragment) FragmentUtils.findFragment(fm, HomeFragment.class);
            mineFragment = (MineFragment) FragmentUtils.findFragment(fm, MineFragment.class);
            putFragment = (PutFragment) FragmentUtils.findFragment(fm, PutFragment.class);
            findFragment = (FindFragment) FragmentUtils.findFragment(fm, FindFragment.class);
        }
        if (mFragments == null) {
            mFragments = new ArrayList<>();
            mFragments.add(homeFragment);
            mFragments.add(putFragment);
            mFragments.add(findFragment);
            mFragments.add(mineFragment);

        }
        FragmentUtils.addFragments(getSupportFragmentManager(), mFragments, R.id.main_frame, 0);
        bottomBar.setOnTabSelectListener(mOnTabSelectListener);

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(@NonNull String message) {
        checkNotNull(message);
        ArmsUtils.snackbarText(message);
    }

    @Override
    public void launchActivity(@NonNull Intent intent) {
        checkNotNull(intent);
        ArmsUtils.startActivity(intent);
    }

    @Override
    public void killMyself() {
        finish();
    }

    @Override
    public RxPermissions getRxPermissions() {
        return mRxPermissions;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //保存当前Activity显示的Fragment索引
        outState.putInt(ACTIVITY_FRAGMENT_REPLACE, mReplace);
    }

    protected void onDestroy() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        try {
            InputMethodManager.class.getDeclaredMethod("windowDismissed", IBinder.class).invoke(imm,
                    getWindow().getDecorView().getWindowToken());
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onDestroy();
        this.mRxPermissions = null;
        this.mFragments = null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}

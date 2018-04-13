package com.example.ruby.fhapp.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.example.ruby.fhapp.AppActivity;
import com.example.ruby.fhapp.R;
import com.example.ruby.fhapp.app.utils.FragmentUtils;
import com.example.ruby.fhapp.di.component.DaggerMainComponent;
import com.example.ruby.fhapp.di.module.MainModule;
import com.example.ruby.fhapp.mvp.contract.MainContract;
import com.example.ruby.fhapp.mvp.presenter.MainPresenter;
import com.example.ruby.fhapp.mvp.ui.fragment.MineFragment;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

import static com.example.ruby.fhapp.app.EventBusTags.ACTIVITY_FRAGMENT_REPLACE;
import static com.jess.arms.utils.Preconditions.checkNotNull;


public class MainActivity extends AppActivity<MainPresenter> implements MainContract.View{
    @BindView(R.id.bottomBar)
    BottomBar bottomBar;

    private List<Fragment> mFragments;
    private int mReplace=0;


//    private FragmentManager fragmentManager;
//    private MineFragment fg1, fg2, fg3, fg4;
    private OnTabSelectListener mOnTabSelectListener =tabId -> {
        switch (tabId){
            case R.id.show_end_home:
                mReplace=0;
                break;
            case R.id.show_end_put:
                mReplace=1;
                break;
            case R.id.show_end_find:
                mReplace=2;
                break;
            case R.id.show_end_mine:
                mReplace=3;
                break;
        }
        FragmentUtils.hideAllShowFragment(mFragments.get(mReplace));
    };

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
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
//        if (mTitles == null) {
//            mTitles = new ArrayList<>();
//            mTitles.add(R.string.title_home);
//            mTitles.add(R.string.title_dashboard);
//            mTitles.add(R.string.title_mecenter);
//        }
//        if (mNavIds == null) {
//            mNavIds = new ArrayList<>();
//            mNavIds.add(R.id.tab_home);
//            mNavIds.add(R.id.tab_dashboard);
//            mNavIds.add(R.id.tab_mycenter);
//        }

        MineFragment mineFragment;
//        HomeFragment homeFragment;
        if (savedInstanceState == null) {
//            homeFragment = HomeFragment.newInstance();
            mineFragment= MineFragment.newInstance();
        } else {
            mReplace = savedInstanceState.getInt(ACTIVITY_FRAGMENT_REPLACE);
            FragmentManager fm = getSupportFragmentManager();
            //homeFragment = (HomeFragment) FragmentUtils.findFragment(fm, HomeFragment.class);

            mineFragment = (MineFragment) FragmentUtils.findFragment(fm, MineFragment.class);
        }
        if (mFragments == null) {
            mFragments = new ArrayList<>();
            //mFragments.add(homeFragment);
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
}

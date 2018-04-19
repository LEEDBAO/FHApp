package com.example.ruby.fhapp.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.ruby.fhapp.AppActivity;
import com.example.ruby.fhapp.R;
import com.example.ruby.fhapp.di.component.DaggerCommonlyUsedGameSettingComponent;
import com.example.ruby.fhapp.di.module.CommonlyUsedGameSettingModule;
import com.example.ruby.fhapp.mvp.contract.CommonlyUsedGameSettingContract;
import com.example.ruby.fhapp.mvp.presenter.CommonlyUsedGameSettingPresenter;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.jess.arms.utils.Preconditions.checkNotNull;


public class CommonlyUsedGameSettingActivity extends AppActivity<CommonlyUsedGameSettingPresenter> implements CommonlyUsedGameSettingContract.View {

    @BindView(R.id.reg_image_btn)
    ImageButton regImageBtn;
    @BindView(R.id.text_view)
    TextView textView;

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerCommonlyUsedGameSettingComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .commonlyUsedGameSettingModule(new CommonlyUsedGameSettingModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_commonly_used_game_setting; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        textView.setText("常用游戏设置");
        ButterKnife.bind(this);
    }

    @OnClick(R.id.reg_image_btn)
    public void onViewClicked() {
        finish();
    }
}

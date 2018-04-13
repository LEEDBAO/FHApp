package com.example.ruby.fhapp.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.ruby.fhapp.AppActivity;
import com.example.ruby.fhapp.R;
import com.example.ruby.fhapp.di.component.DaggerLoginComponent;
import com.example.ruby.fhapp.di.module.LoginModule;
import com.example.ruby.fhapp.mvp.contract.LoginContract;
import com.example.ruby.fhapp.mvp.presenter.LoginPresenter;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.jess.arms.utils.Preconditions.checkNotNull;


public class LoginActivity extends AppActivity<LoginPresenter> implements LoginContract.View {

    @BindView(R.id.imageView)
    ImageButton imageView;
    @BindView(R.id.image_logo)
    ImageView imageLogo;
    @BindView(R.id.image_person)
    ImageView imagePerson;
    @BindView(R.id.text_username)
    EditText textUsername;
    @BindView(R.id.image_passwd)
    ImageView imagePasswd;
    @BindView(R.id.text_password)
    EditText textPassword;
    @BindView(R.id.login_btn)
    Button loginBtn;
    @BindView(R.id.forget_passwd_btn)
    Button forgetPasswdBtn;
    @BindView(R.id.register_btn)
    Button registerBtn;

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerLoginComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .loginModule(new LoginModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_login; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
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
        ButterKnife.bind(this);
    }

    @OnClick({R.id.imageView, R.id.login_btn, R.id.forget_passwd_btn, R.id.register_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imageView:
                finish();
                break;
            case R.id.login_btn:
                break;
            case R.id.forget_passwd_btn:
                break;
            case R.id.register_btn:
                break;
        }
    }
}

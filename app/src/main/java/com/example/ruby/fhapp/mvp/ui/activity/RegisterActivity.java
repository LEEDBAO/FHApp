package com.example.ruby.fhapp.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ruby.fhapp.AppActivity;
import com.example.ruby.fhapp.R;
import com.example.ruby.fhapp.di.component.DaggerRegisterComponent;
import com.example.ruby.fhapp.di.module.RegisterModule;
import com.example.ruby.fhapp.mvp.contract.RegisterContract;
import com.example.ruby.fhapp.mvp.presenter.RegisterPresenter;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.jess.arms.utils.Preconditions.checkNotNull;


public class RegisterActivity extends AppActivity<RegisterPresenter> implements RegisterContract.View {

    @BindView(R.id.reg_image_btn)
    ImageButton regImageBtn;
    @BindView(R.id.reg_image)
    ImageView regImage;
    @BindView(R.id.image_person)
    ImageView imagePerson;
    @BindView(R.id.text_username)
    EditText textUsername;
    @BindView(R.id.username_ll)
    LinearLayout usernameLl;
    @BindView(R.id.image_passwd)
    ImageView imagePasswd;
    @BindView(R.id.text_password)
    EditText textPassword;
    @BindView(R.id.passwd_ll)
    LinearLayout passwdLl;
    @BindView(R.id.image_repasswd)
    ImageView imageRepasswd;
    @BindView(R.id.text_repassword)
    EditText textRepassword;
    @BindView(R.id.repasswd_ll)
    LinearLayout repasswdLl;
    @BindView(R.id.image_name)
    ImageView imageName;
    @BindView(R.id.text_name)
    EditText textName;
    @BindView(R.id.put_name_ll)
    LinearLayout putNameLl;
    @BindView(R.id.reg_button)
    Button regBtn;
    @BindView(R.id.text_view)
    TextView textView;

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerRegisterComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .registerModule(new RegisterModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_register; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        if (!textPassword.getText().toString().equalsIgnoreCase(textRepassword.getText().toString())) {
            Toast toast = Toast.makeText(this, "密码有误", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }

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

    @OnClick({R.id.reg_button, R.id.reg_image_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.reg_button:
                break;
            case R.id.reg_image_btn:
                finish();
                break;
        }
    }


}

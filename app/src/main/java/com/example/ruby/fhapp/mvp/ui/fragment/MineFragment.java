package com.example.ruby.fhapp.mvp.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.ruby.fhapp.R;
import com.example.ruby.fhapp.di.component.DaggerMineComponent;
import com.example.ruby.fhapp.di.module.MineModule;
import com.example.ruby.fhapp.mvp.contract.MineContract;
import com.example.ruby.fhapp.mvp.presenter.MinePresenter;
import com.example.ruby.fhapp.mvp.ui.activity.LoginActivity;
import com.jess.arms.base.BaseFragment;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static com.jess.arms.utils.Preconditions.checkNotNull;


public class MineFragment extends BaseFragment<MinePresenter> implements MineContract.View {

    @BindView(R.id.mine_name)
    TextView mineName;
    @BindView(R.id.mine_logo_my)
    ImageButton mineLogoMy;
    @BindView(R.id.image_button_chat)
    ImageButton imageButtonChat;
    @BindView(R.id.money)
    ImageView money;
    @BindView(R.id.mine_balance)
    TextView mineBalance;
    @BindView(R.id.mine_money)
    TextView mineMoney;
    @BindView(R.id.mine_blance_message_RT)
    RelativeLayout mineBlanceMessageRT;
    @BindView(R.id.mine_imageView)
    ImageView mineImageView;
    @BindView(R.id.mine_text_message)
    TextView mineTextMessage;
    @BindView(R.id.mine_bankcard_RT)
    RelativeLayout mineBankcardRT;
    @BindView(R.id.mine_putrecode_RT)
    RelativeLayout minePutrecodeRT;
    @BindView(R.id.mine_recommended_RT)
    RelativeLayout mineRecommendedRT;
    @BindView(R.id.mine_account_balance_RT)
    RelativeLayout mineAccountBalanceRT;
    @BindView(R.id.mine_setting_RT)
    RelativeLayout mineSettingRT;
    @BindView(R.id.mine_help_center_RT)
    RelativeLayout mineHelpCenterRT;
    @BindView(R.id.mine_logout_RT)
    RelativeLayout mineLogoutRT;
    Unbinder unbinder;

    public static MineFragment newInstance() {
        MineFragment fragment = new MineFragment();
        return fragment;
    }

    @Override
    public void setupFragmentComponent(@NonNull AppComponent appComponent) {
        DaggerMineComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .mineModule(new MineModule(this))
                .build()
                .inject(this);
    }

    @Override
    public View initView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_mine, container, false);
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {

    }

    /**
     * 通过此方法可以使 Fragment 能够与外界做一些交互和通信, 比如说外部的 Activity 想让自己持有的某个 Fragment 对象执行一些方法,
     * 建议在有多个需要与外界交互的方法时, 统一传 {@link Message}, 通过 what 字段来区分不同的方法, 在 {@link #setData(Object)}
     * 方法中就可以 {@code switch} 做不同的操作, 这样就可以用统一的入口方法做多个不同的操作, 可以起到分发的作用
     * <p>
     * 调用此方法时请注意调用时 Fragment 的生命周期, 如果调用 {@link #setData(Object)} 方法时 {@link Fragment#onCreate(Bundle)} 还没执行
     * 但在 {@link #setData(Object)} 里却调用了 Presenter 的方法, 是会报空的, 因为 Dagger 注入是在 {@link Fragment#onCreate(Bundle)} 方法中执行的
     * 然后才创建的 Presenter, 如果要做一些初始化操作,可以不必让外部调用 {@link #setData(Object)}, 在 {@link #initData(Bundle)} 中初始化就可以了
     * <p>
     * Example usage:
     * <pre>
     * public void setData(@Nullable Object data) {
     *     if (data != null && data instanceof Message) {
     *         switch (((Message) data).what) {
     *             case 0:
     *                 loadData(((Message) data).arg1);
     *                 break;
     *             case 1:
     *                 refreshUI();
     *                 break;
     *             default:
     *                 //do something
     *                 break;
     *         }
     *     }
     * }
     *
     * // call setData(Object):
     * Message data = new Message();
     * data.what = 0;
     * data.arg1 = 1;
     * fragment.setData(data);
     * </pre>
     *
     * @param data 当不需要参数时 {@code data} 可以为 {@code null}
     */
    @Override
    public void setData(@Nullable Object data) {

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

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.mine_logo_my, R.id.image_button_chat, R.id.mine_bankcard_RT, R.id.mine_putrecode_RT, R.id.mine_recommended_RT, R.id.mine_account_balance_RT, R.id.mine_setting_RT, R.id.mine_help_center_RT, R.id.mine_logout_RT})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mine_logo_my:
                break;
            case R.id.image_button_chat:
                break;
            case R.id.mine_bankcard_RT:
                break;
            case R.id.mine_putrecode_RT:
                break;
            case R.id.mine_recommended_RT:
                break;
            case R.id.mine_account_balance_RT:
                Intent intent = new Intent(getActivity(),LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.mine_setting_RT:
                break;
            case R.id.mine_help_center_RT:
                break;
            case R.id.mine_logout_RT:
                break;
        }
    }
}

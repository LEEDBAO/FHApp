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
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.ruby.fhapp.App;
import com.example.ruby.fhapp.AppFragment;
import com.example.ruby.fhapp.R;
import com.example.ruby.fhapp.app.utils.Utils;
import com.example.ruby.fhapp.di.component.DaggerHomeComponent;
import com.example.ruby.fhapp.di.module.HomeModule;
import com.example.ruby.fhapp.mvp.contract.HomeContract;
import com.example.ruby.fhapp.mvp.model.map.BannerMapBean;
import com.example.ruby.fhapp.mvp.presenter.HomePresenter;
import com.example.ruby.fhapp.mvp.ui.activity.CommonlyUsedGameSettingActivity;
import com.example.ruby.fhapp.mvp.ui.activity.LoginActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;
import com.sunfusheng.marqueeview.MarqueeView;
import com.youth.banner.Banner;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static com.jess.arms.utils.Preconditions.checkNotNull;


public class HomeFragment extends AppFragment<HomePresenter> implements HomeContract.View {

    Unbinder unbinder;
    BannerMapBean bannerMapBean;

    @BindView(R.id.home_image_buttn_1)
    ImageButton homeImageButtn1;
    @BindView(R.id.home_image_buttn_2)
    ImageButton homeImageButtn2;
    @BindView(R.id.home_image_buttn_3)
    ImageButton homeImageButtn3;
    @BindView(R.id.home_image_buttn_4)
    ImageButton homeImageButtn4;
    @BindView(R.id.home_image_buttn_5)
    ImageButton homeImageButtn5;
    @BindView(R.id.home_image_buttn_6)
    ImageButton homeImageButtn6;
    @BindView(R.id.home_image_buttn_7)
    ImageButton homeImageButtn7;
    @BindView(R.id.home_image_buttn_8)
    ImageButton homeImageButtn8;
    @BindView(R.id.home_image_buttn_9)
    ImageButton homeImageButtn9;
    @BindView(R.id.home_image_buttn_10)
    ImageButton homeImageButtn10;
    @BindView(R.id.home_image_buttn_11)
    ImageButton homeImageButtn11;
    @BindView(R.id.home_image_buttn_12)
    ImageButton homeImageButtn12;
    @BindView(R.id.home_withdraw_btn)
    RadioButton homeWithdrawBtn;
    @BindView(R.id.home_recharge_btn)
    RadioButton homeRechargeBtn;
    @BindView(R.id.home_trial_play_btn)
    RadioButton homeTrialPlayBtn;
    @BindView(R.id.home_customer_service_btn)
    RadioButton homeCustomerServiceBtn;

    private static String TAG = "HomeFragment";

    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.marqueeView)
    MarqueeView marqueeView;
    @BindView(R.id.imageButton)
    ImageButton imageButton;
    @BindView(R.id.image_button_my)
    ImageButton imageButtonMy;








    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    public void setupFragmentComponent(@NonNull AppComponent appComponent) {
        DaggerHomeComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .homeModule(new HomeModule(this))
                .build()
                .inject(this);
    }

    @Override
    public View initView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return null;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        Map<String, String> bannerMap = new HashMap<String, String>();
        bannerMap.put("appid", App.APPID_DMINE);
        bannerMapBean = new BannerMapBean();
        bannerMapBean.setSign(Utils.md5toSignatureRules(bannerMap, App.SECRET_KEY));
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
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        View mineGameView = rootView.findViewById(R.id.mine_game);
        ImageButton mineGameImageButton = mineGameView.findViewById(R.id.imageButton);
        mineGameImageButton.setVisibility(View.VISIBLE);

        View homeHotLotteryTitleRl = rootView.findViewById(R.id.home_hot_lottery_title_rl);
        TextView homeHotLotteryText = homeHotLotteryTitleRl.findViewById(R.id.text_view_nav);
        homeHotLotteryText.setText("热门游戏");

        View otherLl = rootView.findViewById(R.id.other_ll);
        TextView otherLlText = otherLl.findViewById(R.id.text_view_nav);
        otherLlText.setText("其他推荐");

        imageButton =mineGameImageButton;
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();

    }




    @OnClick(R.id.imageButton)
    public void onViewClicked() {
    }

    @OnClick({R.id.image_button_my,R.id.home_withdraw_btn, R.id.home_recharge_btn, R.id.home_trial_play_btn, R.id.home_customer_service_btn, R.id.imageButton, R.id.home_image_buttn_1, R.id.home_image_buttn_2, R.id.home_image_buttn_3, R.id.home_image_buttn_4, R.id.home_image_buttn_5, R.id.home_image_buttn_6, R.id.home_image_buttn_7, R.id.home_image_buttn_8, R.id.home_image_buttn_9, R.id.home_image_buttn_10, R.id.home_image_buttn_11, R.id.home_image_buttn_12})
    public void onViewClicked(View view) {
            Intent intent;
        switch (view.getId()) {
            case R.id.home_withdraw_btn:
                break;
            case R.id.home_recharge_btn:
                break;
            case R.id.home_trial_play_btn:
                break;
            case R.id.home_customer_service_btn:
                break;
            case R.id.imageButton:
                intent=new Intent(getActivity(),CommonlyUsedGameSettingActivity.class);
                if(!Utils.checkAcitvty(intent,getContext()))
                {
                    startActivity(intent);
                }
                break;
            case R.id.home_image_buttn_1:
                break;
            case R.id.home_image_buttn_2:
                break;
            case R.id.home_image_buttn_3:
                break;
            case R.id.home_image_buttn_4:
                break;
            case R.id.home_image_buttn_5:
                break;
            case R.id.home_image_buttn_6:
                break;
            case R.id.home_image_buttn_7:
                break;
            case R.id.home_image_buttn_8:
                break;
            case R.id.home_image_buttn_9:
                break;
            case R.id.home_image_buttn_10:
                break;
            case R.id.home_image_buttn_11:
                break;
            case R.id.home_image_buttn_12:
                break;
            case R.id.image_button_my:
                intent=new Intent(getActivity(),LoginActivity.class);
                if(!Utils.checkAcitvty(intent,getContext()))
                {
                    startActivity(intent);
                }
                break;
        }
    }

}

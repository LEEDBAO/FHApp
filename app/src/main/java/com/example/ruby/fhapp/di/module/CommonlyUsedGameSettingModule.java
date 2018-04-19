package com.example.ruby.fhapp.di.module;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

import com.example.ruby.fhapp.mvp.contract.CommonlyUsedGameSettingContract;
import com.example.ruby.fhapp.mvp.model.CommonlyUsedGameSettingModel;


@Module
public class CommonlyUsedGameSettingModule {
    private CommonlyUsedGameSettingContract.View view;

    /**
     * 构建CommonlyUsedGameSettingModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public CommonlyUsedGameSettingModule(CommonlyUsedGameSettingContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    CommonlyUsedGameSettingContract.View provideCommonlyUsedGameSettingView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    CommonlyUsedGameSettingContract.Model provideCommonlyUsedGameSettingModel(CommonlyUsedGameSettingModel model) {
        return model;
    }
}
package com.example.ruby.fhapp.di.component;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.example.ruby.fhapp.di.module.CommonlyUsedGameSettingModule;

import com.example.ruby.fhapp.mvp.ui.activity.CommonlyUsedGameSettingActivity;

@ActivityScope
@Component(modules = CommonlyUsedGameSettingModule.class, dependencies = AppComponent.class)
public interface CommonlyUsedGameSettingComponent {
    void inject(CommonlyUsedGameSettingActivity activity);
}
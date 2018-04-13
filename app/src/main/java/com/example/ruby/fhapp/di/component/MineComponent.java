package com.example.ruby.fhapp.di.component;

import com.example.ruby.fhapp.mvp.ui.fragment.MineFragment;
import com.jess.arms.di.scope.ActivityScope;

import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.example.ruby.fhapp.di.module.MineModule;


@ActivityScope
@Component(modules = MineModule.class, dependencies = AppComponent.class)
public interface MineComponent {
    void inject(MineFragment fragment);
}
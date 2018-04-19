package com.example.ruby.fhapp.di.component;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.example.ruby.fhapp.di.module.FindModule;

import com.example.ruby.fhapp.mvp.ui.fragment.FindFragment;

@ActivityScope
@Component(modules = FindModule.class, dependencies = AppComponent.class)
public interface FindComponent {
    void inject(FindFragment fragment);
}
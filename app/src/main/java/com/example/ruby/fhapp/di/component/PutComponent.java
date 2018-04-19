package com.example.ruby.fhapp.di.component;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.example.ruby.fhapp.di.module.PutModule;

import com.example.ruby.fhapp.mvp.ui.fragment.PutFragment;

@ActivityScope
@Component(modules = PutModule.class, dependencies = AppComponent.class)
public interface PutComponent {
    void inject(PutFragment fragment);
}
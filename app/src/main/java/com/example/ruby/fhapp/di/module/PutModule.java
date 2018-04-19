package com.example.ruby.fhapp.di.module;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

import com.example.ruby.fhapp.mvp.contract.PutContract;
import com.example.ruby.fhapp.mvp.model.PutModel;


@Module
public class PutModule {
    private PutContract.View view;

    /**
     * 构建PutModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public PutModule(PutContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    PutContract.View providePutView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    PutContract.Model providePutModel(PutModel model) {
        return model;
    }
}
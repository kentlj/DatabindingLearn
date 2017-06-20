package com.learn.databinding;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableBoolean;

/**
 * Created by yui on 2017/2/20.
 */

public class Person extends BaseObservable {
    private String name;
    private String age;
    private ObservableBoolean isFemale = new ObservableBoolean();

    public void setIsFemale(boolean male) {
       isFemale.set(male);
    }

    public ObservableBoolean getIsFemale() {
        return isFemale;
    }

    public void setIsFemale(ObservableBoolean isFemale) {
        this.isFemale = isFemale;
    }

    public Person(String name, String age) {
        this.name = name;
        this.age = age;
       isFemale.set(false);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        //        notifyChange();

    }

    @Bindable
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
        notifyPropertyChanged(BR.age);

    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

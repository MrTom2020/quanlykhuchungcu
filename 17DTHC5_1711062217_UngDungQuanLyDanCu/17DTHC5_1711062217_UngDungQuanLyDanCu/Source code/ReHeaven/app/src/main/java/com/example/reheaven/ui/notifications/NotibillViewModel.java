package com.example.reheaven.ui.notifications;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.reheaven.Common.Common;
import com.example.reheaven.model.NotiModel;

public class NotibillViewModel extends ViewModel {

    private MutableLiveData <NotiModel> mutableLiveDataNoti;
    public NotibillViewModel(){
    }

    public MutableLiveData<NotiModel> getMutableLiveDataNoti(){
        if (mutableLiveDataNoti == null){
            mutableLiveDataNoti = new MutableLiveData<>();
        }
        mutableLiveDataNoti.setValue(Common.NotiClick);
        return mutableLiveDataNoti;
    }
}

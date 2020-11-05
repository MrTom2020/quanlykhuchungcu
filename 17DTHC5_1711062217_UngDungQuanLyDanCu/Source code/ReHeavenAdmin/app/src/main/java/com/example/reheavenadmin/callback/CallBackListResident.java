package com.example.reheavenadmin.callback;

import com.example.reheavenadmin.model.ResidentModel;

import java.util.List;

public interface CallBackListResident {
    //phai co 2 truong hop. Load thanh cong / khongn thanh cong
    void onResidentLoadSuccess(List<ResidentModel> residentModelList); //KHi load thanh cong: Tạo list model
    void onResidentLoadFailed(String message); //Khi load thất bại: tạo tin nhắn thông báo
}

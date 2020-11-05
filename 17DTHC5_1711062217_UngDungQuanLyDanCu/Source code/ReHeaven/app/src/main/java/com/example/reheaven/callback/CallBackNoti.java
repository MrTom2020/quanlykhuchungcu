package com.example.reheaven.callback;
import com.example.reheaven.model.NotiModel;

import java.util.List;

public interface CallBackNoti {
    //phai co 2 truong hop. Load thanh cong / khongn thanh cong
    void onNotiLoadSuccess(List<NotiModel> notiModel); //KHi load thanh cong: Tạo list model
    void onNotiLoadFailed(String message); //Khi load thất bại: tạo tin nhắn thông báo
}

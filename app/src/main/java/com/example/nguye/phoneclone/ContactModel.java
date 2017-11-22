package com.example.nguye.phoneclone;

import android.net.Uri;

/**
 * Created by nguye on 22-Nov-17.
 */

public class ContactModel {
    private String name;
    private String phone;
    private Uri avatar = null;

    public ContactModel(String name, String phone, Uri avatar) {
        this.name = name;
        this.phone = phone;
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Uri getAvatar() {
        return avatar;
    }

    public void setAvatar(Uri avatar) {
        this.avatar = avatar;
    }
}

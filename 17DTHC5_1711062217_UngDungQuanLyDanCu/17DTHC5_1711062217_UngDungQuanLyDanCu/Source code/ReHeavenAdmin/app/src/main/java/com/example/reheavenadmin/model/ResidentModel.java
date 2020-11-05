package com.example.reheavenadmin.model;

public class ResidentModel {
    String owner, phone, cmnd, email, block, apartment, idbusiness, account, password;

    public ResidentModel() {
    }

    public ResidentModel(String owner, String phone, String cmnd, String email, String block, String apartment, String idbusiness, String account, String password) {
        this.owner = owner;
        this.phone = phone;
        this.cmnd = cmnd;
        this.email = email;
        this.block = block;
        this.apartment = apartment;
        this.idbusiness = idbusiness;
        this.account = account;
        this.password = password;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public String getIdbusiness() {
        return idbusiness;
    }

    public void setIdbusiness(String idbusiness) {
        this.idbusiness = idbusiness;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

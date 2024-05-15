package com.littlesekii.tcpdata;

import java.io.Serializable;

public class TCPTransferDataExample implements Serializable {

    private String data;
    
    public String getData() {
        return this.data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
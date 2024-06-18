package com.demoqa.enums;


import lombok.Getter;

// конечные пункты указываются(само название сайта например не меняется а названия страниц добавляются в конце, например:
// "https://demoqa.com/alerts", "https://demoqa.com/text-box", "https://demoqa.com/browser-windows"),
//alerts, text-box, browser-windows это и есть endpoints
public enum EndPoints {
    ALERT("/alerts"),
    FRAMES("/frames");

    @Getter
    String endpoint;


    EndPoints(String endpoint){
        this.endpoint = endpoint;
    }
}

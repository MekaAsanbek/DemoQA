package com.demoqa.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

// Это специальный класс, его цель заключается в том, чтобы он мог считывать какие то данные c файла app.properties
public class ConfigReader {

    private static Properties properties; // инстанс вэриэбл класса Properties, чтобы в будущем мог брать данные из файла app.properties


    // мы хотим запретить возможность создания обьекта этого класса, поэтому создаем приватный конструктор
    private ConfigReader(){
         //Singleton(одиночка) pattern

    }

    static {
        // это статичный блок, все (переменные, исключения и тд, кроме методов) что будет написано внутри него будет автоматические будут статиками
        try {
            String path = "src/main/resources/app.properties"; // создали трай-кеч, внутри него в стринг положили путь к файлу
            FileInputStream fileInputStream = new FileInputStream(path); // создали объект класса FileInputStream и тем самым открыли поток,
            // и в этот объект будут попадать все данные из файла app.properties

            properties = new Properties(); // создаем также объект Пропертиса, его проинициализировали
            properties.load(fileInputStream); // дальше мы хотим положить в этот объект все данные которы находятся в файлИнпутСтрим
            fileInputStream.close(); // мы взяли все нужные данные и дальше закрываем этот поток


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

// Это специальный созданный нами метод(в параметрах принимает браузер и возвращает его значение) ищет внутри properties ключ browser, смотрит в файле app.properties и находит его значение chrome.
public static String getValue(String key){
        return properties.getProperty(key).trim();
}

//    public static void main(String[] args) {
//        System.out.println(getValue("browser"));
//        System.out.println(getValue("userName"));
//        System.out.println(getValue("password"));
//    }

}

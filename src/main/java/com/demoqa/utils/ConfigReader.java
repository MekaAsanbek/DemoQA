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
        /*
        Этот паттерн гарантирует, что у класса есть только один объект (один экземпляр класса) и к этому объекту предоставляется глобальная точка доступа. Из описания должно быть понятно, что этот паттерн должен применяться в двух случаях:
когда в вашей программе должно быть создано не более одного объекта какого-либо класса. Например, в компьютерной игре у вас есть класс «Персонаж», и у этого класса должен быть только один объект описывающий самого персонажа.

когда требуется предоставить глобальную точку доступа к объекту класса. Другими словами, нужно сделать так, чтобы объект вызывался из любого места программы. И, увы, для этого не достаточно просто создать глобальную переменную, ведь она не защищена от записи и кто угодно может изменить значение этой переменной и глобальная точка доступа к объекту будет потеряна. Это свойства Singleton'a нужно, например, когда у вас есть объект класса, который работает с базой данных, и вам нужно чтобы к базе данных был доступ из разных частей программы. А Singleton будет гарантировать, что никакой другой код не заменил созданный ранее экземпляр класса.
Вот  эти две задачи  и решает Singleton: объект в программе должен быть один и к нему есть глобальный доступ.
Особенность реализации Singleton в Java за три шага:
#1. – Нужно добавить в класс приватное статическое поле, содержащее одиночный объект: private static LazyInitializedSingleton instance; //#1
#2. – Сделать конструктор класса (конструктор по-умолчанию) приватным (чтобы доступ к нему был закрыть за пределами класса,
тогда он не сможет возвращать новые объекты): private LazyInitializedSingleton(){} // #2
}
#3. – Объявить статический создающий метод, который будет использоваться для получения одиночки:
public static LazyInitializedSingleton getInstance(){ // #3
        if(instance == null){		//если объект еще не создан
            instance = new LazyInitializedSingleton();	//создать новый объект
        }
        return instance;		// вернуть ранее созданный объект
    }
         */
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
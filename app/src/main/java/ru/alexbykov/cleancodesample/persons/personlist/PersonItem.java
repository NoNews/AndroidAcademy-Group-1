package ru.alexbykov.cleancodesample.persons.personlist;

import android.support.annotation.NonNull;

import java.io.Serializable;

public class PersonItem implements Serializable{

    private String name;
    private String secondName;
    private String imageUrl;
    private String info;

    public static PersonItem create(@NonNull String name,
                                    @NonNull String secondName,
                                    @NonNull String imageUrl,
                                    @NonNull String info){
        return new PersonItem(name, secondName, imageUrl, info);
    }

    private PersonItem(String name, String secondName, String imageUrl, String info) {
        this.name = name;
        this.secondName = secondName;
        this.imageUrl = imageUrl;
        this.info = info;
    }

    @NonNull
    public String getName() {
        return name;
    }

    @NonNull
    public String getSecondName() {
        return secondName;
    }

    @NonNull
    public String getImageUrl() {
        return imageUrl;
    }

    @NonNull
    public String getInfo() {
        return info;
    }

}

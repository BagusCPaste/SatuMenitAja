package com.example.satumenitaja;

import android.os.Parcel;
import android.os.Parcelable;

public class Surah implements Parcelable {
    private String surah;
    private String ayat;

    public Surah(String surah, String ayat) {
        this.surah = surah;
        this.ayat = ayat;
    }

    public String getSurah() {
        return surah;
    }

    public void setSurah(String surah) {
        this.surah = surah;
    }

    public String getAyat() {
        return ayat;
    }

    public void setAyat(String ayat) {
        this.ayat = ayat;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.surah);
        dest.writeString(this.ayat);
    }

    public void readFromParcel(Parcel source) {
        this.surah = source.readString();
        this.ayat = source.readString();
    }

    protected Surah(Parcel in) {
        this.surah = in.readString();
        this.ayat = in.readString();
    }

    public static final Parcelable.Creator<Surah> CREATOR = new Parcelable.Creator<Surah>() {
        @Override
        public Surah createFromParcel(Parcel source) {
            return new Surah(source);
        }

        @Override
        public Surah[] newArray(int size) {
            return new Surah[size];
        }
    };
}

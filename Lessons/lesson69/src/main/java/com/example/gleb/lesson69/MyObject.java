package com.example.gleb.lesson69;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

/**
 * Created by gleb on 16.02.2016.
 */
public class MyObject implements Parcelable {

    final static String LOG_TAG = "myLogs";

    public String s;
    public int i;

    public MyObject(String _s, int _i) {
        Log.d(LOG_TAG, "MyObject(String _s, int _i)");
        s = _s;
        i = _i;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(s);
        dest.writeInt(i);
    }

    public static final Parcelable.Creator<MyObject> CREATOR = new Parcelable.Creator<MyObject>() {
        // распаковываем объект из Parcel
        public MyObject createFromParcel(Parcel in) {
            Log.d(LOG_TAG, "createFromParcel");
            return new MyObject(in);
        }

        public MyObject[] newArray(int size) {
            return new MyObject[size];
        }
    };

    // конструктор, считывающий данные из Parcel
    private MyObject(Parcel parcel) {
        Log.d(LOG_TAG, "MyObject(Parcel parcel)");
        s = parcel.readString();
        i = parcel.readInt();
    }

}

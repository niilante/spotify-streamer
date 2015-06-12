package com.addhen.spotify.model;

import android.os.Parcel;
import android.os.Parcelable;

public class TrackModel extends Model implements Parcelable {

    public String name;

    public String album;

    public String coverPhoto;

    public String previewUrl;

    public TrackModel() {

    }

    protected TrackModel(Parcel in) {
        name = in.readString();
        album = in.readString();
        coverPhoto = in.readString();
        previewUrl = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(album);
        dest.writeString(coverPhoto);
        dest.writeString(previewUrl);
    }

    public static final Parcelable.Creator<TrackModel> CREATOR
            = new Parcelable.Creator<TrackModel>() {
        @Override
        public TrackModel createFromParcel(Parcel in) {
            return new TrackModel(in);
        }

        @Override
        public TrackModel[] newArray(int size) {
            return new TrackModel[size];
        }
    };

    @Override
    public String toString() {
        return "TrackModel{" +
                "name='" + name + '\'' +
                ", album='" + album + '\'' +
                ", coverPhoto='" + coverPhoto + '\'' +
                ", previewUrl='" + previewUrl + '\'' +
                '}';
    }
}

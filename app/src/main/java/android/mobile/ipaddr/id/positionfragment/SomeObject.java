package android.mobile.ipaddr.id.positionfragment;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by iip on 8/28/17.
 */

public class SomeObject implements Parcelable {

    String variable1;
    String variable2;
    String variable3;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.variable1);
        dest.writeString(this.variable2);
        dest.writeString(this.variable3);
    }

    public SomeObject() {
    }

    protected SomeObject(Parcel in) {
        this.variable1 = in.readString();
        this.variable2 = in.readString();
        this.variable3 = in.readString();
    }

    public static final Parcelable.Creator<SomeObject> CREATOR = new Parcelable.Creator<SomeObject>() {
        @Override
        public SomeObject createFromParcel(Parcel source) {
            return new SomeObject(source);
        }

        @Override
        public SomeObject[] newArray(int size) {
            return new SomeObject[size];
        }
    };
}

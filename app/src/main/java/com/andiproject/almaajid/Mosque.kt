package com.andiproject.almaajid

import android.os.Parcel
import android.os.Parcelable

data class Mosque(
    var name: String?,
    var detail: String?,
    var alamat: String?,
    var linkMasjid: String?,
    var jamaah: String?,
    var luasMasjid: String?,
    var tahunBerdiri: String?,
    var photo: Int?,
    var photoDetail: Int?
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(detail)
        parcel.writeString(alamat)
        parcel.writeString(linkMasjid)
        parcel.writeString(jamaah)
        parcel.writeString(luasMasjid)
        parcel.writeString(tahunBerdiri)
        parcel.writeValue(photo)
        parcel.writeValue(photoDetail)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Mosque> {
        override fun createFromParcel(parcel: Parcel): Mosque {
            return Mosque(parcel)
        }

        override fun newArray(size: Int): Array<Mosque?> {
            return arrayOfNulls(size)
        }
    }
}

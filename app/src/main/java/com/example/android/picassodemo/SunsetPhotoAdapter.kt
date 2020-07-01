package com.example.android.picassodemo

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SunsetPhotoAdapter(val url: String?) : Parcelable {

    companion object {

        fun getSunsetPhotos(): Array<SunsetPhotoAdapter> {

            return arrayOf<SunsetPhotoAdapter>(
                SunsetPhotoAdapter("https://goo.gl/32YN2B"),
                SunsetPhotoAdapter("https://goo.gl/Wqz4Ev"),
                SunsetPhotoAdapter("https://goo.gl/U7XXdF"),
                SunsetPhotoAdapter("https://goo.gl/ghVPFq"),
                SunsetPhotoAdapter("https://goo.gl/qEaCWe"),
                SunsetPhotoAdapter("https://goo.gl/vutGmM")
            )
        }
    }

}
package com.eupgroup.reciclerviewtest.models

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity(tableName = "contact")
class Contact(
    @PrimaryKey(autoGenerate = true)
    var uid: Int?,

    @ColumnInfo
    var name:String,

    @ColumnInfo
    var phone: String
): Serializable
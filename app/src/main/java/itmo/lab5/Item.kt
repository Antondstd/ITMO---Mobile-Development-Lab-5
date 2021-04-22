package itmo.lab5

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Item(val title:String, val description:String, val important:Boolean)
: Parcelable
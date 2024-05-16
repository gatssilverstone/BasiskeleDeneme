package com.silverstone.basiskeledeneme

import android.content.Context
@Suppress("DEPRECATION")
class SetList(private val context:Context, private val language:String) {
    val places:List<Places> = loadWithLanguages()
    fun loadWithLanguages():List<Places>{


        return listOf(
            Places(
                name = when(language){
                    "en" -> context.resources.getString(R.string.yuvacik_en)
                    "ar" -> context.resources.getString(R.string.yuvacik_ar)
                    else -> context.resources.getString(R.string.yuvacik_tr)
                },
                description = when(language){
                    "en" -> context.resources.getString(R.string.baraj_description_en)
                    "ar" -> context.resources.getString(R.string.baraj_description_ar)
                    else -> context.resources.getString(R.string.baraj_description_tr)
                },
                latitude = "40.673832292828585",
                longitude = "29.96939911597691",
                address = "Kiraz Çayı, Başiskele\\Kocaeli",
                image = R.drawable.baraj,
                phoneNumber = "none"

            ),
            Places(
                name = when(language){
                    "en" -> context.resources.getString(R.string.beskayalar_en)
                    "ar" -> context.resources.getString(R.string.beskayalar_ar)
                    else -> context.resources.getString(R.string.beskayalar_tr)
                },
                description = when(language){
                    "en" -> context.resources.getString(R.string.beskayalar_description_en)
                    "ar" -> context.resources.getString(R.string.beskayalar_description_ar)
                    else -> context.resources.getString(R.string.beskayalar_description_tr)
                },

                latitude = "40.59832032097058",
                longitude = "29.929084076448596",
                address = "Beşkayalar Tabiat Parkı, Servetiye Cami, 41090 Başiskele\\Kocaeli",
                image = R.drawable.beskayalar,
                phoneNumber = "none"

            ),
            Places(
                name = when(language){
                    "en" -> context.resources.getString(R.string.dongel_en)
                    "ar" -> context.resources.getString(R.string.dongel_ar)
                    else -> context.resources.getString(R.string.dongel_tr)
                },
                description = when(language){
                    "en" -> context.resources.getString(R.string.dongel_description_en)
                    "ar" -> context.resources.getString(R.string.dongel_description_ar)
                    else -> context.resources.getString(R.string.dongel_description_tr)
                },
                latitude = "40.70100876610657",
                longitude = "29.937991538675558",
                address = "Serdar Mahallesi Yürüyüş Caddesi sonu.",
                image = R.drawable.dongel,
                phoneNumber = "0262 310 12 00"

            ),
            Places(
                name = when(language){
                    "en" -> context.resources.getString(R.string.sahil_en)
                    "ar" -> context.resources.getString(R.string.sahil_ar)
                    else -> context.resources.getString(R.string.sahil_tr)
                },
                description = when(language){
                    "en" -> context.resources.getString(R.string.sahil_description_en)
                    "ar" -> context.resources.getString(R.string.sahil_description_ar)
                    else -> context.resources.getString(R.string.sahil_description_tr)
                },
                latitude = "40.71689093731321",
                longitude = "29.921239839851395",
                address = "Başiskele Sahil",
                image = R.drawable.sahil,
                phoneNumber = "none"

            ),
            Places(
                name = when(language){
                    "en" -> context.resources.getString(R.string.selale_en)
                    "ar" -> context.resources.getString(R.string.selale_ar)
                    else -> context.resources.getString(R.string.selale_tr)
                },
                description = when(language){
                    "en" -> context.resources.getString(R.string.selale_description_en)
                    "ar" -> context.resources.getString(R.string.selale_description_ar)
                    else -> context.resources.getString(R.string.selale_description_tr)
                },
                latitude = "40.673832292828585",
                longitude = "29.96939911597691",
                address = "Yuvacık Barajı Kirazlı Dere Mevkii Yuvacık\\Başiskele\\Kocaeli",
                image = R.drawable.selale,
                phoneNumber = "0262 345 00 04"

            ),
            Places(
                name = when(language){
                    "en" -> context.resources.getString(R.string.servetiye_en)
                    "ar" -> context.resources.getString(R.string.servetiye_ar)
                    else -> context.resources.getString(R.string.servetiye_tr)
                },
                description = when(language){
                    "en" -> context.resources.getString(R.string.servetiye_description_en)
                    "ar" -> context.resources.getString(R.string.servetiye_description_ar)
                    else -> context.resources.getString(R.string.servetiye_description_tr)
                },

                latitude = "40.627999304798095",
                longitude = "29.937980503048465",
                address = "Servetiye Alartı Üst Mahallesi, Başiskele\\Kocaeli",
                image = R.drawable.servetiye,
                phoneNumber = "none"

            ),

        )
    }

}
package com.loc.newsapp.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.loc.newsapp.domain.models.Source

@ProvidedTypeConverter
class TypeConverter {

    @TypeConverter
    fun sourceToString(source: Source):String{
        return source.id+","+source.name
    }
    @TypeConverter
    fun stringToSource(source:String):Source{
        return source.split(",").let {
            Source(
                id = it[0],
                name = it[1]
            )
        }
    }
}
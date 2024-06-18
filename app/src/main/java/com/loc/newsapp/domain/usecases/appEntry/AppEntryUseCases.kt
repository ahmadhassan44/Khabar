package com.loc.newsapp.domain.usecases.appEntry

import com.loc.newsapp.domain.usecases.appEntry.ReadAppEntry
import com.loc.newsapp.domain.usecases.appEntry.SaveAppEntry

data class AppEntryUseCases(
    val readAppEntry: ReadAppEntry,
    val saveAppEntry: SaveAppEntry
)

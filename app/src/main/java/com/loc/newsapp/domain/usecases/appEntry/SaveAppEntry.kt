package com.loc.newsapp.domain.usecases.appEntry

import com.loc.newsapp.domain.managers.LocalUserManager

class SaveAppEntry(
    private val localUserManger:LocalUserManager
) {
    suspend operator fun invoke() {
        localUserManger.saveAppEntry()
    }
}
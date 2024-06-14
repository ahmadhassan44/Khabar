package com.loc.newsapp.domain.usecases

import com.loc.newsapp.domain.managers.LocalUserManager

class SaveAppEntry(
    private val localUserManger:LocalUserManager
) {
    suspend operator fun invoke() {
        localUserManger.saveAppEntry()
    }
}
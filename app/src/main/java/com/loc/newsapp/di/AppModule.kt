package com.loc.newsapp.di

import android.app.Application
import com.loc.newsapp.BuildConfig
import com.loc.newsapp.data.manager.LocalUserManagerImpl
import com.loc.newsapp.data.remote.dto_responsetypes.NewsAPI
import com.loc.newsapp.data.repository.NewsRepositoryImpl
import com.loc.newsapp.domain.managers.LocalUserManager
import com.loc.newsapp.domain.repository.NewsRepository
import com.loc.newsapp.domain.usecases.appEntry.AppEntryUseCases
import com.loc.newsapp.domain.usecases.appEntry.ReadAppEntry
import com.loc.newsapp.domain.usecases.appEntry.SaveAppEntry
import com.loc.newsapp.domain.usecases.news.GetNews
import com.loc.newsapp.domain.usecases.news.NewsUseCases
import com.loc.newsapp.domain.usecases.news.SearchNews
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager(
        application:Application
    ):LocalUserManager{
        return LocalUserManagerImpl(application)
    }

    @Provides
    @Singleton
    fun provideAppEntryUsecases(
        localUserManager: LocalUserManager
    ): AppEntryUseCases {
        return AppEntryUseCases(
            readAppEntry = ReadAppEntry(localUserManager),
            saveAppEntry = SaveAppEntry(localUserManager)
        )
    }

    @Provides
    @Singleton
    fun provideNewsApi():NewsAPI{
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsAPI::class.java)
    }
    @Provides
    @Singleton
    fun provideNewsRepository(
        newsAPI: NewsAPI
    ): NewsRepository {
        return NewsRepositoryImpl(newsAPI)
    }
    @Provides
    @Singleton
    fun provideNewsUseCases(
        newsRepository : NewsRepository
    ):NewsUseCases {
        return NewsUseCases(
            getNews = GetNews(newsRepository),
            searchNews = SearchNews(newsRepository)
        )
    }


}
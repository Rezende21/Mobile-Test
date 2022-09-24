package com.example.mobiletest.di

import android.content.Context
import androidx.room.Room
import com.example.mobiletest.data.local.MovieDatabase
import com.example.mobiletest.data.local.MovieDao
import com.example.mobiletest.data.remote.ServiceApi
import com.example.mobiletest.repository.MovieRepository
import com.example.mobiletest.repository.MovieRepositoryImp
import com.example.mobiletest.utis.Constants.BASE_URL
import com.example.mobiletest.utis.Constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MainModule {

    @Provides
    @Singleton
    fun provideMovieApi() : ServiceApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(ServiceApi::class.java)
    }

    @Provides
    @Singleton
    fun provideDatabaseInstance(@ApplicationContext context: Context) : MovieDatabase =
        Room.databaseBuilder(
            context.applicationContext,
            MovieDatabase::class.java,
            DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun provideMovieDao(database: MovieDatabase) : MovieDao = database.getDataBaseInstace()

    @Provides
    @Singleton
    fun provideMovieRepository(api: ServiceApi, dao: MovieDao) : MovieRepository {
        return MovieRepositoryImp(api, dao)
    }
}
package ie.otormaigh.blank.di

import androidx.viewbinding.BuildConfig
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import ie.otormaigh.blank.api.ApiService
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.Protocol
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
object ApiModule {
  @Provides
  @JvmStatic
  fun provideRetrofit(httpUrl: HttpUrl, moshi: Moshi, okHttpClient: OkHttpClient): Retrofit =
    Retrofit.Builder()
      .baseUrl(httpUrl)
      .client(okHttpClient)
      .addConverterFactory(MoshiConverterFactory.create(moshi))
      .build()

  @Provides
  @JvmStatic
  fun provideOkHttp(): OkHttpClient =
    OkHttpClient.Builder()
      .protocols(listOf(Protocol.HTTP_2))
      .addNetworkInterceptor(HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.NONE
        if (BuildConfig.DEBUG) level = HttpLoggingInterceptor.Level.BODY
      }).build()

  @Provides
  @JvmStatic
  fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)
}
package ie.otormaigh.blank

import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import ie.otormaigh.blank.di.DaggerAppComponent
import javax.inject.Inject

class BlankApplication : Application(), HasAndroidInjector {
  @Inject
  lateinit var androidInjector: DispatchingAndroidInjector<Any>

  override fun onCreate() {
    super.onCreate()

    DaggerAppComponent.builder()
      .application(this)
      .build()
  }

  override fun androidInjector(): AndroidInjector<Any> = androidInjector
}
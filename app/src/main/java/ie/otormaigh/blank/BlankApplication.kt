package ie.otormaigh.blank

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import ie.otormaigh.blank.di.DaggerAppComponent
import javax.inject.Inject

class BlankApplication : Application(), HasActivityInjector {
  @Inject
  lateinit var activityInjector: DispatchingAndroidInjector<Activity>

  override fun onCreate() {
    super.onCreate()

    DaggerAppComponent.builder()
      .application(this)
      .build()
  }

  override fun activityInjector(): AndroidInjector<Activity> = activityInjector
}
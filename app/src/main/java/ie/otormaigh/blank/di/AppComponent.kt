package ie.otormaigh.blank.di

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import ie.otormaigh.blank.BlankApplication
import javax.inject.Singleton

@Singleton
@Component(
  modules = [
    AndroidInjectionModule::class,
    AndroidSupportInjectionModule::class,
    ActivityBuilder::class,
    ApiModule::class]
)
interface AppComponent {
  @Component.Builder
  interface Builder {
    @BindsInstance
    fun application(application: BlankApplication): Builder

    fun build(): AppComponent
  }
}
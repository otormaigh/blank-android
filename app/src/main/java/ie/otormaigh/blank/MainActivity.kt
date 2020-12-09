package ie.otormaigh.blank

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.android.AndroidInjection
import ie.otormaigh.blank.api.ApiService
import ie.otormaigh.blank.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
  @Inject
  lateinit var api: ApiService

  private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

  override fun onCreate(savedInstanceState: Bundle?) {
    AndroidInjection.inject(this)
    super.onCreate(savedInstanceState)
    setContentView(binding.root)

    binding.tvHelloWorld.setOnClickListener {
      GlobalScope.launch { api.getUser() }
    }
  }
}

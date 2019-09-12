package ie.otormaigh.blank

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ie.otormaigh.blank.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
  private lateinit var binding: ActivityMainBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)
  }
}

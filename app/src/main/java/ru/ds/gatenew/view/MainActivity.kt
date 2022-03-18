package ru.ds.gatenew.view

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.ds.gatenew.R
import ru.ds.gatenew.databinding.ActivityMainBinding
import kotlin.system.exitProcess


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.container, CallbackFragment.newInstance())
                    .commit()
            closeApp()
        }
    }

    private fun closeApp() {

        Thread {
            Thread.sleep(4000)
            finish()
        }.start()
    }


}
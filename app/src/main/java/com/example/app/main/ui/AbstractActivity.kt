package com.example.app.main.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.app.databinding.ActivityMainBinding
import io.reactivex.rxjava3.disposables.CompositeDisposable


abstract class AbstractActivity : AppCompatActivity() {
    protected var binding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.getRoot())
    }
}
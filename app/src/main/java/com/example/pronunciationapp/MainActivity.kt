package com.example.pronunciationapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.pronunciationapp.databinding.ActivityMainBinding
import java.util.Locale

class MainActivity : AppCompatActivity(),View.OnClickListener {
    private val binding:ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    var getStrinFromEt:String?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initialMethod()
    }
    private fun initialMethod() {
        binding.apply {
            getStrinFromEt=etForEnterText.text.toString()
            Log.d("textvalueee", "initialMethod: $getStrinFromEt")
            buttonAmerican.setOnClickListener(this@MainActivity)
            buttonUs.setOnClickListener(this@MainActivity)
            buttonSpeak.setOnClickListener(this@MainActivity)
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        TToSpeakMAnger.shutdown()
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.buttonAmerican->{
                TToSpeakMAnger.setLanguage(Locale.US)
            }
            R.id.buttonUs->{
                TToSpeakMAnger.setLanguage(Locale.UK)
            }
            R.id.buttonSpeak->{
                getStrinFromEt?.let { TToSpeakMAnger.speakText(it) }
            }
        }
    }
}
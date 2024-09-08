package com.example.pronunciationapp
import android.annotation.SuppressLint
import android.content.Context
import android.speech.tts.TextToSpeech
import java.util.Locale


@SuppressLint("StaticFieldLeak")
object TToSpeakMAnger:TextToSpeech.OnInitListener {
        private var textToSpeech: TextToSpeech? = null
        private var context: Context? = null

        fun initialize(context: Context) {
            this.context = context
            textToSpeech = TextToSpeech(context, this)
        }
        override fun onInit(status: Int) {
            if (status == TextToSpeech.SUCCESS) {
                // Set default language to American English
                val result = textToSpeech?.setLanguage(Locale.US)
                if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                    // Handle language not supported or missing data
                }
            }
        }
        fun setLanguage(locale: Locale) {
            textToSpeech?.language = locale
        }
        fun speakText(text: String) {
            textToSpeech?.speak(text, TextToSpeech.QUEUE_FLUSH, null, null)
        }

        fun shutdown() {
            textToSpeech?.stop()
            textToSpeech?.shutdown()
        }

}
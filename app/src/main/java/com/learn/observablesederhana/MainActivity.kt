package com.learn.observablesederhana

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.kotlin.toObservable
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Menghubungkan dengan widget secara langsung
        // memanfaatkan plugin android extension
        // dan menambahkan event onclick untuk memanggil
        // method startStream
        btn_test.setOnClickListener{startStream()}
    }

    private fun startStream()
    {
        // menyediakan list data untuk dijadikan observale
        val list = listOf("1", "2", "3", "4", "5")

        // menjadikan list menjadi observable sekaligun
        // mendaftarkan subsribernya
        list.toObservable().subscribeBy(
                onNext = { println(it)},
                onError = {it.printStackTrace()},
                onComplete = { println("onComplete - proses selesai")}
        )
    }
}
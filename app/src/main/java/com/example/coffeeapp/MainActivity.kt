package com.example.coffeeapp

import android.app.DownloadManager
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.webkit.URLUtil
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val c: Context = this;

        val btnMenu : Button = findViewById(R.id.btnMenu)
        btnMenu.setOnClickListener {
//            // uri: https://www.adobe.com/support/products/enterprise/knowledgecenter/media/c4611_sample_explain.pdf
//            val uri: Uri = Uri.parse("https://cdn.v-a-c.org/v-a-c-static/store/document/271/file/0a396ff10dc0b581dc3d6b8941dd5d0c.pdf")
//            val title: String = URLUtil.guessFileName(uri.toString(), null, null)
//            val request: DownloadManager.Request = DownloadManager.Request(uri)
//
//            request.setTitle(title)
//            request.setDescription("загрузка файла...")
//            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
//            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, title)
//
//            val manager = c.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
//            Toast.makeText(c, "Загрузка файла", Toast.LENGTH_LONG).show()
//            manager.enqueue(request)

            val webPDFIntent : Intent = Intent(c, WebViewPDFActivity::class.java)
            startActivity(webPDFIntent)
        }

        val btnAbout : Button = findViewById(R.id.btnAbout)
        btnAbout.setOnClickListener {
            // uri: https://ya.ru
            val siteIntent : Intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://vk.com"))
            startActivity(siteIntent)
        }

        val btnContacts : Button = findViewById(R.id.btnContacts)
        btnContacts.setOnClickListener {
            val webIntent : Intent = Intent(c, WebViewActivity::class.java)
            startActivity(webIntent)

        }

        val btnPhone : Button = findViewById(R.id.btnPhone)
        btnPhone.setOnClickListener {
            // tel:+7(926)000-00-00
            val phoneIntent : Intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:+7(926)000-00-00"))
            startActivity(phoneIntent)
        }

        val btnVK : Button = findViewById(R.id.btnVK)
        btnVK.setOnClickListener {
            // uri: market://details?id=com.vkontakte.android
//            val vkIntent : Intent = Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.vkontakte.android"))
//            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.vkontakte.android")))
//            startActivity(vkIntent)
            val packageName = "com.vkontakte.android"
            try {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=$packageName")))
            } catch (e: ActivityNotFoundException) {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=$packageName")))
            }
        }

        val btnEmail : Button = findViewById(R.id.btnEmail)
        btnEmail.setOnClickListener {
            val emailIntent : Intent = Intent(Intent.ACTION_SEND)
            emailIntent.type = "text/"
            emailIntent.putExtra(Intent.EXTRA_EMAIL, "mail_name@mail_domen.mail_root")
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Вопрос о приложении")
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Добрый день! ...")
            startActivity(Intent.createChooser(emailIntent, "Написать разработчику"))
        }
    }
}
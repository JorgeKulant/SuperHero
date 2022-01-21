package com.example.superherolist

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.TextView
import androidx.annotation.ContentView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.info_layout.*
import kotlinx.android.synthetic.main.info_layout.heroNameAct
import kotlinx.android.synthetic.main.info_layout.publisherAct
import kotlinx.android.synthetic.main.info_layout.realNameAct
import kotlinx.android.synthetic.main.item_superhero.*
import kotlinx.android.synthetic.main.item_superhero.view.*

class DetailActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle? ){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.info_layout)

        heroNameAct.setText(intent.extras?.get("heroNameAct").toString())
        publisherAct.setText(intent.extras?.get("publisherAct").toString())
        infoAct.setText(intent.extras?.get("infoAct").toString())
        realNameAct.setText(intent.extras?.get("realNameAct").toString())
        Picasso.get().load(intent.extras?.get("imagenHeroAct").toString()).into(imageHeroAct)
    }


}
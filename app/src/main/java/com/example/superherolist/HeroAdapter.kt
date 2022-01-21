package com.example.superherolist

import android.content.Intent
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_superhero.view.*


class HeroAdapter (var items:MutableList<SuperHero>):RecyclerView.Adapter<HeroAdapter.HeroHolder>(){

    private val originalItems= mutableListOf<SuperHero>()

    class HeroHolder(private val view: View): RecyclerView.ViewHolder(view){
    fun render(superhero:SuperHero){

        view.realNameAct.text=superhero.realName
        view.heroNameAct.text=superhero.superHeroName
        view.publisherAct.text=superhero.publisher
        Picasso.get().load(superhero.image).into(view.imageHero)

        view.setOnClickListener{
            val context=view.context

            Toast.makeText(context, "Has seleccionado a ${superhero.superHeroName}", Toast.LENGTH_SHORT).show()
            abrirDetail(superhero)
        }


    }

    private fun abrirDetail(superhero: SuperHero){
        val intent=Intent(view.context, DetailActivity::class.java).apply{
           putExtra("imagenHeroAct", superhero.image)
           putExtra("heroNameAct", superhero.superHeroName)
            putExtra("realNameAct", superhero.realName)
            putExtra("publisherAct", superhero.publisher)
            putExtra("infoAct", superhero.description)
        }
        view.context.startActivity(intent)

    }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroHolder {
        val layoutInflater=LayoutInflater.from(parent.context)
        return HeroHolder(layoutInflater.inflate(R.layout.item_superhero, parent, false))
    }

    override fun onBindViewHolder(holder: HeroHolder, position: Int) {
        holder.render(items[position])


    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun filter(text: String){
        originalItems.addAll(items)
        var collect= mutableListOf<SuperHero>()
        if(text.isEmpty()){
            items.clear()
            collect.clear()
            items.addAll(originalItems)
        }
        else{
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
               items.clear()


               originalItems.forEach {
                    if(it.realName.toLowerCase().contains(text.toLowerCase()) ||
                        it.superHeroName.toLowerCase().contains(text.toLowerCase()) ||
                        it.publisher.toLowerCase().contains(text.toLowerCase())){
                            collect.add(it)
                   }
                }
                items.addAll(collect)

            }
            else{
                items.clear()
                originalItems.forEach {
                    if(it.realName.toLowerCase().contains(text.toLowerCase()) ||
                        it.superHeroName.toLowerCase().contains(text.toLowerCase()) ||
                        it.publisher.toLowerCase().contains(text.toLowerCase())){
                            items.add(it)

                    }
                }
            }
        }
        notifyDataSetChanged()

    }
}



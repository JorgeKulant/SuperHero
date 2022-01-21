package com.example.superherolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener{

    val superheros= mutableListOf<SuperHero>(
        SuperHero("Spiderman", "Peter Parker", "Marvel", "https://i1.wp.com/wipy.tv/wp-content/uploads/2019/08/destino-de-%E2%80%98Spider-Man%E2%80%99-en-los-Comics.jpg", "Spider-Man, traducido en ocasiones como Hombre Araña, es un personaje creado por los estadounidenses Stan Lee y Steve Ditko, e introducido en el cómic Amazing Fantasy n.° 15, publicado por Marvel Comics en agosto de 1962. Se trata de un superhéroe que emplea sus habilidades sobrehumanas, reminiscentes de una araña, para combatir a otros supervillanos que persiguen fines siniestros."),
        SuperHero("Daredevil", "Matthew Michael Murdock", "Marvel", "https://www.tonica.la/__export/1607623713894/sites/debate/img/2020/12/10/daredevil-5-comics-conocer-mejor-hombre-sin-miedo.jpg_463833556.jpg","Daredevil (también llamado Dan Defensor, Diablo Defensor o Diabólico en muchas de las traducciones al español), alter ego de Matthew Michael \"Matt\" Murdock, es un superhéroe ficticio que aparece en los cómics estadounidenses publicados por Marvel Comics. Daredevil fue creado por el escritor y editor Stan Lee y el artista Bill Everett, con una cantidad no especificada de aportes de Jack Kirby. El personaje apareció por primera vez en Daredevil #1 (abril de 1964) en la Edad de Plata de los cómics. La influencia del escritor y artista Frank Miller en el título a principios de la década de 1980 . Daredevil es comúnmente conocido por apodos como \"El hombre sin miedo\" y el \"Diablo de la Cocina del Infierno\"."),
        SuperHero("Wolverine", "James Howlett", "Marvel", "https://64.media.tumblr.com/b585f8a8511e482937308f349ba70d63/881032dcdb836b47-26/s1280x1920/57467121a98edb685aee4b5c34341b7e9cd67990.png","Wolverine, cuyo nombre de nacimiento es James Howlett (también conocido como James Logan o simplemente Logan) es un superhéroe ficticio que aparece en los cómics estadounidenses publicado por Marvel Comics, principalmente en asociación con los X-Men. Es un mutante que posee sentidos afinados a los animales, capacidades físicas mejoradas, poderosa capacidad de regeneración conocida como un factor de curación, y tres garras retráctiles en cada mano. Wolverine ha sido representado de diversas formas como miembro de los X-Men, Alpha Flight, Fuerza-X y Los Vengadores."),
        SuperHero("Batman", "Bruce Wayne", "DC", "https://phantom-marca.unidadeditorial.es/6161d26552642001615e76ee9d23eba3/resize/660/f/webp/assets/multimedia/imagenes/2021/08/11/16286547533760.jpg","Batman (conocido inicialmente como Bat-Man y en español como el Hombre Murciélago) es un personaje de cómic creado por los estadounidenses Bob Kane y Bill Finger, y propiedad de DC Comics. Apareció por primera vez en la historia titulada «El caso del sindicato químico» de la revista Detective Comics N.º 27, lanzada por la editorial National Publications el 30 de marzo de 1939.\n" +
                "La identidad secreta de Batman es Bruce Wayne (Bruno Díaz en algunos países de habla hispana), un multimillonario magnate empresarial y filántropo dueño de Empresas Wayne en Gotham City. Después de presenciar el asesinato de sus padres, el Dr. Thomas Wayne y Martha Wayne en un violento y fallido asalto cuando era niño, juró venganza contra los criminales, un juramento moderado por el sentido de la justicia. Bruce Wayne se entrena física e intelectualmente y crea un traje inspirado en los murciélagos para combatir el crimen, con sus gadgets de combate del batcinturón y sus vehículos."),
        SuperHero("Thor", "Thor Odison", "Marvel", "https://www.cinemascomics.com/wp-content/uploads/2020/06/thor-comics-960x720.jpg","Thor (del nórdico antiguo Þórr, pronunciado /θɔr/) es el dios del trueno y fuerza en la mitología nórdica y germánica. Su papel es complejo ya que tenía influencia en áreas muy diferentes, tales como el clima, las cosechas, la protección, la consagración, la justicia, las lidias, los viajes y las batallas."),
        SuperHero("Flash", "Jay Garrick", "DC", "https://img.lalr.co/cms/2020/03/18163205/flash-alpha-codersal.jpg","Flash (conocido también como The Flash y traducido en español: Destello) es el nombre de varios superhéroes ficticios que aparecen en los cómics estadounidenses publicados por DC Comics. Creado por el escritor Gardner Fox y el artista Harry Lampert, el \"Flash\" original apareció por primera vez en Flash Comics #1 (fecha de portada de enero de 1940 / mes de noviembre de 1939). Apodado el \"Corredor Escarlata\", todas las encarnaciones del Flash poseen \"súper velocidad\", que incluye la capacidad de correr, moverse y pensar extremadamente rápido, también puede atravesar la materia sólida, usar reflejos sobrehumanos y aparentemente violar ciertas leyes de la física, como superar la velocidad de la luz."),
        SuperHero("Green Lantern", "Alan Scott", "DC", "https://www.latercera.com/resizer/CxTUjEZn_TfizsK_dZUYwbMZ2y4=/900x600/smart/arc-anglerfish-arc2-prod-copesa.s3.amazonaws.com/public/3ELACAM7LRF7NONYW2OJJ2FAPQ.jpg","Linterna Verde (en inglés: Green Lantern) es el alias de varios superhéroes de la ficción del Universo DC, de la editorial DC Comics, los cuales se caracterizan por portar un anillo de poder y tener la capacidad de crear manifestaciones de luz sólida con dichos anillos.\n" +
                "\n" +"El primer Linterna Verde (Alan Scott) hizo su debut en julio de 1940 en el All-American Comics #16 (portada de Sheldon Moldoff) durante la Edad de Oro del Cómic estadounidense.1 Su creación se la debemos al guionista Bill Finger y al dibujante Martín Nodell."),
        SuperHero("Wonder Woman", "Princess Diana", "DC", "https://www.funidelia.es/blog/wp-content/uploads/2016/08/wonderwoman.png","La Mujer Maravilla (en inglés: Wonder Woman) es una superheroína ficticia creada por William Moulton Marston para la editorial DC Comics. Es una princesa guerrera de las Amazonas, pueblo ficticio basado en el de las amazonas de la mitología griega. En su tierra natal es conocida como la princesa Diana de Temiscira pero fuera de esta utiliza la identidad secreta de Diana Prince. Está dotada de una amplia gama de poderes superhumanos y habilidades de combate de batalla superiores, gracias a sus dones obtenidos de los dioses y su amplio entrenamiento. Ella posee un gran arsenal de armas, incluyendo entre las principales el Lazo de la Verdad, un par de brazaletes mágicos indestructibles, su tiara, que sirve como arma, y en algunos relatos, en la edad de oro, tuvo un avión invisible. Pero más adelante, se le fue mostrando con la capacidad de volar cada vez con mayor frecuencia por lo que el avión invisible fue dejando de utilizarse.")
    )
    val adapter=HeroAdapter(superheros)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecycler()

        initListener()

    }
    fun initRecycler(){
        rvSuperHero.layoutManager=LinearLayoutManager(this)
        rvSuperHero.adapter=adapter

    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        return false
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        if (newText != null) {
            adapter.filter(newText)
        }
        return false
    }

    private fun initListener(){
        findViewById<android.widget.SearchView>(R.id.txtBuscar).setOnQueryTextListener(this)
    }


}




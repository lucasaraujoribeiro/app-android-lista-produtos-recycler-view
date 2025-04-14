package br.com.lucasaraujo.trabalhopratico02.view.adapter

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.lucasaraujo.trabalhopratico02.R
import br.com.lucasaraujo.trabalhopratico02.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        iniciaRecyclerView()
    }

    private fun iniciaRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.setHasFixedSize(true)
        val timesList = preencheDados()
        val adapter = AdapterProduto(timesList)
        binding.recyclerView.adapter = adapter

    }

    data class Produto(val nome: String, val drawable: Int, val preco: Double, val descricao: String, val peso: String, val marca: String)

    fun preencheDados(): List<Produto> {
        return listOf(
            Produto("Whey protein", R.drawable.grouth_whey_protein, 124.90, "Whey protein Growth fornece proteínas para quem deseja hipertrofia e definição muscular.", "1Kg", "Growth Suplementos"),
            Produto("Creatine", R.drawable.grouth_creatine, 109.90,"Creatina Creapure, a mais alta tecnologia em um suplemento para o seu treino!", "250g", "Growth Suplementos"),
            Produto("Pré treino Haze", R.drawable.grouth_pre_treino_haze, 104.90, "Suplemento para quem treina com alta intensidade ou alto volume", "300g", "Growth Suplementos"),
            Produto("Beta-alanine", R.drawable.grouth_beta_alanine, 68.90, "Para esportes de resistência e força", "250 g", "Growth Suplementos"),
            Produto("Barra de proteína", R.drawable.grouth_barra_de_proteina, 44.90, "Com 11g de proteína e até 175 kcal por porção, os 9 deliciosos sabores recheados da barra proteica Growth são ótimas opções para lanche ou sobremesa. Excelente para o paladar e para a dieta!", "400g", "Growth Suplementos"),
            Produto("Hiper Mass", R.drawable.grouth_hipercalorico, 39.90, "Grande concentração de energia para o corpo", "1Kg", "Growth Suplementos"),
            Produto("Multi Vitamínico", R.drawable.grouth_multi_vitaminico, 47.90, "Dose diária de micronutrientes", "120 capsulas", "Growth Suplementos"),
        )
    }
}
package br.com.lucasaraujo.trabalhopratico02.view.adapter

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.com.lucasaraujo.trabalhopratico02.R

class ProdutoDetalheActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_produto_detalhe)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val imgViewProduto : ImageView = findViewById(R.id.imgProduto)
        val txtNomeProduto : TextView = findViewById(R.id.txtNome)
        val txtViewDescricao : TextView = findViewById(R.id.txtDescricao)
        val txtViewPeso : TextView = findViewById(R.id.txtPeso)
        val txtViewPreco : TextView = findViewById(R.id.txtPreco)
        val txtViewMarca : TextView = findViewById(R.id.txtMarca)

        val idImagem = intent.getIntExtra("imagem", 0)
        val nome = intent.getStringExtra("nome")
        val descricao = intent.getStringExtra("descricao")
        val peso = intent.getStringExtra("peso")
        val preco = intent.getStringExtra("preco")
        val marca = intent.getStringExtra("marca")

        imgViewProduto.setImageResource(idImagem)
        txtNomeProduto.setText(nome)
        txtViewDescricao.setText(descricao)
        txtViewPeso.setText(peso)
        txtViewPreco.setText(preco)
        txtViewMarca.setText(marca)

        val mainActivityIntent = Intent(this, MainActivity::class.java)
        val imgVoltar : ImageView = findViewById(R.id.imgVoltar)

        imgVoltar.setOnClickListener {
            startActivity(mainActivityIntent)
        }
    }

}
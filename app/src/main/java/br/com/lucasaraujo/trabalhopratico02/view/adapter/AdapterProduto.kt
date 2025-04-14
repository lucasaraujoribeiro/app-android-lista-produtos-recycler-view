package br.com.lucasaraujo.trabalhopratico02.view.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.lucasaraujo.trabalhopratico02.R

class AdapterProduto(private val myList: List<MainActivity.Produto>) :
    RecyclerView.Adapter<AdapterProduto.MyViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.produto_adapter, parent, false)
        context = parent.context
        return MyViewHolder(itemView)
    }

    override fun getItemCount() = myList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val produto = myList[position]
        holder.textName.text = produto.nome
        holder.imageView.setImageResource(produto.drawable)
        val precoFormatado = String.format("R$ %.2f", produto.preco)
        holder.textPreco.text = precoFormatado

        holder.itemView.setOnClickListener {
            val intent = Intent(context, ProdutoDetalheActivity::class.java)
            intent.putExtra("nome", produto.nome)
            intent.putExtra("imagem", produto.drawable)
            intent.putExtra("preco", precoFormatado)
            intent.putExtra("descricao", produto.descricao)
            intent.putExtra("peso", produto.peso)
            intent.putExtra("marca", produto.marca)
            context.startActivity(intent)
        }
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imgProduto)
        val textName: TextView = itemView.findViewById(R.id.txtNome)
        val textPreco: TextView = itemView.findViewById(R.id.txtPreco)
    }
}
package edu.kotlin.ciromelody.recyclerviewdemo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import edu.kotlin.ciromelody.recyclerviewdemo.R
import edu.kotlin.ciromelody.recyclerviewdemo.model.Fruit

class MyRecyclerAdapterConClasse(private val fruitList:List<Fruit>,private val funClicked: (Fruit) -> Unit):RecyclerView.Adapter<MyViewHolderConClasse>() {
    /*val fruitList= listOf<String>("Mango","Pesca","Melone",
        "Fichi","Uva","Mele","Albicocche","Ciliege","Banane")*/

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolderConClasse {

        val layoutinflater= LayoutInflater.from(parent.context)
        val listitem=layoutinflater.inflate(R.layout.item_recyclerview,parent,false)
        return MyViewHolderConClasse(listitem)
    }

    override fun getItemCount(): Int {
        //return 8
       return fruitList.size
    }



    override fun onBindViewHolder(holder: MyViewHolderConClasse, position: Int) {
      /*  val frutta=fruitList.get(position).frutta
        val mangiatoreDiFrutta=fruitList.get(position).mangiaFrutta
        holder.myTextView.text= "$frutta-$mangiatoreDiFrutta"*/
        val fruit=fruitList.get(position)
        holder.bind(fruit, funClicked)
    }

    override fun getItemViewType(position: Int): Int {
        //metodo opzionale serve probabilmente per aver la lista com
        // item diversi tipi
        return super.getItemViewType(position)
    }
}

class MyViewHolderConClasse(val view: View):RecyclerView.ViewHolder(view){
    fun bind(fruit: Fruit, funClicked:(Fruit)->Unit){
        val myTextView=view.findViewById<TextView>(R.id.id_item_textView_recycler)
        myTextView.text= "${fruit.frutta}-${fruit.mangiaFrutta}"
        view.setOnClickListener{
           // Toast.makeText(view.context,fruit.mangiaFrutta,Toast.LENGTH_LONG).show()
            funClicked(fruit)
        }
    }


}
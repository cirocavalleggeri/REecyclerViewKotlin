package edu.kotlin.ciromelody.recyclerviewdemo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import edu.kotlin.ciromelody.recyclerviewdemo.R

class MyRecyclerAdapter(val fruitList:List<String>):RecyclerView.Adapter<MyViewHolder>() {
    /*val fruitList= listOf<String>("Mango","Pesca","Melone",
        "Fichi","Uva","Mele","Albicocche","Ciliege","Banane")*/

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val layoutinflater= LayoutInflater.from(parent.context)
        val listitem=layoutinflater.inflate(R.layout.item_recyclerview,parent,false)
        return MyViewHolder(listitem)
    }

    override fun getItemCount(): Int {
        //return 8
       return fruitList.size
    }



    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val frutta=fruitList.get(position)
        holder.myTextView.text=frutta
    }

    override fun getItemViewType(position: Int): Int {
        //metodo opzionale serve probabilmente per aver la lista com
        // item diversi tipi
        return super.getItemViewType(position)
    }
}

class MyViewHolder(val view: View):RecyclerView.ViewHolder(view){
    val myTextView=view.findViewById<TextView>(R.id.id_item_textView_recycler)

}
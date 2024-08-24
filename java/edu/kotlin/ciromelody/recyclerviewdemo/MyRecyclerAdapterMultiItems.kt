package edu.kotlin.ciromelody.recyclerviewdemo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import edu.kotlin.ciromelody.recyclerviewdemo.R
import edu.kotlin.ciromelody.recyclerviewdemo.model.Fruit

class MyRecyclerAdapterMultiItems(private val fruitList:List<Fruit>,private val funClicked: (Fruit) -> Unit):RecyclerView.Adapter<MyViewHolderMultiItem>() {
    /*val fruitList= listOf<String>("Mango","Pesca","Melone",
        "Fichi","Uva","Mele","Albicocche","Ciliege","Banane")*/
       private val LAYOUT_ONE= 0;
       private val  LAYOUT_TWO= 1;
       private val LAYOUT_THREE= 2
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolderMultiItem {
      if(viewType==LAYOUT_ONE){
           val layoutinflater= LayoutInflater.from(parent.context)
           val listitem=layoutinflater.inflate(R.layout.item_recyclerview,parent,false)
           return MyViewHolderMultiItem(listitem)
      }else{
          val layoutinflater= LayoutInflater.from(parent.context)
          val listitem=layoutinflater.inflate(R.layout.item_recyclerview_2,parent,false)
          return MyViewHolderMultiItem(listitem)
      }

    }

    override fun getItemCount(): Int {
        //return 8
       return fruitList.size
    }



    override fun onBindViewHolder(holder: MyViewHolderMultiItem, position: Int) {
      /*  val frutta=fruitList.get(position).frutta
        val mangiatoreDiFrutta=fruitList.get(position).mangiaFrutta
        holder.myTextView.text= "$frutta-$mangiatoreDiFrutta"*/
        val fruit=fruitList.get(position)
        holder.bind(fruit, funClicked)
    }

    override fun getItemViewType(position: Int): Int {
        //metodo opzionale serve probabilmente per aver la lista com
        // item diversi tipi
        if(fruitList.get(position).mangiaFrutta.equals("Ciro")){
            return LAYOUT_TWO
        }else{return LAYOUT_ONE}
       // return position
        //return super.getItemViewType(position)
    }
}

class MyViewHolderMultiItem(val view: View):RecyclerView.ViewHolder(view){
    fun bind(fruit: Fruit, funClicked:(Fruit)->Unit){
        if(getItemViewType()==0) {

            val myTextView = view.findViewById<TextView>(R.id.id_item_textView_recycler)
            myTextView.text = "${fruit.frutta}-${fruit.mangiaFrutta}"
            view.setOnClickListener {
                // Toast.makeText(view.context,fruit.mangiaFrutta,Toast.LENGTH_LONG).show()
                funClicked(fruit)
            }

        }
        if(getItemViewType()==1) {

            val myTextView = view.findViewById<TextView>(R.id.id_item_textView_recycler_2)
            myTextView.text = "${fruit.frutta}-${fruit.mangiaFrutta}"
            view.setOnClickListener {
                // Toast.makeText(view.context,fruit.mangiaFrutta,Toast.LENGTH_LONG).show()
                funClicked(fruit)
            }

        }
    }


}
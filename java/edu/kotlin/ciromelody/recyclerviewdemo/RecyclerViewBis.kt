package edu.kotlin.ciromelody.recyclerviewdemo

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.kotlin.ciromelody.recyclerviewdemo.adapter.MyRecyclerAdapter
import edu.kotlin.ciromelody.recyclerviewdemo.adapter.MyRecyclerAdapterConClasse
import edu.kotlin.ciromelody.recyclerviewdemo.adapter.MyRecyclerAdapterMultiItems
import edu.kotlin.ciromelody.recyclerviewdemo.model.Fruit

class RecyclerViewBis : AppCompatActivity() {
    val fruitList= listOf<String>("Mango","Pesca","Melone",
        "Fichi","Uva","Mele","Albicocche","Ciliege","Banane")
    val fruitListConClasse= listOf<Fruit>(Fruit("Mango","Giacomo")
        ,Fruit("Pesca","Rosario"),Fruit("Melone","Mimmo"),
         Fruit("Fichi","Ciro"),Fruit("Uva","Giggetto"),
         Fruit("Mele","Aldo"),Fruit("Albicocche","Samuele"),
         Fruit("Ciliege","Daniela"),
            Fruit("Banane","Ciro")
         )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        val recyclerview=findViewById<RecyclerView>(R.id.id_recyclerView)
        recyclerview.setBackgroundColor(Color.BLUE)
        recyclerview.layoutManager=LinearLayoutManager(this)
        //recyclerview.adapter= MyRecyclerAdapter(fruitList)

        // passo la funzione come se fosse un parametro
       /* recyclerview.adapter= MyRecyclerAdapterConClasse(fruitListConClasse,
                                                       // {selectedItem:Fruit->listItemClicked(selectedItem)}
            fun (it:Fruit):Unit{listItemClicked(it)
            }
            )*/
       // recyclerview con items diversi
        recyclerview.adapter= MyRecyclerAdapterMultiItems(fruitListConClasse,
            // {selectedItem:Fruit->listItemClicked(selectedItem)}
            fun (it:Fruit):Unit{listItemClicked(it)
            }
        )

    }
    private fun listItemClicked(fruit: Fruit){
        Toast.makeText(this,fruit.mangiaFrutta, Toast.LENGTH_LONG).show()

    }
}
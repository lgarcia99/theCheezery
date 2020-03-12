package chavez.alma.thecheezery

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.*
import kotlinx.android.synthetic.main.activity_products.*
import kotlinx.android.synthetic.main.item_product.view.*

class ProductsActivity : AppCompatActivity() {

    var coldDrinks =  ArrayList<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        val  bundle =intent.extras

        if(bundle!=null){
            val type=bundle.getString("type")

            when(type){
                "coldDrinks"-> cargarColdDrinks()

            }


        }

        cargarColdDrinks()

        var adaptador = AdaptadorProductos(this, coldDrinks)
        list_products.adapter = adaptador
    }

    fun cargarColdDrinks(){
       
        coldDrinks.add(Product("Caramel Frap", R.drawable.caramelfrap, "Caramel syrup meets coffee, milk and ice and whipped cream and buttery caramel sauce layer the love on top.", 5))
        coldDrinks.add(Product("Chocolate Frap", R.drawable.chocolatefrap, "Rich mocha-flavored sauce meets up with chocolaty chips, milk and ice for a blender bash.", 6))
        coldDrinks.add(Product("Cold Brew", R.drawable.coldbrew, "Created by steeping medium-to-coarse ground coffee in room temperature water for 12 hours or longer.", 3))
        coldDrinks.add(Product("Matcha Latte", R.drawable.matcha, "Leafy taste of matcha green tea powder with creamy milk and a little sugar for a flavor balance that will leave you feeling ready and raring to go.", 4))
        coldDrinks.add(Product("Oreo Milkshake", R.drawable.oreomilkshake, "Chocolate ice cream, and oreo cookies. Topped with whipped cream with cocoa and chocolate syrup.", 7))
        coldDrinks.add(Product("Peanut Milkshake", R.drawable.peanutmilkshake, "Vanilla ice cream, mixed with peanut butter and chocolate.", 7))

    }

    private class AdaptadorProductos:BaseAdapter{
        var contexto: Context? = null
        var productos = ArrayList<Product>()

        constructor(contexto:Context, productos: ArrayList<Product>){
            this.contexto = contexto
            this.productos = productos
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
           var produ = productos[position]
            var inflator = LayoutInflater.from(contexto)
            var vista = inflator.inflate(R.layout.item_product, null)

            vista.product_name.setText(produ.name)
            vista.product_description.setText(produ.description)
            vista.product_image.setImageResource(produ.image)
            vista.product_price.setText("$${produ.price}")

            return vista


        }

        override fun getItem(position: Int): Any {
            return productos[position]
        }

        override fun getItemId(position: Int): Long {
           return 1
        }

        override fun getCount(): Int {
            return productos.size
        }

    }

}

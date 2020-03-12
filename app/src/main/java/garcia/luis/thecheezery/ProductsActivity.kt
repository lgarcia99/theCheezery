package garcia.luis.thecheezery

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_products.*
import kotlinx.android.synthetic.main.item_product.view.*
import garcia.luis.thecheezery.Product

class ProductsActivity : AppCompatActivity() {

    var coldDrinks = ArrayList<Product>()
    var hotDrinks = ArrayList<Product>()
    var sweets = ArrayList<Product>()
    var salties = ArrayList<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        val type = intent.getStringExtra("type")

        when (type) {
            "coldDrinks" -> {
                cargarColdDrinks()
                title_products.setImageResource(R.drawable.cold_drinks)
                list_products.adapter = AdaptadorProductos(this, coldDrinks)
            }
            "hotDrinks" -> {
                cargarHotDrinks()
                title_products.setImageResource(R.drawable.hot_drinks)
                list_products.adapter = AdaptadorProductos(this, hotDrinks)
            }
            "sweets" -> {
                cargarSweets()
                title_products.setImageResource(R.drawable.sweets)
                list_products.adapter = AdaptadorProductos(this, sweets)
            }
            "salties" -> {
                cargarSalties()
                title_products.setImageResource(R.drawable.salties)
                list_products.adapter = AdaptadorProductos(this, salties)
            }
        }
    }

    fun cargarColdDrinks() {

        coldDrinks.add(
            Product(
                "Caramel Frap",
                R.drawable.caramelfrap,
                "Caramel syrup meets coffee, milk and ice and whipped cream and buttery caramel sauce layer the love on top.",
                5
            )
        )
        coldDrinks.add(
            Product(
                "Chocolate Frap",
                R.drawable.chocolatefrap,
                "Rich mocha-flavored sauce meets up with chocolaty chips, milk and ice for a blender bash.",
                6
            )
        )
        coldDrinks.add(
            Product(
                "Cold Brew",
                R.drawable.coldbrew,
                "Created by steeping medium-to-coarse ground coffee in room temperature water for 12 hours or longer.",
                3
            )
        )
        coldDrinks.add(
            Product(
                "Matcha Latte",
                R.drawable.matcha,
                "Leafy taste of matcha green tea powder with creamy milk and a little sugar for a flavor balance that will leave you feeling ready and raring to go.",
                4
            )
        )
        coldDrinks.add(
            Product(
                "Oreo Milkshake",
                R.drawable.oreomilkshake,
                "Chocolate ice cream, and oreo cookies. Topped with whipped cream with cocoa and chocolate syrup.",
                7
            )
        )
        coldDrinks.add(
            Product(
                "Peanut Milkshake",
                R.drawable.peanutmilkshake,
                "Vanilla ice cream, mixed with peanut butter and chocolate.",
                7
            )
        )

    }

    fun cargarHotDrinks() {
        hotDrinks.add(
            Product(
                "Latte",
                R.drawable.latte,
                "Coffee drink made with espresso and steamed milk",
                6
            )
        )
        hotDrinks.add(
            Product(
                "Hot chocolate",
                R.drawable.hotchocolate,
                "Heated drink consisting of shaved chocolate, topped with marshmallows.",
                5
            )
        )
        hotDrinks.add(
            Product(
                "Espresso",
                R.drawable.espresso,
                "Full-flavored, concentrated form of coffee.",
                4
            )
        )
        hotDrinks.add(
            Product(
                "Chai Latte",
                R.drawable.chailatte,
                "Spiced tea concentrate with milk",
                6
            )
        )
        hotDrinks.add(
            Product(
                "Capuccino",
                R.drawable.capuccino,
                "A cappuccino is an espresso-based coffee drink, prepared with steamed foam.",
                7
            )
        )
        hotDrinks.add(
            Product(
                "American coffee",
                R.drawable.americano,
                "Espresso with hot water",
                2
            )
        )
    }

    fun cargarSweets() {
        sweets.add(
            Product(
                "Blueberry cake",
                R.drawable.blueberrycake,
                "Vanilla cake flavor, topped with cheese topping and blueberries.",
                6
            )
        )
        sweets.add(
            Product(
                "Chocolate cupcake",
                R.drawable.chocolatecupcake,
                "Chocolate cupcakes topped with butter cream and cherries",
                3
            )
        )
        sweets.add(
            Product(
                "Lemon tartalette",
                R.drawable.lemontartalette,
                "Pastry shell with a lemon flavored filling",
                4
            )
        )
        sweets.add(
            Product(
                "Red Velvet cake",
                R.drawable.redvelvetcake,
                "Soft, moist, buttery cake topped with an easy cream cheese frosting.",
                6
            )
        )
        sweets.add(
            Product(
                "Cherry cheesecake",
                R.drawable.strawberrycheesecake,
                "This cherry topped cheesecake is positively creamy and delicious and will be your new favorite dessert.",
                7
            )
        )
        sweets.add(
            Product(
                "Tiramisu",
                R.drawable.tiramisu,
                "Coffee-flavored Italian dessert",
                6
            )
        )
    }

    fun cargarSalties() {
        salties.add(
            Product(
                "Chicken crepes",
                R.drawable.chickencrepes,
                "Fine crepes stuffed with Alfredo chicken, spinach and mushrooms.",
                6
            )
        )
        salties.add(
            Product(
                "Club Sandwich",
                R.drawable.clubsandwich,
                "A delicious sandwich served with french fries.",
                5
            )
        )
        salties.add(
            Product(
                "Panini",
                R.drawable.hampanini,
                "Sandwich made with Italian bread served warmed by grilling.",
                4
            )
        )
        salties.add(
            Product(
                "Philly cheese steak",
                R.drawable.phillycheesesteak,
                "Smothered in grilled onions, green peppers, mushrooms, and Provolone.",
                6
            )
        )
        salties.add(
            Product(
                "Nachos",
                R.drawable.nachos,
                "Tortilla chips layered with beef and melted cheddar cheese. Served with fried beans, guacamole, pico de gallo, and sour topping.",
                7
            )
        )
    }

    private class AdaptadorProductos : BaseAdapter {
        var contexto: Context? = null
        var productos = ArrayList<Product>()
        var hotDrinks = ArrayList<Product>()
        var sweets = ArrayList<Product>()
        var salties = ArrayList<Product>()

        constructor(contexto: Context, productos: ArrayList<Product>) {
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

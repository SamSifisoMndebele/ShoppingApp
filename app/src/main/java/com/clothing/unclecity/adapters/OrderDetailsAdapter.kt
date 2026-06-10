package com.clothing.unclecity.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.clothing.unclecity.R
import com.clothing.unclecity.activities.OrderDetailsActivity
import com.clothing.unclecity.models.OrderProduct
import com.clothing.unclecity.utils.Extensions.to2DecimalString

class OrderDetailsAdapter(
    private val activity: OrderDetailsActivity,
    private val products: List<OrderProduct>
) : RecyclerView.Adapter<OrderDetailsAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val productImage: ImageView = itemView.findViewById(R.id.product_image_view)
        private val productName: TextView = itemView.findViewById(R.id.product_name)
        private val productBrand: TextView = itemView.findViewById(R.id.product_brand)
        private val productPrice: TextView = itemView.findViewById(R.id.product_price)
        private val productColor: TextView = itemView.findViewById(R.id.product_color)
        private val productSize: TextView = itemView.findViewById(R.id.product_size)
        private val productQuantity: TextView = itemView.findViewById(R.id.product_quantity)

        @SuppressLint("SetTextI18n")
        fun bind(product: OrderProduct) {
            productQuantity.text = "Qty: ${product.quantity}"

            productPrice.text = "R ${product.price.to2DecimalString()}"
            productColor.text = "Color: ${product.color}"
            productSize.text = "Size: ${product.size}"

            Glide.with(activity)
                .load(product.imageUrl)
                .placeholder(R.drawable.placeholder_image)
                .centerCrop()
                .into(productImage)

            productName.text = product.name
            productBrand.text = product.brand
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(
            R.layout.item_checkout_product, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (products.size > position){
            holder.bind(products[position])
        }
    }

    override fun getItemCount(): Int {
        return products.size
    }
}
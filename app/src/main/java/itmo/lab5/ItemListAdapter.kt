package itmo.lab5

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemListAdapter(context: Context, private val itemList:MutableList<Item> = mutableListOf()):
    RecyclerView.Adapter<ItemListAdapter.ViewHolder>()
{
    private val inflater: LayoutInflater = LayoutInflater.from(context)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemListAdapter.ViewHolder{
        return ViewHolder(inflater.inflate(R.layout.list_item,parent,false))
    }

    override fun onBindViewHolder(holder: ItemListAdapter.ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemCount(): Int = itemList.size

    private fun getItem(position: Int): Item = itemList.get(position)

    fun addItem(item: Item){
        itemList.add(item)
    }

    class ViewHolder(ItemView: View): RecyclerView.ViewHolder(ItemView){
        private val description = ItemView.findViewById<TextView>(R.id.description)
        private val title = ItemView.findViewById<TextView>(R.id.title)
        private val important = ItemView.findViewById<ImageView>(R.id.important_image)

        fun bind(item:Item){
            title.text = item.title
            description.text = item.description
            if (!item.important){
                important.visibility = View.GONE
            }
        }
    }
}
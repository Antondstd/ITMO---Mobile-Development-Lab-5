package itmo.lab5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var adapter:ItemListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        val REQUEST_CODE_CHECK = 0

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = ItemListAdapter(this)

        val buttonAddItem:FloatingActionButton = findViewById(R.id.butt_add_item)
        buttonAddItem.setOnClickListener {
            val intent = Intent(this,AddItemActivity::class.java)
            startActivityForResult(intent,0)
        }

        val list = findViewById<RecyclerView>(R.id.todoList)
        list.adapter = adapter

        val decoration = DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL)
        decoration.setDrawable(ContextCompat.getDrawable(this,R.color.black)!!)
        list.addItemDecoration(decoration)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                if (data != null) {
                    val item = data.getParcelableExtra<Item>("added_item")
                    if (item != null) {
                        adapter.addItem(item)
                        adapter.notifyDataSetChanged()
                    }
                }
            }
        }
    }
}
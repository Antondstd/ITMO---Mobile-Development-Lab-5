package itmo.lab5

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class AddItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.add_item_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.save_item -> {
                saveItem()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun saveItem() {

        val item = Item(findViewById<TextView>(R.id.editTitle).text.toString(),
                findViewById<TextView>(R.id.editDescription).text.toString(),
                findViewById<CheckBox>(R.id.isImportant).isChecked)
        if (intent != null) {
            intent.putExtra("added_item", item)
            setResult(RESULT_OK,intent)
        }

        finish()
    }
}
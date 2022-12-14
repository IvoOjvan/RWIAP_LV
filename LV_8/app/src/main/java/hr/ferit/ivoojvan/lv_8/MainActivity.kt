package hr.ferit.ivoojvan.lv_8

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.DocumentId
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity(),
    PersonRecyclerAdapter.ContentListener {
    private val db = Firebase.firestore
    private lateinit var recyclerAdapter: PersonRecyclerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.personList)

        db.collection("persons")
            .get()
            .addOnSuccessListener { result ->
                val personList = ArrayList<Person>()
                for (data in result.documents) {
                    val person = data.toObject(Person::class.java)
                    if (person != null) {
                        person.id = data.id
                        personList.add(person)
                    }
                }
                recyclerAdapter = PersonRecyclerAdapter(personList,
                    this@MainActivity)
                recyclerView.apply {
                    layoutManager = LinearLayoutManager(this@MainActivity)
                    adapter = recyclerAdapter
                }
            }
            .addOnFailureListener { exception ->
                Log.w("MainActivity", "Error getting documents.",
                    exception)
            }

        val etImageURL = findViewById<EditText>(R.id.etImageUrl)
        val etPersonName = findViewById<EditText>(R.id.etName)
        val etDesc = findViewById<EditText>(R.id.etDesc)

        val buttonSave = findViewById<Button>(R.id.buttonSave)
        buttonSave.setOnClickListener{
            val newDocument = db.collection("persons").document()
            newDocument.set(
                Person(
                    newDocument.id.toString(),
                    etImageURL.text.toString(),
                    etPersonName.text.toString(),
                    etDesc.text.toString()
                )
            )

            db.collection("persons")
                .get()
                .addOnSuccessListener { result ->
                    val personList = ArrayList<Person>()
                    for (data in result.documents) {
                        val person = data.toObject(Person::class.java)
                        if (person != null) {
                            person.id = data.id
                            personList.add(person)
                        }
                    }
                    recyclerAdapter = PersonRecyclerAdapter(personList,
                        this@MainActivity)
                    recyclerView.apply {
                        layoutManager = LinearLayoutManager(this@MainActivity)
                        adapter = recyclerAdapter
                    }
                }
                .addOnFailureListener { exception ->
                    Log.w("MainActivity", "Error getting documents.",
                        exception)
                }
        }
    }
    override fun onItemButtonClick(index: Int, person: Person, clickType:
    ItemClickType) {
        if (clickType == ItemClickType.EDIT) {
            db.collection("persons")
                .document(person.id)
                .set(person)
        }
        else if (clickType == ItemClickType.REMOVE) {
            recyclerAdapter.removeItem(index)
            db.collection("persons")
                .document(person.id)
                .delete()
        }
    }

}
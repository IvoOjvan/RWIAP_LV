package hr.ferit.ivoojvan.lv7

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class PersonRecyclerAdapter(private val items:List<Persons>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            RecyclerView.ViewHolder {
        return PersonViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.person_layout, parent, false)
        )
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is PersonViewHolder -> {
                holder.bind(items[position])
            }
        }
    }
    override fun getItemCount(): Int {
        return items.size
    }

    class PersonViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val photoImage: ImageView = itemView.findViewById(R.id.personPhoto)
        private val personName: TextView = itemView.findViewById(R.id.personName)
        private val personBirthday: TextView = itemView.findViewById(R.id.personBirthday)
        private val personAddress: TextView = itemView.findViewById(R.id.personAddress)
        fun bind(persons: Persons) {
            Glide
                .with(itemView.context)
                .load(persons.image)
                .into(photoImage)
            personName.text = "${persons.firstname} ${persons.lastname}"
            personBirthday.text = persons.birthday
            personAddress.text = persons.address.street
        }
    }
    /*private var items : List<Persons> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : RecyclerView.ViewHolder{
        return PersonViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.person_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is PersonViewHolder -> {
                holder.bind(items[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun postItemsList(data: ArrayList<Persons>) {
        items = data
    }

    class PersonViewHolder constructor(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val photoImage: ImageView = itemView.findViewById(R.id.personPhoto)
        private val personName: TextView = itemView.findViewById(R.id.personName)
        private val personBirthday: TextView = itemView.findViewById(R.id.personBirthday)
        private val personAddress: TextView = itemView.findViewById(R.id.personAddress)
        fun bind(persons: Persons) {
            Glide
                .with(itemView.context)
                .load(persons.photoUrl)
                .centerCrop()
                .into(photoImage)
            personName.text = persons.name
            personBirthday.text = persons.birthday
            personAddress.text = persons.address
        }
    }*/
}
package br.com.fabricio.recyclerviewapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_movie.view.*

class MovieRecyclerAdapter(private val movieList: List<MovieModel>, private val callback: (Int) -> Unit): RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return object : RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)) {}
    }

    override fun getItemCount() = movieList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        movieList[position].let {
            with(holder.itemView) {
                Glide.with(this).load(it.image).into(this.coverImgView)
                this.nameTxtView?.text = it.name
                this.genreTxtView?.text = it.genre
                setOnClickListener {
                    callback(position)
                }
            }
        }
    }


}
package br.com.fabricio.recyclerviewapp

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_movie.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView?.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView?.adapter = MovieRecyclerAdapter(MoviesProvider.list){
            Intent(this, DetailActivity::class.java).apply {
                putExtra(DetailActivity.MOVIE_KEY, it)
                val options = ActivityOptions.makeSceneTransitionAnimation(this@MainActivity, coverImgView, "zoom")
                startActivity(this, options.toBundle())
            }

        }

    }
}

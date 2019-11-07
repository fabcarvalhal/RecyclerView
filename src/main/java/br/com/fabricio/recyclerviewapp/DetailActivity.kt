package br.com.fabricio.recyclerviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.item_movie.*
import kotlinx.android.synthetic.main.item_movie.coverImgView
import kotlinx.android.synthetic.main.item_movie.genreTxtView
import kotlinx.android.synthetic.main.item_movie.nameTxtView

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        intent.getIntExtra(MOVIE_KEY, 0).let {
            MoviesProvider.list[it]
        }.apply {
            Glide.with(this@DetailActivity).load(this.image).into(coverImgView)
            nameTxtView?.text = this.name
            genreTxtView?.text = this.genre
            descriptionTxtView?.text = this.description
        }


    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }


    companion object {
        val MOVIE_KEY = "MOVIE"
    }
}

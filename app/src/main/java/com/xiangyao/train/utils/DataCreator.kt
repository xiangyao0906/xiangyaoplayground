package com.xiangyao.train.utils

import java.util.ArrayList

import xiangyao.yizhilu.com.studyjourny.ui.Movie

/**
 * Created by Administrator on 2017/09/11.
 */

class DataCreator {


    object Builder {

        fun creat(num: Int): List<Movie> {
            val movies = ArrayList<Movie>()
            for (x in 0..num - 1) {
                val movie = Movie("1", "2", "3", "4")
                movies.add(movie)
            }
            return movies
        }

    }
}

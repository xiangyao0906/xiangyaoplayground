package xiangyao.yizhilu.com.studyjourny.ui

import com.xiangyao.train.contract.MainActivityContract
import com.xiangyao.train.utils.DataCreator
import com.xiangyao.train.utils.ILog
import xiangyao.yizhilu.com.studyjourny.R
import xiangyao.yizhilu.com.studyjourny.base.BaseActivity

class MainActivity : BaseActivity(), MainActivityContract.View {

    var mainPresnter: MainActivityContract.Presenter? = null

    override fun addOnClicListener() {
    }

    override fun iniData() {



    }

    override fun getContenView(): Int {

        return R.layout.activity_main
    }


    private fun haha() {
        var abc: List<Movie> = DataCreator.Builder.creat(10)
        for (movie: Movie in abc) {
            ILog.i(movie.name)
        }
    }
}

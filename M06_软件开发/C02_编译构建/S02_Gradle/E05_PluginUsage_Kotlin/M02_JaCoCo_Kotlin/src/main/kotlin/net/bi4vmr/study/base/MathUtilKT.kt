package net.bi4vmr.study.base

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.security.auth.callback.UnsupportedCallbackException

/**
 * 数学运算工具类。
 *
 * @author bi4vmr@outlook.com
 * @since 1.0.0
 */
object MathUtilKT {

    val flow = MutableStateFlow(1)
    var job: Job? = null

    init {
       job = CoroutineScope(Dispatchers.Default).launch {
            flow.collect {
                println("flow.collect -> $it")
                if (it == 12){
                    throw IllegalArgumentException("")
                }
            }
        }
    }

    fun divideSafe(a: Int, b: Int): Int? {
        return if (b == 0) {
            null
        } else {
            a / b
        }
    }
}

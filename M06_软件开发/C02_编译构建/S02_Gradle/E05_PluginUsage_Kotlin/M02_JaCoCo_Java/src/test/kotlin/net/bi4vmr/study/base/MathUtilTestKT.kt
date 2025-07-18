package net.bi4vmr.study.base

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

/**
 * MathUtilKT的测试类。
 *
 * @author bi4vmr@outlook.com
 * @since 1.0.0
 */
class MathUtilTestKT {

    @Test
    fun testDivide() = runBlocking {
        // 测试正常的情况
        val result1 = MathUtilKT.divideSafe(32, 8)
        // 断言：结果非空
        Assert.assertNotNull(result1)
        // 断言：结果等于4
        Assert.assertEquals(4L, result1!!.toLong())

        // 测试除数为"0"的情况
        val result2 = MathUtilKT.divideSafe(100, 0)
        // 断言：结果为空
        Assert.assertNull(result2)

        MathUtilKT.flow.value = 1111
        delay(100L)
        MathUtilKT.flow.value = 12
        delay(100L)
        MathUtilKT.job?.cancel()
        delay(1000L)
    }
}

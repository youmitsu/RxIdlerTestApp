package youmeee.co.jp.rxidlertestapp

import android.content.Context
import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.squareup.rx2.idler.Rx2Idler
import io.reactivex.plugins.RxJavaPlugins
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
@LargeTest
class RxIdlerInstrumentedTest {

    private lateinit var context: Context

    @Rule
    @JvmField
    val mActivityRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Before
    fun setUp() {
        context = InstrumentationRegistry.getTargetContext()

        //以下を記述
        RxJavaPlugins.setInitComputationSchedulerHandler(
                Rx2Idler.create("RxJava 2.x Computation Scheduler")
        )
    }

    @Test
    fun testRxIdler() {

    }

    private fun assertListText(text: String) {
        Espresso.onView(ViewMatchers.withText(text)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

}

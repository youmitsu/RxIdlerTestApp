package youmeee.co.jp.rxidlertestapp

import android.content.Context
import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
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
class ExampleInstrumentedTest {

    private lateinit var context: Context

    @Rule
    @JvmField
    val mActivityRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Before
    fun setUp() {
        context = InstrumentationRegistry.getTargetContext()
    }

    @Test
    fun testNotWaitFailed() {

        //待たない
        assertListText("first")
        assertListText("second")
        assertListText("third")
        assertListText("fourth")
        assertListText("fifth")
    }

    @Test
    fun testSleep() {

        //だいたいこれくらい待てば表示されてるでしょっていう時間待つ(3秒待つ)
        Thread.sleep(3000)

        assertListText("first")
        assertListText("second")
        assertListText("third")
        assertListText("fourth")
        assertListText("fifth")
    }

    private fun assertListText(text: String) {
        onView(withText(text)).check(matches(isDisplayed())).perform(ViewActions.click())
    }

}

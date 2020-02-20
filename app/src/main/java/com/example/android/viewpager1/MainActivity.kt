package com.example.android.viewpager1

import android.animation.ArgbEvaluator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Display
import android.view.ViewParent
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var models = arrayListOf<Model>()
    var colors: Array<Int>? = null
    var argbEvaluator = ArgbEvaluator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        models.add(Model(R.drawable.brochure, "Brochure", "A brochure is an informative paper document that can be folded into a template, pamphlet or leaflet. "))
        models.add(Model(R.drawable.sticker, "Sticker", "A sticker is a type of label: a piece of printed paper, plastic, vinyl, or other material with pressure sensitive adhesive on one side"))
        models.add(Model(R.drawable.poster, "Poster", "A poster is a temporary promotion of an idea, product, or event put up in a public space for mass consumption"))
        models.add(Model(R.drawable.namecard, "Namecard","Business cards are cards bearing business information about a company or individual"))

        var color_temp = arrayOf(resources.getColor(R.color.color1),
            resources.getColor(R.color.color2),resources.getColor(R.color.color3),resources.getColor(R.color.color4))
        colors = color_temp

        var adapter = Adapter(models, this)
        viewPager.adapter = adapter
        viewPager.setPadding(130, 0, 130, 0)
        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                if (position < adapter.count - 1 && position < colors?.size?.minus(1) ?: 0) {
                    viewPager.setBackgroundColor(argbEvaluator.evaluate(positionOffset,
                        colors?.get(position), colors?.get(position + 1)
                    ) as Int)
                } else {
                    colors?.get(colors!!.size - 1)?.let { viewPager.setBackgroundColor(it) }
                }
            }

            override fun onPageSelected(position: Int) {
            }

        })
    }
}

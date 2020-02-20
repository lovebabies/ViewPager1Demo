package com.example.android.viewpager1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import kotlinx.android.synthetic.main.item.view.*

/**
 * Author: Jayden Nguyen
 * Created date: 2/20/2020
 */
class Adapter(var models: List<Model>, var context: Context): PagerAdapter() {

    lateinit var layoutInflater: LayoutInflater


    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view.equals(`object`)
    }

    override fun getCount(): Int {
        return models.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater = LayoutInflater.from(context)
        val view = layoutInflater.inflate(R.layout.item, container, false)
        view.image.setImageResource(models[position].image)
        view.title.text = models[position].title
        view.desc.text = models[position].desc

        container.addView(view, 0)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

}
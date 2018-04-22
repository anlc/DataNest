package com.data.nest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.Toolbar
import android.view.Gravity
import cn.carbs.android.avatarimageview.library.AvatarImageView
import com.data.nest.fragment.BaseFragment
import com.data.nest.fragment.FictionFragment
import com.data.nest.fragment.MusicFragment
import com.data.nest.utils.bindView
import com.data.nest.utils.toast
import kotlinx.android.synthetic.main.item_head_menu.*

class MainActivity : AppCompatActivity() {

    private lateinit var homeHeadImg: AvatarImageView
    private val leftLayout: NavigationView by bindView(R.id.home_left_layout)
    private val drawerLayout: DrawerLayout by bindView(R.id.home_layout)
    private val toolBar: Toolbar by bindView(R.id.home_tool_bar)

    private var fictionFragment: FictionFragment? = null
    private var musicFragment: MusicFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        homeHeadImg = leftLayout.getHeaderView(0).findViewById(R.id.home_head_img)
        homeHeadImg.setTextAndColorSeed("A", "anlc")

        setSupportActionBar(toolBar)
        supportActionBar!!.setHomeButtonEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        setContentFragmentView(R.id.home_fiction)
        leftLayout.setItemBackgroundResource(R.drawable.selector_menu_item)
        leftLayout.setCheckedItem(R.id.home_fiction)
        leftLayout.setNavigationItemSelectedListener(NavigationView.OnNavigationItemSelectedListener { item ->
            drawerLayout.closeDrawer(Gravity.LEFT)
            leftLayout.setCheckedItem(item.itemId)
            setContentFragmentView(item.itemId)
            false
        })

        val toogle = ActionBarDrawerToggle(this, drawerLayout, toolBar, 0, 0)
        toogle.syncState()
        drawerLayout.addDrawerListener(toogle)
    }

    private fun setContentFragmentView(menuId: Int) {
        var fragment: BaseFragment? = null
        when (menuId) {
            R.id.home_cross_talk -> {//段子
                toast("没写呢，别点啦")
                return
            }
            R.id.home_fiction -> {//小说
                if (null == fictionFragment)
                    fictionFragment = FictionFragment()
                fragment = fictionFragment as FictionFragment
            }
            R.id.home_music -> {//音乐
                if (null == musicFragment)
                    musicFragment = MusicFragment()
                fragment = musicFragment as MusicFragment
            }
            R.id.home_video -> {//视频
                toast("没写呢，别点啦")
                return
            }
            R.id.home_setting -> {//设置
                toast("没写呢，别点啦")
                return
            }
        }
        supportFragmentManager.beginTransaction().replace(R.id.content_view, fragment).commit()
    }
}

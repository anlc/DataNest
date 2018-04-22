package com.data.nest.utils

import android.widget.Toast
import com.data.nest.base.CustomApplication

/**
 * Created by n on 2018/4/22.
 */
fun toast(info: String) {
    Toast.makeText(CustomApplication.context, info, Toast.LENGTH_SHORT).show()
}
package com.example.oneclickdriveassignment.utils

import android.text.InputFilter
import android.text.Spanned

class NoConsecutiveCommasInputFilter : InputFilter {
    override fun filter(
        source: CharSequence?,
        start: Int,
        end: Int,
        dest: Spanned?,
        dstart: Int,
        dend: Int
    ): CharSequence? {
        val builder = dest?.let { StringBuilder(it) }
        builder?.replace(dstart, dend, source?.subSequence(start, end).toString())

        // Check if the result will have consecutive commas
        if (builder != null) {
            if (builder.toString().contains(",,") || builder.startsWith(",")) {
                // Return an empty string to prevent the change
                return ""
            }
        }

        return null
    }
}

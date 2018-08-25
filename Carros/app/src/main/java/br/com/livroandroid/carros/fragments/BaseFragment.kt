package br.com.livroandroid.carros.fragments

import android.app.Fragment
import android.content.Context

open class BaseFragment : Fragment() {
    override fun getContext(): Context {
        return super.getContext()!!
    }
}
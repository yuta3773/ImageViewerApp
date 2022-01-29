package com.example.imageviewerapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

//FragmentStateAdapterはviewpager2からのページ要求に対応する
// フラグメントを作成しページとして渡す
class ViewAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
    //画像のリスト
    private val resource = listOf(
        R.drawable.kanoa1,
        R.drawable.kanoa2,
        R.drawable.kanoa3,
        R.drawable.kelly1,
        R.drawable.kelly2,
        R.drawable.kelly3,
    )

    //getItemCountはsizeを使いページの総数を返す
    override fun getItemCount(): Int = resource.size

    //引数にページ番号を受け取り、番号に紐づくフラグメントをインスタンスとして返す
    override fun createFragment(position: Int): Fragment
            = ImageFragment.newInstance(resource[position])
}
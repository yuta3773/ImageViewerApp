package com.example.imageviewerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.imageviewerapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //mainのみで使うので入れ子で作成。
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

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //本来はsetAdapterを使うがadapterプロパティでアクセスできる
        binding.page.adapter = ViewAdapter(this)
    }
}
package com.example.imageviewerapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.imageviewerapp.databinding.FragmentImageBinding


class ImageFragment : Fragment() {

    //argumentsから取り出したものを保持する
    private var imageResId: Int? = null
    private lateinit var binding: FragmentImageBinding

    //フラグメント作成時、再作成時にonCreateが呼ばれる。フラグメントの初期化
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //argumentsでIDをもらう
        arguments?.let {
            //argumentsから取り出したものをimageResIdに保存
            imageResId = it.getInt(IMA_RES_ID)
        }
    }

    //onCreateViewはUIを描画する時に呼ばれる。レイアウト部品を作る
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentImageBinding.inflate(inflater, container, false)
        this.binding = binding
        return binding.root
    }

    //onCreateメソッド完了時の呼び出し
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //imageResIdに保持しておいた画像リソースをimageViewに画像を設定。
        // nullの可能性がある為？とletを使いnull出ない時に画像を表示する。
        imageResId?.let {
            binding.imageView.setImageResource(it)
        }
    }

    companion object {
        //キーの保持。constはクラスに紐ずくもの
        private const val IMA_RES_ID = "IMA_RES_ID"
        //newInstanceは、このフラグメントは必ずどの画像を表示するかをアーギュメンツに保存するもの
        fun newInstance(imageResId: Int) =
            ImageFragment().apply {
                arguments = Bundle().apply {
                    putInt(IMA_RES_ID, imageResId)
                }
            }
    }
}
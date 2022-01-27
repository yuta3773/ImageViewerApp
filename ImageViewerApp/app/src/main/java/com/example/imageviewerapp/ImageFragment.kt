package com.example.imageviewerapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.imageviewerapp.databinding.FragmentImageBinding

//キーの保持
private const val IMA_RES_ID = "IMA_RES_ID"

class ImageFragment : Fragment() {

    //argumentsから取り出したものを保持する
    private var imageResId: Int? = null

    //フラグメント作成時、再作成時にonCreateが呼ばれる。フラグメントの初期化
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //argumentsでIDをもらう
        arguments?.let {
            //argumentsから取り出したものをimageResIdに保存
            imageResId = it.getInt(IMA_RES_ID)
        }
    }

    private var _binding: FragmentImageBinding? = null
    private val binding get() = _binding!!
    //onCreateViewはUIを描画する時に呼ばれる。レイアウト部品を作る
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentImageBinding.inflate(inflater, container, false)
        return binding.root
    }

    //ビューの削除次に呼ばれる。そのまま削除するか、onCreateViewで再作成の２パターン
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        //newInstanceは、このフラグメントは必ずどの画像を表示するかをアーギュメンツに保存するもの
        fun newInstance(imageResId: Int) =
            ImageFragment().apply {
                arguments = Bundle().apply {
                    putInt(IMA_RES_ID, imageResId)
                }
            }
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
}
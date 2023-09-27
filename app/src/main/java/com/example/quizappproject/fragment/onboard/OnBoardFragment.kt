package com.example.quizappproject.fragment.onboard

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.example.quizappproject.R
import com.example.quizappproject.databinding.FragmentOnBoardBinding
import com.example.quizappproject.fragment.ExploreQuizFragment
import com.example.quizappproject.fragment.HoeScreenFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class OnBoardFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardBinding
    @Inject
    lateinit var preferences: Preferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentOnBoardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        arguments.let {
            val data = it?.getSerializable("board") as OnBoardModel
            binding.tvDesc.text = data.text
            data.img?.let { it1 -> binding.img2.setImageResource(it1) }
            data.image?.let { it1 -> binding.img.setImageResource(it1) }


        }
        binding.btnNext.setOnClickListener {
            val fragmentManager = requireFragmentManager()
            fragmentManager.beginTransaction().replace(R.id.fr_container, ExploreQuizFragment())
                .commit()
                 preferences.setShow(true)
        }
    }
}
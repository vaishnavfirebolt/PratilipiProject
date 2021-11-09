package com.vaishnav.pratilipiproject.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.vaishnav.pratilipiproject.R
import com.vaishnav.pratilipiproject.data.model.Content
import com.vaishnav.pratilipiproject.databinding.AddContentBottomsheetBinding
import com.vaishnav.pratilipiproject.ui.main.viewmodel.MainViewModel

class ContentBottomSheet : BottomSheetDialogFragment(), View.OnClickListener {

    private var _binding: AddContentBottomsheetBinding? = null
    private val binding get() = _binding!!
    private lateinit var mainActivityViewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        _binding = AddContentBottomsheetBinding.inflate(layoutInflater)
        val view = binding.root
        initRes()
        return view
    }

    private fun initRes() {

        initViewModel()
        binding.saveButton.setOnClickListener { this }
        binding.addImageButton.setOnClickListener { this }
    }

    private fun initViewModel() {
        mainActivityViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.saveButton -> {
                val tsLong = System.currentTimeMillis() / 1000
                val content = Content(
                    0,
                    binding.etTitle.text.toString(),
                    binding.etText.text.toString(),
                    tsLong
                )

            }
            R.id.addImageButton ->{
                val intent = Intent(Intent.ACTION_PICK)
                intent.type = "image/*"
                startActivityForResult(intent, 1)
            }
        }


    }


}
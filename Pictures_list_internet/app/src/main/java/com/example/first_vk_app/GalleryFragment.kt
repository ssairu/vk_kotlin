package com.example.first_vk_app

import android.content.res.Configuration
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.first_vk_app.databinding.FragmentGalleryBinding

class GalleryFragment : Fragment() {

    companion object {
        fun newInstance() = GalleryFragment()
    }

    private lateinit var binding: FragmentGalleryBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGalleryBinding.inflate(inflater)
        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager: RecyclerView.LayoutManager =
            if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                GridLayoutManager(view.context, resources.getInteger(R.integer.LANDSCAPE_COLS))
            } else {
                GridLayoutManager(view.context, resources.getInteger(R.integer.PORTRAIT_COLS))
            }
        binding.recyclerRectangle.layoutManager = layoutManager
//        var count = resources.getInteger(R.integer.PER_PAGE_ITEMS)
//
//        savedInstanceState?.let { bundle ->
//            count = bundle.getInt("COUNT_RECT")
//        }
        val starterList: MutableList<PictureItem> = mutableListOf(
            PictureItem(0, "name 0", "path 0", "date 0"),
            PictureItem(1, "name 1", "path 1", "date 1"),
            PictureItem(2, "name 2", "path 2", "date 2"),
            PictureItem(3, "name 3", "path 3", "date 3"),
            PictureItem(4, "name 4", "path 4", "date 4"),
        )

        var rvAdapter: RvAdapter = RvAdapter(starterList)
        binding.recyclerRectangle.adapter = rvAdapter
        binding.addButton.setOnClickListener {
            rvAdapter.addRectangle()
        }
    }

}
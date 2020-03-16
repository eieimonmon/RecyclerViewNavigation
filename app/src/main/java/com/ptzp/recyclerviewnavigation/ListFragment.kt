package com.ptzp.recyclerviewnavigation


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ptzp.recyclerviewnavigation.adapter.FlowerAdapter
import com.ptzp.recyclerviewnavigation.model.Flower
import kotlinx.android.synthetic.main.fragment_list.view.*

/**
 * A simple [Fragment] subclass.
 */
class ListFragment : Fragment(), FlowerAdapter.ClickListener {

    override fun onClick(flower: Flower) {
       Toast.makeText(context, "${flower.name}", Toast.LENGTH_LONG).show()

        view?.findNavController()?.navigate(
            R.id.action_listFragment_to_nextFragment
        )
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        var root = inflater.inflate(R.layout.fragment_list, container, false)

        var flowerList = ArrayList<Flower>()
        flowerList.add(Flower("Rose"))
        flowerList.add(Flower("SunFlower"))
        flowerList.add(Flower("Jusmine"))
        flowerList.add(Flower("Lily"))

        var flowerAdapter = FlowerAdapter(flowerList)

        flowerAdapter.setClickListener(this)

        root.recyclerList.layoutManager = LinearLayoutManager(context)
        root.recyclerList.adapter = flowerAdapter
        return root

    }




}

package com.example.appcuota.features.feedetail.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appcuota.R
import com.example.appcuota.databinding.FragmentFeeDetailBinding
import com.example.appcuota.databinding.FragmentLoginBinding
import com.example.appcuota.features.feedetail.domain.model.CuotaByAno
import com.example.appcuota.features.feedetail.presentation.adapter.AdtCuota
import com.example.appcuota.features.login.presentation.LoginViewModel
import com.example.appcuota.utils.DataStoreGlobal.Companion.DOCIDENTIDAD
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FeeDetailFrag : Fragment() {
    private lateinit var viewModel: FeeDetailViewModel
    private var _binding: FragmentFeeDetailBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapterListaCuota: AdtCuota
    private val itemList = mutableListOf<CuotaByAno>()
    private val itemSpinner = mutableListOf<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel =
            activity?.let {
                ViewModelProvider(it)[FeeDetailViewModel::class.java]
            }!!
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle? ): View {
        _binding = FragmentFeeDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initComponent()
        initCompCuote()
        initCompCuoteDetail()
    }


    private fun initComponent() {
        val listano = ArrayList<String>()
        listano.add("Todos")
        itemList.forEach {
            listano.add(it.ano.toString())
        }

        val spFiltroAno = binding.spFiltroAno
        val AdaptadorVendedor = ArrayAdapter(requireActivity(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, listano)
        spFiltroAno.adapter = AdaptadorVendedor

        spFiltroAno.setSelection(0)

        spFiltroAno.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val item: String = parent!!.getItemAtPosition(position).toString()
                binding.btBuscar.setOnClickListener {
                    if(item=="Todos"){
                        viewModel.getAllCuote(DOCIDENTIDAD)
                    }else{
                        viewModel.getCuoteByYear(DOCIDENTIDAD,item)
                    }
                    Toast.makeText(requireActivity(), item + " " + DOCIDENTIDAD, Toast.LENGTH_SHORT).show()
                }

            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }

    private fun initCompCuoteDetail() {
        viewModel.listAllCuote.observe(viewLifecycleOwner){
            adapterListaCuota.setItems(it)
        }
    }

    private fun initCompCuote() {
        binding.rvCunsultaStocks.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        adapterListaCuota = AdtCuota(itemList)
        binding.rvCunsultaStocks.adapter = adapterListaCuota
    }

}
package com.owlcode.appcuota.features.feedetail.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.owlcode.appcuota.databinding.FragmentFeeDetailBinding
import com.owlcode.appcuota.features.feedetail.domain.model.CuotaByAno
import com.owlcode.appcuota.features.feedetail.presentation.adapter.AdtCuota
import com.owlcode.appcuota.utils.DataStoreGlobal.Companion.DOCIDENTIDAD
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FeeDetailFrag : Fragment() {
    private lateinit var viewModel: FeeDetailViewModel
    private var _binding: FragmentFeeDetailBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapterListaCuota: AdtCuota
    private val itemList = mutableListOf<CuotaByAno>()
    private var listano = ArrayList<String>()

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

        initDataCuote()
        initComponentSpinner()
        initCompCuoteRecyclerview()
        initCompCuoteDetail()
    }

    private fun initDataCuote() {
        viewModel.getAllCuote(DOCIDENTIDAD)
    }

    private fun initComponentSpinner() {
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
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }

    private fun initCompCuoteDetail() {
        viewModel.listAllCuote.observe(viewLifecycleOwner){
            it.forEach {listano.add(it.ano.toString())}
            adapterListaCuota.setItems(it)
        }
    }

    private fun initCompCuoteRecyclerview() {
        binding.rvCunsultaStocks.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        adapterListaCuota = AdtCuota(itemList)
        binding.rvCunsultaStocks.adapter = adapterListaCuota
    }

}
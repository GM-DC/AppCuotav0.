package com.example.appcuota.features.feedetail.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appcuota.features.feedetail.domain.model.CuotaByAno
import com.example.appcuota.features.feedetail.domain.usecase.GetAllQuoteUseCase
import com.example.appcuota.features.feedetail.domain.usecase.GetQuoteByYearUseCase
import com.example.appcuota.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FeeDetailViewModel @Inject constructor(
    private val getAllQuoteUseCase : GetAllQuoteUseCase,
    private val getQuoteByYearUseCase: GetQuoteByYearUseCase
) : ViewModel() {

    private val _message : MutableLiveData<String> = MutableLiveData()
    var message: LiveData<String> = _message

    private val _isLoading = MutableLiveData<Boolean>()
    var isLoading: LiveData<Boolean> = _isLoading

    private val _listAllCuote: MutableLiveData<MutableList<CuotaByAno>> = MutableLiveData()
    var listAllCuote: LiveData<MutableList<CuotaByAno>> = _listAllCuote

    fun getAllCuote(ruc:String){
        viewModelScope.launch {
            getAllQuoteUseCase(ruc).onEach{ result ->
                when (result) {
                    is NetworkResult.Success -> {
                        _listAllCuote.value = result.data!!.toMutableList()
                        _isLoading.value = false
                    }
                    is NetworkResult.Error -> {
                        _message.value = result.message!!
                        _isLoading.value = false
                    }
                    is NetworkResult.Loading -> {
                        _isLoading.value = true
                    }
                }
            }.launchIn(this)
        }
    }

    fun getCuoteByYear(ruc:String,ano:String){
        viewModelScope.launch {
            getQuoteByYearUseCase(ruc,ano).onEach{ result ->
                when (result) {
                    is NetworkResult.Success -> {
                        _listAllCuote.value = result.data!!.toMutableList()
                        _isLoading.value = false
                    }
                    is NetworkResult.Error -> {
                        _message.value = result.message!!
                        _isLoading.value = false
                    }
                    is NetworkResult.Loading -> {
                        _isLoading.value = true
                    }
                }
            }.launchIn(this)
        }
    }




}
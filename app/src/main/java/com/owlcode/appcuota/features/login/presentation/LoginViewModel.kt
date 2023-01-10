package com.owlcode.appcuota.features.login.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.owlcode.appcuota.features.datastoreglobal.domain.usecase.SaveDataStoreUseCase
import com.owlcode.appcuota.features.datastoreglobal.domain.model.DataStoreModel
import com.owlcode.appcuota.features.datastoreglobal.domain.usecase.GetDataStoreUseCase
import com.owlcode.appcuota.features.datastoreglobal.domain.usecase.GetDataStoreUseCase_Factory
import com.owlcode.appcuota.features.login.domain.model.*
import com.owlcode.appcuota.features.login.domain.usecase.*
import com.owlcode.appcuota.features.updatepassword.domain.usecase.PostSendCodeUseCase
import com.owlcode.appcuota.features.updatepassword.domain.usecase.PostValidateCodeUseCase
import com.owlcode.appcuota.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val postLoginUserUseCase : PostLoginUserUseCase,
    private val saveDataStoreUseCase: SaveDataStoreUseCase,
    private val getDataStoreUseCase: GetDataStoreUseCase
) : ViewModel()  {

    private val _message : MutableLiveData<String> = MutableLiveData()
    var message: LiveData<String> = _message

    private val _loginResult: MutableLiveData<LoginResponse> = MutableLiveData()
    var loginResult: LiveData<LoginResponse> = _loginResult

    private val _isStateValidateCode = MutableLiveData<Boolean>()
    var isStateValidateCode: LiveData<Boolean> = _isStateValidateCode

    private val _dataStore = MutableLiveData<DataStoreModel>()
    var dataStore: LiveData<DataStoreModel> = _dataStore

    private val _isLoading = MutableLiveData<Boolean>()
    var isLoading: LiveData<Boolean> = _isLoading

    init {
        getDataSore()
    }

    fun loginUser(usuario: String, passwords: String) {
        viewModelScope.launch {
            val loginRequest = Login(dni = usuario, password = passwords)
            postLoginUserUseCase(loginRequest).also { result ->
                when (result) {
                    is NetworkResult.Success -> {
                        _loginResult.value = result.data!!
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
            }
        }
    }

    fun saveDataStore(docidentidad: String, nameUser: String){
        val data = DataStoreModel(nameUser,docidentidad)
        viewModelScope.launch {
            saveDataStoreUseCase(data)
        }
    }

    fun getDataSore(){
        viewModelScope.launch {
            getDataStoreUseCase().collect {
                _dataStore.value = it
            }
        }
    }



}
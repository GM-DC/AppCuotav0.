package com.example.appcuota.features.updatepassword.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appcuota.features.updatepassword.domain.model.DocIdentidad
import com.example.appcuota.features.login.domain.model.LoginResponse
import com.example.appcuota.features.updatepassword.domain.model.UpdatePassword
import com.example.appcuota.features.updatepassword.domain.model.ValidateCode
import com.example.appcuota.features.updatepassword.domain.usecase.PostSendCodeUseCase
import com.example.appcuota.features.updatepassword.domain.usecase.PostValidateCodeUseCase
import com.example.appcuota.features.updatepassword.domain.usecase.UpdatePasswordUseCase
import com.example.appcuota.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UpdatePasswordViewModel @Inject constructor(
    private val updatePasswordUseCase : UpdatePasswordUseCase,
    private val postSendCodeUseCase: PostSendCodeUseCase,
    private val postValidateCodeUseCase: PostValidateCodeUseCase
) : ViewModel()  {

    private val _message : MutableLiveData<String> = MutableLiveData()
    var message: LiveData<String> = _message

    private val _isLoading = MutableLiveData<Boolean>()
    var isLoading: LiveData<Boolean> = _isLoading

    private val _loginResult: MutableLiveData<Boolean> = MutableLiveData()
    var loginResult: LiveData<Boolean> = _loginResult

    private val _isStateValidateCode = MutableLiveData<Boolean>()
    var isStateValidateCode: LiveData<Boolean> = _isStateValidateCode

    private val _loginResultLogin: MutableLiveData<LoginResponse> = MutableLiveData()
    var loginResultLogin: LiveData<LoginResponse> = _loginResultLogin

    fun updatePassword(newPassword:String,docIdentidad:String){
        viewModelScope.launch {
            val docidentidad = UpdatePassword(newPassword, docIdentidad)
            updatePasswordUseCase(docidentidad).also { result ->
                when (result) {
                    is NetworkResult.Success -> {
                        _loginResult.value = result.data!!
                    }
                    is NetworkResult.Error -> {
                        _loginResult.value = result.data!!
                        _message.value = result.message!!
                    }
                    is NetworkResult.Loading -> {
                        _loginResult.value = result.data!!
                        _message.value = result.message!!
                    }
                }
            }
        }
    }

    fun sendCode(docidentidad:String){
        viewModelScope.launch {
            val docIdentidad = DocIdentidad(docidentidad)
            postSendCodeUseCase(docIdentidad).also { result ->
                when (result) {
                    is NetworkResult.Success -> {
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

    fun valideCode(docidentidad:String,code:String){
        viewModelScope.launch {
            val datoValidateCode = ValidateCode(code,docidentidad)
            postValidateCodeUseCase(datoValidateCode).also { result ->
                when (result) {
                    is NetworkResult.Success -> {
                        _isStateValidateCode.value = result.data!!
                        _isLoading.value = false
                    }
                    is NetworkResult.Error -> {
                        _isStateValidateCode.value = result.data!!
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

}
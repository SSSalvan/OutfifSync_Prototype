package com.example.outfitsync.ui.theme.login

class LoginViewModel : ViewModel() {
    // LiveData untuk memberitahu View jika login berhasil
    private val _loginSuccess = MutableLiveData<Boolean>()
    val loginSuccess: LiveData<Boolean> get() = _loginSuccess

    fun onLoginClicked(email: String, pass: String) {
        // Di sini seharusnya ada logika validasi dan login
        // Untuk contoh, kita anggap langsung berhasil
        if (email.isNotEmpty() && pass.isNotEmpty()) {
            _loginSuccess.value = true
        }
    }
}
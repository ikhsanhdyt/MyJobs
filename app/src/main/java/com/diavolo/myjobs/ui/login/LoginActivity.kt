package com.diavolo.myjobs.ui.login

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.diavolo.myjobs.base.arch.BaseActivity
import com.diavolo.myjobs.base.model.Resource
import com.diavolo.myjobs.databinding.ActivityLoginBinding
import com.diavolo.myjobs.ui.home.HomeActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>(
    ActivityLoginBinding::inflate
), LoginContract.View {
    @Inject
    lateinit var googleSignInClient: GoogleSignInClient
    private lateinit var googleSignInActivityLauncher: ActivityResultLauncher<Intent>

    override fun initView() {
        setupToolbar()
        registerActivityResult()
        setBindingClickListeners()
    }

    private fun setBindingClickListeners() {
        getViewBinding().btnSignInGoogle.setOnClickListener {
            val googleSignInIntent = googleSignInClient.signInIntent
            googleSignInActivityLauncher.launch(googleSignInIntent)

        }
    }

    private fun registerActivityResult() {
        googleSignInActivityLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                try {
                    val task = GoogleSignIn.getSignedInAccountFromIntent(it.data)
                    if (task.isSuccessful) {
                        val account = task.result
                        val idToken = account?.idToken
                        val email = account?.email
                        // do login operation here
                        if (idToken != null) {
                            getViewModel().signInGoogle(idToken, email ?: "")
                        } else {
                            Timber.tag(TAG).e("Google Sign-In failed")
                        }
                    } else {
                        Timber.tag(TAG).e("Google Sign-In failed")

                    }
                } catch (e: Exception) {
                    Timber.tag(TAG).e("Google Sign-In failed: ${e.message}")
                }

            }
    }

    override fun observeData(){
        getViewModel().getUserLiveData().observe(this){
            when(it){
                is Resource.Loading -> {
                    showContent(false)
                    showLoading(true)
                }
                is Resource.Success -> {
                    HomeActivity.startActivity(this)
                }
                is Resource.Error -> {
                    showContent(false)
                    showLoading(false)
                }
            }
        }
    }

    override fun showContent(isVisible: Boolean) {
    }

    override fun showLoading(isVisible: Boolean) {
    }

    override fun showError(isErrorEnabled: Boolean, msg: String?) {

    }

    private fun setupToolbar() {
//        setSupportActionBar(getViewBinding().toolbar)
//        supportActionBar?.title = getString(R.string.choose_genre)
    }

    private fun toast(message: String) {
        Toast.makeText(application, message, Toast.LENGTH_SHORT).show()
    }

    companion object {
        private const val TAG = "LoginActivity"

        @JvmStatic
        fun startActivity(context: Context?) {
            val intent = Intent(context, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            context?.startActivity(intent)
        }
    }
}
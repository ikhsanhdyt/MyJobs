package com.diavolo.myjobs.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.diavolo.myjobs.R
import com.diavolo.myjobs.base.arch.BaseActivity
import com.diavolo.myjobs.base.arch.BaseContract
import com.diavolo.myjobs.databinding.ActivityHomeBinding
import com.diavolo.myjobs.ui.account.AccountFragment
import com.diavolo.myjobs.ui.jobList.JobListFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : BaseActivity<ActivityHomeBinding,HomeViewModel>(ActivityHomeBinding::inflate),
BaseContract.BaseView{

    private val jobListFragment = JobListFragment()
    private val accountFragment = AccountFragment()
    private var activeFragment: Fragment = jobListFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupFragment()
    }

    override fun initView() {
    }

    private fun setupFragment() {
        // delete all fragment in fragment manager first
        for (fragment in supportFragmentManager.fragments) {
            supportFragmentManager.beginTransaction().remove(fragment).commit()
        }
        // add fragment to fragment manager
        supportFragmentManager.beginTransaction().apply {
            add(getViewBinding().container.id, jobListFragment)
            add(getViewBinding().container.id, accountFragment)
            hide(accountFragment)
        }.commit()
        // set click menu for changing fragment
        getViewBinding().bottomNavView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    showFragment(jobListFragment)
                    true
                }
                R.id.account -> {
                    showFragment(accountFragment)
                    true
                }
                else->{
                    false
                }
            }
        }
    }

    private fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .hide(activeFragment)
            .show(fragment)
            .commit()
        activeFragment = fragment
    }

    companion object {
        @JvmStatic
        fun startActivity(context: Context?) {
            val intent = Intent(context, HomeActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            context?.startActivity(intent)
        }
    }
}
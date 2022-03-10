package ru.sscalliance.ui.main.view

import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import dagger.hilt.android.AndroidEntryPoint
import ru.sscalliance.R
import ru.sscalliance.databinding.ActivityMainBinding
import ru.sscalliance.ui.base.view.BaseActivity
import ru.sscalliance.ui.base.view.IMvpView

interface IMainActivity : IMvpView {

}

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(), IMainActivity {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_info_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_news,
                R.id.navigation_sport,
                R.id.navigation_sportclub,
                R.id.navigation_team
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.navInfoView.setupWithNavController(navController)
    }
}

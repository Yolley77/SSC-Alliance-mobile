package ru.sscalliance.ui.sportClub.presentation.view

import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import ru.sscalliance.databinding.FragmentSportClubBinding
import ru.sscalliance.domain.sportClub.interactor.ISportClubInteractor
import ru.sscalliance.domain.sportClub.model.SportClubBusinessModel
import ru.sscalliance.ui.base.view.BaseFragment
import ru.sscalliance.ui.base.view.IView
import ru.sscalliance.ui.sportClub.presentation.presenter.SportClubPresenter
import javax.inject.Inject

interface ISportClubFragment: IView {
    fun getSportClub(items: List<SportClubBusinessModel>)
}

@AndroidEntryPoint
class SportClubFragment : BaseFragment<FragmentSportClubBinding>(), ISportClubFragment {

    @Inject
    lateinit var presenter: SportClubPresenter<ISportClubFragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = FragmentSportClubBinding.inflate(layoutInflater)
        presenter.onAttach(this)
    }

    override fun onDestroyView() {
        presenter.onDetach()
        super.onDestroyView()
    }

    override fun getSportClub(items: List<SportClubBusinessModel>) {
        TODO("Not yet implemented")
    }
}


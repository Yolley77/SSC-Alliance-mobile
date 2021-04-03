package ru.sscalliance.ui.sport.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import ru.sscalliance.R
import ru.sscalliance.databinding.FragmentSportBinding
import ru.sscalliance.domain.sport.interactor.ISportInteractor
import ru.sscalliance.domain.sport.model.EventBusinessModel
import ru.sscalliance.domain.sport.model.SectionBusinessModel
import ru.sscalliance.ui.base.view.BaseActivity
import ru.sscalliance.ui.base.view.BaseFragment
import ru.sscalliance.ui.base.view.IMvpView
import ru.sscalliance.ui.sport.presentation.adapter.EventAdapter
import ru.sscalliance.ui.sport.presentation.adapter.SectionAdapter
import ru.sscalliance.ui.sport.presentation.presenter.SportPresenter
import javax.inject.Inject

interface ISportFragment : IMvpView {
    fun showSections(items: List<SectionBusinessModel>)
    fun showEvents(items: List<EventBusinessModel>)
    fun openMainSectionsScreen()
}

@AndroidEntryPoint
class SportFragment : BaseFragment(R.layout.fragment_sport), ISportFragment {

    @Inject
    lateinit var presenter: SportPresenter<ISportFragment, ISportInteractor>

    private lateinit var binding: FragmentSportBinding
    private var sectionAdapter: SectionAdapter? = null
    private var eventAdapter: EventAdapter<EventBusinessModel>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.bindView(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSportBinding.inflate(inflater, container, false)
        // to work with binding - must return binding.root in onCreate/onCreateView
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRVs()
    }

    override fun onDestroyView() {
        presenter.unbindView()
        super.onDestroyView()
    }

    override fun showSections(items: List<SectionBusinessModel>) {
        sectionAdapter?.updateAdapter(items)
    }

    override fun showEvents(items: List<EventBusinessModel>) {
        eventAdapter?.updateAdapter(items)
    }

    override fun openMainSectionsScreen() {
        val parent = activity as BaseActivity
        parent.navigator.openMainSectionScreen()
    }

    private fun setUpRVs() {
        sectionAdapter = SectionAdapter(presenter::onSectionClicked)
        binding.listSections.apply {
            adapter = sectionAdapter
            layoutManager = GridLayoutManager(
                context,
                2,
                LinearLayoutManager.VERTICAL,
                false
            )
        }
        presenter.getSections()

        eventAdapter = EventAdapter()
        binding.listEvents.apply {
            adapter = eventAdapter
            layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.HORIZONTAL,
                false
            )
        }
        presenter.getEvents()
    }

}




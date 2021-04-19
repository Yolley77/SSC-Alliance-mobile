package ru.sscalliance.ui.sport.main.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewbinding.ViewBinding
import dagger.hilt.android.AndroidEntryPoint
import ru.sscalliance.R
import ru.sscalliance.databinding.FragmentSportBinding
import ru.sscalliance.domain.sport.main.interactor.ISportInteractor
import ru.sscalliance.domain.sport.main.model.EventBusinessModel
import ru.sscalliance.domain.sport.main.model.SectionPreviewBusinessModel
import ru.sscalliance.ui.base.view.BaseActivity
import ru.sscalliance.ui.base.view.BaseFragment
import ru.sscalliance.ui.base.view.IMvpView
import ru.sscalliance.ui.sport.main.presentation.adapter.EventAdapter
import ru.sscalliance.ui.sport.main.presentation.adapter.SectionAdapter
import ru.sscalliance.ui.sport.main.presentation.presenter.SportPresenter
import javax.inject.Inject

interface ISportFragment : IMvpView {
    fun showSections(items: List<SectionPreviewBusinessModel>)
    fun showEvents(items: List<EventBusinessModel>)
    fun openMainSectionsScreen()
    fun openEventDetailsScreen(item: EventBusinessModel)
}

@AndroidEntryPoint
class SportFragment : BaseFragment<FragmentSportBinding>(), ISportFragment {

    @Inject
    lateinit var presenter: SportPresenter<ISportFragment, ISportInteractor>

    private var sectionAdapter: SectionAdapter? = null
    private var eventAdapter: EventAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.onAttach(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSportBinding.inflate(inflater, container, false)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRVs()
    }

    override fun onDestroyView() {
        presenter.onDetach()
        super.onDestroyView()
    }

    override fun showSections(items: List<SectionPreviewBusinessModel>) {
        sectionAdapter?.updateAdapter(items)
    }

    override fun showEvents(items: List<EventBusinessModel>) {
        eventAdapter?.updateAdapter(items)
    }

    override fun openMainSectionsScreen() {
        val parent = activity as BaseActivity<*>
        parent.navigator.openMainSectionScreen()
    }

    override fun openEventDetailsScreen(item: EventBusinessModel) {
        val parent = activity as BaseActivity<*>
        parent.navigator.openEventDetailsScreen(item)
    }

    private fun setUpRVs() {
        sectionAdapter = SectionAdapter(presenter::onSectionClicked)
        binding?.listSections?.apply {
            adapter = sectionAdapter
            layoutManager = GridLayoutManager(
                context,
                2,
                LinearLayoutManager.VERTICAL,
                false
            )
        }
        presenter.getSections()

        eventAdapter = EventAdapter(presenter::onEventClicked)
        binding?.listEvents?.apply {
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




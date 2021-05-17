package ru.sscalliance.ui.sport.mainScreen.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import ru.sscalliance.databinding.FragmentSportBinding
import ru.sscalliance.domain.sport.mainScreen.interactor.ISportInteractor
import ru.sscalliance.domain.sport.mainScreen.model.EventBusinessModel
import ru.sscalliance.domain.sport.mainScreen.model.SectionPreviewBusinessModel
import ru.sscalliance.ui.base.view.BaseActivity
import ru.sscalliance.ui.base.view.BaseFragment
import ru.sscalliance.ui.base.view.IMvpView
import ru.sscalliance.ui.sport.mainScreen.presentation.adapter.EventAdapter
import ru.sscalliance.ui.sport.mainScreen.presentation.adapter.SectionPreviewAdapter
import ru.sscalliance.ui.sport.mainScreen.presentation.presenter.SportPresenter
import javax.inject.Inject

interface ISportFragment : IMvpView {
    fun showSections(items: List<SectionPreviewBusinessModel>)
    fun showEvents(items: List<EventBusinessModel>)

    // by eventBus
    fun openMainSectionsScreen()

    // by extras
    fun openEventDetailsScreen(item: EventBusinessModel)
}

@AndroidEntryPoint
class SportFragment : BaseFragment<FragmentSportBinding>(), ISportFragment {

    @Inject
    lateinit var presenter: SportPresenter<ISportFragment, ISportInteractor>

    private var sectionAdapter: SectionPreviewAdapter? = null
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
        sectionAdapter = SectionPreviewAdapter(presenter::onSectionClicked, context)
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




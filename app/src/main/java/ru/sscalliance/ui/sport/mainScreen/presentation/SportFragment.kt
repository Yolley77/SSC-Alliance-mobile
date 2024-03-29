package ru.sscalliance.ui.sport.mainScreen.presentation

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import ru.sscalliance.databinding.FragmentSportBinding
import ru.sscalliance.domain.sport.mainScreen.model.EventBusinessModel
import ru.sscalliance.domain.sport.mainScreen.model.SectionPreviewBusinessModel
import ru.sscalliance.ui.base.view.BaseActivity
import ru.sscalliance.ui.base.view.BaseFragment
import ru.sscalliance.ui.base.view.IView
import ru.sscalliance.ui.sport.mainScreen.v2.compose.EventsView
import javax.inject.Inject

interface ISportFragment : IView {
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
    lateinit var presenter: SportPresenter<ISportFragment>

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
        viewBinding = FragmentSportBinding.inflate(inflater, container, false)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRVs()

        viewBinding?.tvShowAll?.setOnClickListener {
            startActivity(
                Intent(this.context, EventsView::class.java)
            )
        }

        viewBinding?.btnFindPlayer?.setOnClickListener {
            presenter.toastsHandler.showMessage("Выполнено действие: Поиск игроков")
        }
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
        viewBinding?.rvSections?.apply {
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
        viewBinding?.rvEvents?.apply {
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




package ru.sscalliance.ui.sport.sectionScreen.certain.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import ru.sscalliance.databinding.FragmentSectionBinding
import ru.sscalliance.domain.news.model.NewsBusinessModel
import ru.sscalliance.domain.sport.sectionScreen.certain.interactor.ISectionInteractor
import ru.sscalliance.domain.sport.sectionScreen.model.SectionBusinessModel
import ru.sscalliance.domain.sport.sectionScreen.model.SectionType
import ru.sscalliance.ui.base.view.BaseActivity
import ru.sscalliance.ui.base.view.BaseFragment
import ru.sscalliance.ui.base.view.IMvpView
import ru.sscalliance.ui.news.main.presentation.NewsAdapter
import ru.sscalliance.utils.SectionUtils
import javax.inject.Inject

interface ISectionFragment : IMvpView {
    fun setInfo(sectionInfo: SectionBusinessModel)

    // [Organizers Region]
    fun setOrganizersInfo(list: List<NewsBusinessModel>)
    fun openOrganizerDetailsScreen(item: NewsBusinessModel)

    // [Photo Region]
    fun setPhotosInfo(list: List<NewsBusinessModel>)
    fun openPhotoDetailsScreen(item: NewsBusinessModel)

    // [News Region]
    fun setNewsInfo(list: List<NewsBusinessModel>)
    fun openNewsDetailsScreen(item: NewsBusinessModel)
}

@AndroidEntryPoint
class SectionFragment(private val sectionType: SectionType) :
    BaseFragment<FragmentSectionBinding>(), ISectionFragment {

    @Inject
    lateinit var presenter: SectionPresenter<ISectionFragment, ISectionInteractor>

    //private var organizersAdapter: NewsAdapter? = null
    //private var photosAdapter: NewsAdapter? = null
    private var newsAdapter: NewsAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.onAttach(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSectionBinding.inflate(inflater, container, false)
        presenter.configureViews(sectionType)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupNewsRv()
        binding?.sectionRegistration?.setOnClickListener { presenter.onRegisterButtonClicked() }
        binding?.tvSectionNews?.setOnClickListener {
            // TODO: maybe open news screen?
        }

        binding?.sectionRegistration?.setOnClickListener {
            presenter.toastsHandler.showMessage("Выполнено действие: Вступление в секцию")
        }
    }

    override fun onDestroyView() {
        presenter.onDetach()
        super.onDestroyView()
    }

    override fun setInfo(sectionInfo: SectionBusinessModel) {
        binding?.sectionTitle?.text = sectionInfo.title
        binding?.sectionDescription?.text = sectionInfo.description
        binding?.sectionLogo?.background = SectionUtils.getSectionLogoByType(sectionType, context)
    }

    override fun setOrganizersInfo(list: List<NewsBusinessModel>) {
        TODO("Not yet implemented")
    }

    override fun openOrganizerDetailsScreen(item: NewsBusinessModel) {
        val parent = activity as BaseActivity<*>
        //parent.navigator.openNewsDetailsScreen(item)
    }

    override fun setPhotosInfo(list: List<NewsBusinessModel>) {
        TODO("Not yet implemented")
    }

    override fun openPhotoDetailsScreen(item: NewsBusinessModel) {
        val parent = activity as BaseActivity<*>
        //parent.navigator.openNewsDetailsScreen(item)
    }

    override fun setNewsInfo(list: List<NewsBusinessModel>) {
        newsAdapter?.updateAdapter(list)
    }

    override fun openNewsDetailsScreen(item: NewsBusinessModel) {
        val parent = activity as BaseActivity<*>
        parent.navigator.openNewsDetailsScreen(item)
    }

    private fun setupNewsRv() {
        newsAdapter = NewsAdapter(presenter::onNewsItemClicked)
        binding?.sectionNews?.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }
        presenter.getSectionNews()
    }

}
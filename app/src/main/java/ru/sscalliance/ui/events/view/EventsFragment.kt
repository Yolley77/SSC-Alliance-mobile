package ru.sscalliance.ui.events.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import ru.sscalliance.R
import ru.sscalliance.databinding.FragmentEventsBinding
import ru.sscalliance.ui.events.presenter.NotificationsViewModel

class EventsFragment : Fragment() {

    private lateinit var notificationsViewModel: NotificationsViewModel

    private lateinit var binding: FragmentEventsBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        notificationsViewModel =
                ViewModelProvider(this).get(NotificationsViewModel::class.java)

        binding = FragmentEventsBinding.inflate(inflater, container, false)
        val view = binding.root
        //val root = inflater.inflate(R.layout.fragment_events, container, false)
        //val textView: TextView = root.findViewById(R.id.text_notifications)
        notificationsViewModel.text.observe(viewLifecycleOwner, Observer {
            //textView.text = it
            binding.textNotifications.text = it
        })
        return view
    }
}
package com.daniel.tvshowssample.schedule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.daniel.tvshowssample.ui.theme.TvShowsSampleTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TvShowsScheduleFragment : Fragment() {

    private val viewModel by viewModels<TvShowsScheduleViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                TvShowsSampleTheme {
                    val state = viewModel.state.value
                    TvShowsScheduleScreen(state = state)
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.getTvShowsSchedule()
    }
}
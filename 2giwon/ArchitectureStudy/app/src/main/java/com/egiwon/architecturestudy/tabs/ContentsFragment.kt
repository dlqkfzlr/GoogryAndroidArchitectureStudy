package com.egiwon.architecturestudy.tabs

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.egiwon.architecturestudy.R
import com.egiwon.architecturestudy.base.BaseFragment
import com.egiwon.architecturestudy.data.Content
import com.egiwon.architecturestudy.data.source.NaverDataRepository
import com.egiwon.architecturestudy.data.source.remote.NaverRemoteDataSource
import kotlinx.android.synthetic.main.fg_contents.*

class ContentsFragment : BaseFragment(
    R.layout.fg_contents
), ContentsContract.View {

    override val presenter: ContentsContract.Presenter =
        ContentsPresenter(
            this,
            NaverDataRepository(NaverRemoteDataSource())
        )


    private val type: Tab by lazy {
        arguments?.get(ARG_TYPE) as? Tab
            ?: throw IllegalArgumentException()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        with(rv_contents) {
            addItemDecoration(
                DividerItemDecoration(
                    context,
                    DividerItemDecoration.VERTICAL
                )
            )

            setAdapter()
        }

        btn_search.setOnClickListener {
            context?.let {
                requestSearch()
            }
        }
    }

    private fun RecyclerView.setAdapter() {
        try {
            adapter = ContentsAdapter(type)
            setHasFixedSize(true)
        } catch (ignore: Exception) {
        }
    }


    override fun onUpdateUi(content: List<Content.Item>) {
        (rv_contents.adapter as? ContentsAdapter)?.setList(content)
        progress_circular.visibility = View.GONE

    }

    override fun onFail(throwable: Throwable) {
        showToast(getString(R.string.callback_fail))
        progress_circular.visibility = View.GONE
    }

    private fun requestSearch() {
        presenter.loadContents(
            type.toString(),
            et_search.text.toString()
        )

        progress_circular.visibility = View.VISIBLE
    }

    companion object {
        private const val ARG_TYPE = "type"

        fun newInstance(type: Tab) =
            ContentsFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_TYPE, type)
                }
            }

    }
}
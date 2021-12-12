package id.ac.remotejob.fragment

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.ac.remotejob.MainActivity
import id.ac.remotejob.R
import id.ac.remotejob.adapters.RemoteJobAdapter
import id.ac.remotejob.databinding.FragmentRemoteJobBinding
import id.ac.remotejob.viewmodel.RemoteJobViewModel

class RemoteJobFragment : Fragment(R.layout.fragment_remote_job) {

    private var _binding: FragmentRemoteJobBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: RemoteJobViewModel
    private lateinit var remoteJobAdapter: RemoteJobAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentRemoteJobBinding.inflate(
            inflater, container, false
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = (activity as MainActivity).viewModel

        setUpRecyclerView()
    }

    private fun setUpRecyclerView(){
        remoteJobAdapter = RemoteJobAdapter()

        binding.rvRemotejob.apply {
            layoutManager = LinearLayoutManager(activity)
            setHasFixedSize(true)
            addItemDecoration(
                object : DividerItemDecoration(
                    activity, LinearLayout.VERTICAL
                ) {})
            adapter = remoteJobAdapter

        }

        fetchingData()
    }

    private fun fetchingData() {
        viewModel.remoteJobResult().observe(viewLifecycleOwner, {remoteJob ->
            if (remoteJob!= null){
                remoteJobAdapter.differ.submitList(remoteJob.jobs)
            }
        })

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
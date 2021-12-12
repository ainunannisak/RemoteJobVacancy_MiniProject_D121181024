package id.ac.remotejob.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.navigation.fragment.navArgs
import id.ac.remotejob.R
import id.ac.remotejob.databinding.FragmentJobDetailsViewsBinding
import id.ac.remotejob.models.Job


class JobDetailsViewsFragment : Fragment(R.layout.fragment_job_details_views) {

    private var _binding: FragmentJobDetailsViewsBinding? = null
    private val binding get() = _binding!!
    private  val args: JobDetailsViewsFragmentArgs by navArgs()
    private lateinit var  currentJob: Job


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentJobDetailsViewsBinding.inflate(
            inflater, container, false
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        currentJob = args.job!!

        setUpWebView()
    }

    private fun setUpWebView(){
        binding.webView.apply {
            webViewClient = WebViewClient()
            currentJob.url?.let { loadUrl(it) }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}
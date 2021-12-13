package id.ac.remotejob.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebViewClient
import androidx.navigation.fragment.navArgs
import id.ac.remotejob.R
import id.ac.remotejob.databinding.FragmentJobDetailsViewsBinding
import id.ac.remotejob.models.Job


class JobDetailsViewsFragment : Fragment(R.layout.fragment_job_details_views) {

    private var _binding: FragmentJobDetailsViewsBinding? = null
    private val binding get() = _binding!!
    private val args: JobDetailsViewsFragmentArgs by navArgs()
    private lateinit var currentJob: Job


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
        binding.shareIntent.setOnClickListener {
            Log.e("1111:::: ", currentJob.title.toString())
            var data = Intent(Intent.ACTION_SEND)
                .setType("text/plain")
                .putExtra(
                    Intent.EXTRA_TEXT,
                    "${currentJob.title}\n${currentJob.jobType}\n${currentJob.salary}\n${currentJob.url}"
                )
            startActivity(data)
        }
    }

    private fun setUpWebView() {
        binding.webView.apply {
            webViewClient = WebViewClient()
            currentJob.url?.let { loadUrl(it) }
        }

        val settings = binding.webView.settings
        settings.javaScriptEnabled = true
        settings.setAppCacheEnabled(true)
        settings.cacheMode = WebSettings.LOAD_DEFAULT
        settings.setSupportZoom(false)
        settings.builtInZoomControls = false
        settings.displayZoomControls = false
        settings.textZoom = 100
        settings.blockNetworkImage = false
        settings.loadsImagesAutomatically = true

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}
package ru.ds.gatenew

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.ds.gatenew.databinding.FragmentCallbackBinding
import java.lang.Thread.sleep
import kotlin.system.exitProcess

const val SH1_NUMBER = "89858892954"
const val SH2_NUMBER = "89165465498"
const val SH3_NUMBER = "89858896762"
const val SH4_NUMBER = "89858896739"

class CallbackFragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentCallbackBinding? = null
    private val binding: FragmentCallbackBinding
        get() = _binding!!

    companion object {
        fun newInstance() = CallbackFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCallbackBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSh1.setOnClickListener(this)
        binding.btnSh2.setOnClickListener(this)
        binding.btnSh3.setOnClickListener(this)
        binding.btnSh4.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnSh1 -> {
                makeCall(SH1_NUMBER) // call to gate
                closeApp() //close app
            }

            R.id.btnSh2 -> {
                makeCall(SH2_NUMBER)
                closeApp() //close app
            }
            R.id.btnSh3 -> {
                makeCall(SH3_NUMBER)
                closeApp() //close app
            }
            R.id.btnSh4 -> {
                makeCall(SH4_NUMBER)
                closeApp() //close app
            }
        }
    }

    private fun closeApp() {
        Thread {
            sleep(3000)
            quitApp(binding.root)
        }.start()
    }

    private fun makeCall(call_number: String) {
        val callIntent = Intent(Intent.ACTION_CALL)
        val phNum = "tel:$call_number"
        callIntent.data = Uri.parse(phNum)
        startActivity(callIntent)
    }

    private fun quitApp(view: View) {
        this@CallbackFragment
        exitProcess(0)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
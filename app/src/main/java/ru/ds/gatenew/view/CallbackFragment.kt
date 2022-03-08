package ru.ds.gatenew.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.ds.gatenew.R
import ru.ds.gatenew.databinding.FragmentCallbackBinding
import ru.ds.gatenew.utils.Constant
import java.lang.Thread.sleep
import kotlin.system.exitProcess



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
                makeCall(Constant.SH1_NUMBER) // call to gate
                closeApp() //close app
            }

            R.id.btnSh2 -> {
                makeCall(Constant.SH2_NUMBER)
                closeApp() //close app
            }
            R.id.btnSh3 -> {
                makeCall(Constant.SH3_NUMBER)
                closeApp() //close app
            }
            R.id.btnSh4 -> {
                makeCall(Constant.SH4_NUMBER)
                closeApp() //close app
            }
        }
    }

    private fun closeApp() {
        Thread {
            sleep(3000)
            this@CallbackFragment
            exitProcess(0)
        }.start()
    }

    private fun makeCall(call_number: String) {
        val callIntent = Intent(Intent.ACTION_CALL)
        val phNum = "tel:$call_number"
        callIntent.data = Uri.parse(phNum)
        startActivity(callIntent)
    }

       override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
package com.chtmed.mvi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var tvResult: TextView
    lateinit var btnTry: Button
    private val viewModel: CalculateRandomDivisionViewModel by lazy {
        androidx.lifecycle.ViewModelProviders.of(this)
            .get(CalculateRandomDivisionViewModel::class.java)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvResult = findViewById(R.id.tv_result)
        btnTry = findViewById(R.id.btn_try)

        render()
        btnTry.setOnClickListener {
            lifecycleScope.launch {
                viewModel.intentChannel.send(CalculateRandomDivisionIntent.TryRandom)
            }
        }
    }

    private fun render() {
        lifecycleScope.launch {

            viewModel.viewState.collect {

                when (it) {


                    is CalculateRandomDivisionViewState.Standby -> tvResult.text =
                        getString(R.string.ready)
                    is CalculateRandomDivisionViewState.Result -> tvResult.text =
                        it.result.toString()
                    is CalculateRandomDivisionViewState.Error -> tvResult.text = it.error
                }
            }
        }
    }
}

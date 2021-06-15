package com.devmasterteam.gastoviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        val id: Int = view.id

        if (id == R.id.buttonCalculate) {
            calculate()
        }
    }

    private fun calculate() {
        if (isValidationOk()) {
            try {
                val total =
                    ((editDistance.text.toString().toFloat() * editPrice.text.toString().toFloat())
                            / editAutonomy.text.toString().toFloat())

                textResult.text = "R$ ${"%.2f".format(total)}"

            } catch (nfe: NumberFormatException) {
                Toast.makeText(
                    this,
                    getString(R.string.preenche_valores_validos),
                    Toast.LENGTH_SHORT
                ).show()
            }
        } else {
            Toast.makeText(this, getString(R.string.preencha_campos), Toast.LENGTH_SHORT).show()
        }
    }

    private fun isValidationOk(): Boolean = (
            editDistance.text.toString() != "" &&
                    editPrice.text.toString() != "" &&
                    editAutonomy.text.toString() != "" &&
                    editAutonomy.text.toString() != "0"
            )

}

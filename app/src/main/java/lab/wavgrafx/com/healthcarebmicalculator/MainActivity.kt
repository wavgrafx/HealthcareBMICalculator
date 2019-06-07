package lab.wavgrafx.com.healthcarebmicalculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.math.RoundingMode
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var seekbar_weight = findViewById<View>(R.id.seekbar_weight) as SeekBar
        var seekbar_height = findViewById<View>(R.id.seekbar_height) as SeekBar
        var bmiResult = findViewById<View>(R.id.bmi_Result) as TextView

        fun calcuBMI(){
            var userWeight = seekbar_weight.progress.toDouble()
            var userHeight = seekbar_height.progress.toDouble()

            var calcresult:Double = (userWeight/userHeight/userHeight) * 10000

            val num = calcresult
            val df = DecimalFormat("#.#")
            df.roundingMode = RoundingMode.CEILING

            bmiResult.text = (df.format(num))
            var cc = bmiResult.text.toString()
            var vc = cc.toDouble()

            if (vc <= 15){ bmiDescription.text = getString(R.string.des01) }
            if (vc >= 15 && vc <= 16){ bmiDescription.text = getString(R.string.des02) }
            if (vc >= 16 && vc <= 18.5){ bmiDescription.text = getString(R.string.des03) }
            if (vc >= 18.6 && vc <= 25){ bmiDescription.text = getString(R.string.des04) }
            if (vc >= 25.1 && vc <= 30){ bmiDescription.text = getString(R.string.des05) }
            if (vc >= 30.1 && vc <= 35){ bmiDescription.text = getString(R.string.des06) }
            if (vc >= 35.1 && vc <= 40){ bmiDescription.text = getString(R.string.des07) }
            if (vc >= 40.1 && vc <= 45){ bmiDescription.text = getString(R.string.des08) }
            if (vc >= 45.1 && vc <= 50){ bmiDescription.text = getString(R.string.des09) }
            if (vc >= 50.1 && vc <= 60){ bmiDescription.text = getString(R.string.des10) }
            if (vc >= 60.1){ bmiDescription.text = getString(R.string.des11) }

            if (vc <= 18.5){ bmi_healthRisk.text = getString(R.string.risk01) }
            if (vc >= 18.6 && vc <= 23){ bmi_healthRisk.text = getString(R.string.risk02) }
            if (vc >= 23.1 && vc <= 27.5){ bmi_healthRisk.text = getString(R.string.risk03) }
            if (vc >= 60.1){ bmi_healthRisk.text = getString(R.string.risk04) }
        }

        seekbar_height.progress.coerceIn(48, 251)
        seekbar_weight.progress.coerceIn(3, 640)

        seekbar_weight.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                bmi_weight.text = progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                calcuBMI()
            }

        })

        seekbar_height.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                bmi_height.text = progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                calcuBMI()

            }

        })

        weight_minus.setOnClickListener {
            seekbar_weight.progress = seekbar_weight.progress - 1
            calcuBMI()
        }

        weight_plus.setOnClickListener {
            seekbar_weight.progress = seekbar_weight.progress + 1
            calcuBMI()
        }

        height_minus.setOnClickListener {
            seekbar_height.progress = seekbar_height.progress - 1
            calcuBMI()
        }

        height_plus.setOnClickListener {
            seekbar_height.progress = seekbar_height.progress + 1
            calcuBMI()
        }
    }
}

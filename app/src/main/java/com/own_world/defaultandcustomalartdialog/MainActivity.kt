package com.own_world.defaultandcustomalartdialog

import android.app.AlertDialog
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import cn.pedant.SweetAlert.SweetAlertDialog
import com.own_world.defaultandcustomalartdialog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val dialog = AlertDialog.Builder(this)

            dialog.setTitle("Alert Dialog")
            dialog.setMessage("This is a default alert dialog")
            dialog.setPositiveButton("OK") { dialog, _ ->
              Toast.makeText(this,"OK button cliked",Toast.LENGTH_SHORT).show()
                dialog.dismiss()

            }
            dialog.setNegativeButton("NO") { dialog, _ ->
                Toast.makeText(this,"NO button cliked",Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            dialog.setNeutralButton("CANCEL") { dialog, _ ->
                Toast.makeText(this,"CANCEL button cliked",Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            val alertDialog:AlertDialog = dialog.create()
            alertDialog.setCancelable(false)
            alertDialog.show()

        }


        binding.custom.setOnClickListener {
            SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE)
                .setTitleText("Custom Alert Dialog")
                .setContentText("This is a custom alert dialog")
                .setConfirmText("OK")
        }
    }
}
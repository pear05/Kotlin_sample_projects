package com.example.lab3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText


class OrderActivity : AppCompatActivity() {
    var orderMessage=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
       var oprice=intent.getIntExtra("PRICE",0)
      // var dprice= oprice?.toInt()
        var orderTextView: TextView=findViewById(R.id.order_textview)
        var fullName:TextInputEditText=findViewById(R.id.full_name)
        var address:TextInputEditText=findViewById(R.id.address)
        var phoneNumber:TextInputEditText=findViewById(R.id.phone_number)
        var orderDetails:TextInputEditText=findViewById(R.id.order_description)
        var sameDayChecked:RadioButton=findViewById(R.id.sameday)
        var nextDayChecked:RadioButton=findViewById(R.id.nextday)
        var selfPickChecked:RadioButton=findViewById(R.id.pickup)
        var orderButton:Button=findViewById(R.id.submitOrder)
        var orderedItem= intent.getStringExtra( "ORDER")
        orderTextView.text=orderedItem
        orderButton.setOnClickListener {
            if (sameDayChecked.isChecked){
                var oprice= oprice+300


                var intentReceiptActivity=Intent(this,ReceiptActivity::class.java)
                intentReceiptActivity.putExtra("NAME",fullName.toString())
                intentReceiptActivity.putExtra("ADD",address.toString())
                intentReceiptActivity.putExtra("PNUMBER",phoneNumber.toString())
                intentReceiptActivity.putExtra("ORDER",orderedItem)
                intentReceiptActivity.putExtra("DPRICE",oprice)
                startActivity(intentReceiptActivity)
            }
            else if (nextDayChecked.isChecked){
                oprice= oprice+150
                var intentReceiptActivity=Intent(this,ReceiptActivity::class.java)
                intentReceiptActivity.putExtra("NAME",fullName.toString())
                intentReceiptActivity.putExtra("ADD",address.toString())
                intentReceiptActivity.putExtra("PNUMBER",phoneNumber.toString())
                intentReceiptActivity.putExtra("ORDER",orderedItem)
                intentReceiptActivity.putExtra("DPRICE",oprice)
                startActivity(intentReceiptActivity)
            }
            else if (selfPickChecked.isChecked){
                oprice=oprice
                var intentReceiptActivity=Intent(this,ReceiptActivity::class.java)
                intentReceiptActivity.putExtra("NAME",fullName.toString())
                intentReceiptActivity.putExtra("ADD",address.toString())
                intentReceiptActivity.putExtra("PNUMBER",phoneNumber.toString())
                intentReceiptActivity.putExtra("ORDER",orderedItem)
                intentReceiptActivity.putExtra("DPRICE",oprice)
                startActivity(intentReceiptActivity)


            }

        }
    }


}
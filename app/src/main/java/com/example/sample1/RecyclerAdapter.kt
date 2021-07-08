package com.example.sample1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter :RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){
    val fname :Array<String> = arrayOf("Envato Payment","Bank Charge","Payment from Paypal","Mastercard Charge","Mastercard Charge","Wallmart shopping","Envato Payment","Bank Charge","Payment from Paypal","Mastercard Charge","Mastercard Charge","Wallmart shopping")
    val desg :Array<String> = arrayOf("-$50 USD"," +$150 USD","-$30 USD","-$90 USD","+$150 USD","-$50 USD","-$50 USD"," +$150 USD","-$30 USD","-$90 USD","+$150 USD","-$50 USD")
    val pics :IntArray = intArrayOf(R.drawable.wallet,R.drawable.wallet,R.drawable.paypal,R.drawable.mastercard,R.drawable.wallet,R.drawable.wallet,R.drawable.wallet,R.drawable.wallet,R.drawable.paypal,R.drawable.mastercard,R.drawable.wallet,R.drawable.wallet)
    inner class ViewHolder(itemView:View) :RecyclerView.ViewHolder(itemView) {
        var image :ImageView
        var fname :TextView
        var desg :TextView
        init {
            image =itemView.findViewById(R.id.cardimageView4)
            fname =itemView.findViewById(R.id.cardtextView7)
            desg =itemView.findViewById(R.id.cardtextView8)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v =LayoutInflater.from(parent.context).inflate(R.layout.mylayout,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.fname.text=fname[position]
        holder.desg.text=desg[position]
        holder.image.setImageResource(pics[position])
    }

    override fun getItemCount(): Int {
        return fname.size
    }
}
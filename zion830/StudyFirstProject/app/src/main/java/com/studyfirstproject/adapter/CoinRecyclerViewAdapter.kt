package com.studyfirstproject.adapter

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.studyfirstproject.R
import com.studyfirstproject.model.TickerModel
import com.studyfirstproject.util.NumberFormatUtil
import kotlinx.android.synthetic.main.item_coin_info.view.*
import org.jetbrains.anko.textColor

class CoinRecyclerViewAdapter
    : RecyclerView.Adapter<CoinRecyclerViewAdapter.CoinItemViewHolder> {
    var coinList: ArrayList<TickerModel>

    constructor(tickers: ArrayList<TickerModel>) : super() {
        this.coinList = tickers
    }

    override fun onCreateViewHolder(parent: ViewGroup, type: Int): CoinItemViewHolder {
        val viewGroup = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_coin_info, parent, false)

        return CoinItemViewHolder(viewGroup)
    }

    override fun getItemCount(): Int = coinList.size

    override fun onBindViewHolder(parent: CoinItemViewHolder, position: Int) {
        parent.bind(coinList[position])
    }

    fun getItem(position: Int) = coinList[position]

    fun removeAll() {
        coinList.clear()
        notifyDataSetChanged()
    }

    inner class CoinItemViewHolder(private var view: View) : RecyclerView.ViewHolder(view) {
        fun bind(data: TickerModel) {
            val coinNameText = view.tv_coin_name as TextView
            val coinTradePriceText = view.tv_coin_trade_price as TextView
            val coinChangeRateText = view.tv_coin_change_rate as TextView
            val coinAccTradePriceText = view.tv_coin_acc_trade_price as TextView

            coinNameText.text = data.market.substring(data.market.indexOf("-") + 1)
            coinTradePriceText.text = NumberFormatUtil.insertComma(data.tradePrice.toLong())
            coinChangeRateText.text = NumberFormatUtil.getPercent(data.signedChangeRate)
            coinAccTradePriceText.text = NumberFormatUtil.skipUnderMillions(data.accTradePrice24h)

            coinChangeRateText.textColor = if (data.signedChangeRate > 0) {
                Color.BLUE
            } else if (data.signedChangeRate < 0) {
                Color.RED
            } else {
                Color.BLACK
            }
        }
    }
}
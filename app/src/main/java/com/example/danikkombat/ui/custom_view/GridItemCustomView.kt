package com.example.danikkombat.ui.custom_view

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.example.danikkombat.R

class GridItemCustomView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : FrameLayout(context, attrs, defStyle) {

    private var multiplierTitleTextView: TextView
    private var multiplierPriceTextView: TextView
    private var cardView: CardView
    private var cardColor: Int = 0

    init {
        inflate(context, R.layout.grid_item_view, this)
        multiplierTitleTextView = findViewById(R.id.multiplierTitleTextView)
        multiplierPriceTextView = findViewById(R.id.multiplierPriceTextView)
        cardView = findViewById(R.id.mainGridItemHolder)

        attrs?.let {
            val attrsArray = context.theme.obtainStyledAttributes(
                attrs, R.styleable.GridItemCustomView, 0, 0
            )
            val title = attrsArray.getResourceId(
                R.styleable.GridItemCustomView_gridTitle,
                R.string.stub
            )
            val price = attrsArray.getResourceId(
                R.styleable.GridItemCustomView_gridPrice,
                R.string.stub
            )
            cardColor = attrsArray.getResourceId(
                R.styleable.GridItemCustomView_cardColor,
                R.color.very_light_purple
            )
            attrsArray.recycle()

            multiplierTitleTextView.text = context.getString(title)
            multiplierPriceTextView.text = context.getString(price)
            cardView.setCardBackgroundColor(context.getColor(cardColor))
        }

    }

    val title: String
        get() = multiplierTitleTextView.text.toString()

    val price: String
        get() = multiplierPriceTextView.text.toString()

    var color: Int
        get() = cardColor
        set(value) {
            cardView.setCardBackgroundColor(value)
        }

}
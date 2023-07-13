package com.example.presenter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.WeatherInHourModel
import com.example.presenter.databinding.ItemBinding

class WeatherAdapter:ListAdapter<WeatherInHourModel, WeatherAdapter.WeatherViewHolder>(WeatherDifutill()) {
    inner class WeatherViewHolder(private val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(model: WeatherInHourModel?) {
            binding.tvTime.text = model?.time.toString()
            binding.tvTemp.text = model?.temp.toString()
            Log.e("WeatherAdapter", "Binding weather item: $model")
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        return WeatherViewHolder(ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class WeatherDifutill: DiffUtil.ItemCallback<WeatherInHourModel>() {
    override fun areItemsTheSame(
        oldItem: WeatherInHourModel,
        newItem: WeatherInHourModel,
    ): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: WeatherInHourModel,
        newItem: WeatherInHourModel,
    ): Boolean {
        return oldItem == newItem
    }

}

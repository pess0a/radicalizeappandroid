package com.pessoadev.radicalizeapp.presentation.base

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pessoadev.radicalizeapp.R
import com.pessoadev.radicalizeapp.commons.AppUtil
import com.pessoadev.radicalizeapp.presentation.main.model.Activities
import kotlinx.android.synthetic.main.item_activities.view.*


class ActivitiesAdapter(var activitiesList: List<Activities>) :
    RecyclerView.Adapter<ActivitiesAdapter.ActivitiesViewHolder>() {
    lateinit var context: Context

    inner class ActivitiesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(activity: Activities) {
            itemView.textViewTitle.text = activity.name
            itemView.textViewCity.text = activity.city
            AppUtil.loadImage(context, activity.photos[0], itemView.imageViewActivity)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivitiesViewHolder {
        context = parent.context
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_activities, parent, false)
        return ActivitiesViewHolder(view)
    }

    override fun onBindViewHolder(holder: ActivitiesViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemCount(): Int {
        return activitiesList.size
    }

    private fun getItem(position: Int): Activities {
        return activitiesList[position]
    }


}
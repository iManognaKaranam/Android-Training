package com.dbs.employeeapplication
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dbs.employeeapplication.databinding.ItemDashboardRowBinding


class DashboardAdapter(private val items: ArrayList<String>) :
    RecyclerView.Adapter<DashboardAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemDashboardRowBinding.inflate(
                LayoutInflater.from(parent.context),parent,false)
        )
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val username: String = items.get(position)

        holder.tvPosition1.text = (position + 1).toString()
        holder.tvItem1.text = username.toString()

        // Updating the background color according to the odd/even positions in list.
        if (position % 2 == 0) {
            holder.llDashboardItemMain.setBackgroundColor(
                Color.parseColor("#EBEBEB")
            )
        } else {
            holder.llDashboardItemMain.setBackgroundColor(
                Color.parseColor("#FFFFFF")
            )
        }
    }
    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(binding:ItemDashboardRowBinding) : RecyclerView.ViewHolder(binding.root) {

        val llDashboardItemMain = binding.llDashboardItemMain
        val tvItem1 = binding.tvItem1
        val tvPosition1 = binding.tvPosition1
    }
}
// END
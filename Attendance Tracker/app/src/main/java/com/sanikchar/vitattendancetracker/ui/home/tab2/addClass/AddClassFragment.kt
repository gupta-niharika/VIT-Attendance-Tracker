package com.sanikchar.vitattendancetracker.ui.home.tab2.addClass

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.sanikchar.vitattendancetracker.R
import com.sanikchar.vitattendancetracker.databinding.FragmentAddClassBinding
import com.sanikchar.vitattendancetracker.db.Repository
import java.text.SimpleDateFormat
import java.util.*

private const val TAG = "AddClassFragment"

class AddClassFragment : Fragment() {
    private lateinit var binding: FragmentAddClassBinding
    private val selectedDays = mutableSetOf<TextView>()
    private lateinit var repository: Repository
    private lateinit var viewModel: AddClassViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddClassBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(AddClassViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            bindDays()

            apply {
                classCode.doAfterTextChanged { viewModel.classInfo.code = it.toString() }
                subName.doAfterTextChanged { viewModel.classInfo.subName = it.toString() }
                classSlot.doAfterTextChanged { viewModel.classInfo.slot = it.toString() }
            }

            startTime.hour = 8
            endTime.hour = 8
            endTime.minute = 50
            startTime.setOnTimeChangedListener { _, hourOfDay, minute ->
                viewModel.classInfo.startTime = setTime(hourOfDay, minute)
            }
            endTime.setOnTimeChangedListener { _, hourOfDay, minute ->
                viewModel.classInfo.endTime = setTime(hourOfDay, minute)
            }
            save.setOnClickListener { insertData() }
        }
    }

    private fun setTime(hourOfDay: Int, minute: Int): String {
        Calendar.getInstance().also { calendar ->
            calendar.set(Calendar.HOUR_OF_DAY, hourOfDay)
            calendar.set(Calendar.MINUTE, minute)
            SimpleDateFormat("hh:mm a", Locale.getDefault()).also { sdf ->
                return@setTime sdf.format(calendar.time)
            }
        }
    }

    private fun FragmentAddClassBinding.bindDays() {
        dayM.setOnClickListener { toggleDay(dayM) }
        dayTu.setOnClickListener { toggleDay(dayTu) }
        dayW.setOnClickListener { toggleDay(dayW) }
        dayTh.setOnClickListener { toggleDay(dayTh) }
        dayF.setOnClickListener { toggleDay(dayF) }
    }

    private fun FragmentAddClassBinding.insertData() {
        if (subName.text.isNullOrBlank()) {
            subName.error = "Please enter a valid subject name!"
        } else if (classCode.text.isNullOrBlank() || !classCode.text?.matches(Regex("^[A-Z]{3}[0-9]{4}$"))!!) {
            classCode.error = "Please enter the 7 character course code!"
        } else {
            repository = Repository(requireContext())
        }
    }

    // toggle color on day
    private fun toggleDay(textview: TextView) {
        textview.let {
            if (selectedDays.contains(it)) selectedDays.remove(it)
            else selectedDays.add(it)
            viewModel.classInfo.days = selectedDays.map { textView ->
                when (textView.text) {
                    "M" -> 0
                    "Tu" -> 1
                    "W" -> 2
                    "Th" -> 3
                    "F" -> 4
                    else -> -1
                }
            }

            it.backgroundTintList = ColorStateList.valueOf(
                ContextCompat.getColor(
                    requireContext(),
                    when {
                        selectedDays.contains(it) -> R.color.purple
                        else -> R.color.white_light
                    }
                )
            )
        }
    }
}
package com.sanikchar.vitattendancetracker.ui.home.tab2

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.sanikchar.vitattendancetracker.R
import com.sanikchar.vitattendancetracker.databinding.FragmentAddClassBinding
import com.sanikchar.vitattendancetracker.db.Repository
import com.sanikchar.vitattendancetracker.model.ClassInfo
import kotlinx.coroutines.launch

private const val TAG = "AddClassFragment"

class AddClassFragment : Fragment() {
    private lateinit var binding: FragmentAddClassBinding
    private val selectedDays = mutableSetOf<TextView>()
    private lateinit var repository: Repository
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddClassBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            dayM.setOnClickListener { toggleDay(dayM) }
            dayTu.setOnClickListener { toggleDay(dayTu) }
            dayW.setOnClickListener { toggleDay(dayW) }
            dayTh.setOnClickListener { toggleDay(dayTh) }
            dayF.setOnClickListener { toggleDay(dayF) }
        }

        binding.apply { save.setOnClickListener { insertData() } }
    }

    private fun FragmentAddClassBinding.insertData(){
        if (subName.text.isNullOrBlank()) {
            subName.error = "Please enter a valid subject name!"
        } else if (classCode.text.isNullOrBlank() || !classCode.text?.matches(Regex("^[A-Z]{3}[0-9]{4}$"))!!) {
            classCode.error = "Please enter the 7 character course code!"
        } else {
            repository = Repository(requireContext())
            lifecycleScope.launch {
                repository.addClassInfo(
                    classInfo = ClassInfo(
                        subName = subName.text.toString(),
                        code = classCode.text.toString(),
                        startTime = "16:00",
                        endTime = "8:00",
                        days = selectedDays.map {
                            when (it.text) {
                                "M" -> 0
                                "Tu" -> 1
                                "W" -> 2
                                "Th" -> 3
                                "F" -> 4
                                else -> -1
                            }
                        }
                    )
                )
            }
        }
    }

    // toggle color on day
    private fun toggleDay(textview: TextView) {
        textview.let {
            if (selectedDays.contains(it)) selectedDays.remove(it)
            else selectedDays.add(it)
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
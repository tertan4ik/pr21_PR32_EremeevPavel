package com.bignerdranch.android.criminalintent

import java.text.DateFormat
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.google.android.material.floatingactionbutton.FloatingActionButton
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import java.util.Locale

class CrimeFragment : Fragment() {
    private lateinit var titleField: EditText
    private lateinit var dateFab: FloatingActionButton
    private lateinit var crime: Crime

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_crime, container, false)
        crime = Crime()

        titleField = view.findViewById(R.id.crime_title) as EditText
        dateFab = view.findViewById(R.id.crime_date) as FloatingActionButton

        val dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        val formattedDate = dateFormat.format(crime.date)

        dateFab.apply {
            setOnClickListener {
                Snackbar.make(view, formattedDate, Snackbar.LENGTH_LONG).show()
            }
        }

        return view
    }
}
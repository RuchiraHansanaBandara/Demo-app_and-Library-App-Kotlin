package com.example.libraryappforalertdialog

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.libalertbox.AlertDialogFragment
import kotlinx.android.synthetic.main.fragment_custom_dialog_box.*


import kotlinx.android.synthetic.main.fragment_custom_dialog_box.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1="param1"
private const val ARG_PARAM2="param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CustomDialogBoxFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CustomDialogBoxFragment : Fragment() {

    var alertFragment=AlertDialogFragment()

    private lateinit var datacomminication: DataComminication


    // TODO: Rename and change types of parameters
    private var param1: String?=null
    private var param2: String?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1=it.getString(ARG_PARAM1)
            param2=it.getString(ARG_PARAM2)


        }


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        var view=inflater.inflate(R.layout.activity_main, container, false)


        val dialog=LayoutInflater.from(container?.context)
            .inflate(R.layout.fragment_custom_dialog_box, null)

        val mBuilder=AlertDialog.Builder(container!!.context)
            .setView(dialog)
            .setTitle("Login Form")

        val mAlertDialog=mBuilder.show()



        datacomminication=activity as DataComminication

        dialog.DialogLogin.setOnClickListener {


            mAlertDialog.dismiss()

            val transaction=activity?.supportFragmentManager?.beginTransaction()
            transaction?.replace((requireView().parent as ViewGroup).id, alertFragment)
                ?.addToBackStack(null)
                ?.commit();

            datacomminication.PassData(dialog.DialogName.text.toString(),
                dialog.DialogEmail.text.toString(),
                dialog.DialogPassword.text.toString())


        }

        dialog.DialogCancel.setOnClickListener {
            mAlertDialog.dismiss()
        }



        return view

    }
}



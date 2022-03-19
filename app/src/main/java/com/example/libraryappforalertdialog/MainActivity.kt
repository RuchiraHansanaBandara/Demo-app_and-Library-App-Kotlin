package com.example.libraryappforalertdialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.libalertbox.AlertDialogFragment


class MainActivity : AppCompatActivity(),DataComminication{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val DialogBox = CustomDialogBoxFragment()
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container,DialogBox).commit()




    }

    override fun PassData(Name: String, Email: String, Password: String) {
        val bundle = Bundle()
        bundle.putString("Name" ,Name)
        bundle.putString("Email" ,Email)
        bundle.putString("Password",Password)

        val trans = this.supportFragmentManager.beginTransaction()
        val fragmentDataView = AlertDialogFragment()
        fragmentDataView.arguments = bundle

        trans.replace(R.id.fragment_container,fragmentDataView)
        trans.commit()
    }

}

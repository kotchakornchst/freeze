package com.example.reuesview


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import com.bumptech.glide.Glide
import com.facebook.login.LoginManager

/**
 * A simple [Fragment] subclass.
 */
class Menu_music : Fragment() {

    var PhotoURL : String = ""
    var Name : String = ""

    fun newInstance(url: String,name : String): Menu_music {

        val profile = Menu_music()
        val bundle = Bundle()
        bundle.putString("PhotoURL", url)
        bundle.putString("Name", name)
        profile.setArguments(bundle)

        return profile
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_menu_music, container, false)

        val ivProfilePicture = view.findViewById(R.id.iv_profile) as ImageView
        val tvName = view.findViewById(R.id.tv_name) as TextView
        val login_button2 = view.findViewById(R.id.login_button2) as Button

        Glide.with(activity!!.baseContext)
            .load(PhotoURL)
            .into(ivProfilePicture)

        tvName.setText(Name)

        login_button2.setOnClickListener{

            LoginManager.getInstance().logOut()
            activity!!.supportFragmentManager.popBackStack()
        }
        // Inflate the layout for this fragment
        val button: Button = view.findViewById(R.id.btninter);
        val button1: Button = view.findViewById(R.id.btnthai);
        val button2: Button = view.findViewById(R.id.btnkpop);
        val button3: Button = view.findViewById(R.id.btndb);

        button.setOnClickListener {
            Toast.makeText(context, "Inter Detail", Toast.LENGTH_LONG).show()
            val fragment_recycler_view = Recycler_view()
            val fm = fragmentManager
            val transaction: FragmentTransaction = fm!!.beginTransaction()
            transaction.replace(R.id.contentContainer, fragment_recycler_view, "fragment_recycler_view")
            transaction.addToBackStack("fragment_recycler_view")
            transaction.commit()
        }

        button1.setOnClickListener {
            Toast.makeText(context, "Thai Detail", Toast.LENGTH_LONG).show()
            val fragment_recycler_view2 = Recycler_view2()
            val fm = fragmentManager
            val transaction: FragmentTransaction = fm!!.beginTransaction()
            transaction.replace(R.id.contentContainer, fragment_recycler_view2, "fragment_recycler_view2")
            transaction.addToBackStack("fragment_recycler_view2")
            transaction.commit()
        }

        button2.setOnClickListener {
            Toast.makeText(context, "K-POP Detail", Toast.LENGTH_LONG).show()
            val fragment_recycler_view3 = Recycler_view3()
            val fm = fragmentManager
            val transaction: FragmentTransaction = fm!!.beginTransaction()
            transaction.replace(R.id.contentContainer, fragment_recycler_view3, "fragment_recycler_view3")
            transaction.addToBackStack("fragment_recycler_view3")
            transaction.commit()
        }

        button3.setOnClickListener {
            Toast.makeText(context, "MainChart Detail", Toast.LENGTH_LONG).show()
            val mainChart = MainChart()
            val fm = fragmentManager
            val transaction: FragmentTransaction = fm!!.beginTransaction()
            transaction.replace(R.id.contentContainer, mainChart, "mainChart")
            transaction.addToBackStack("mainChart")
            transaction.commit()
        }

        return view

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val bundle = arguments
        if (bundle != null) {
            PhotoURL = bundle.getString("PhotoURL").toString()
            Name = bundle.getString("Name").toString()

        }

    }

}

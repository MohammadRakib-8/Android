import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.fragment_to_fragment_data_passing.R

class FirstFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)

        val button1F: Button = view.findViewById(R.id.buttonF)
        val editTextF: EditText = view.findViewById(R.id.editTextTextF)

        button1F.setOnClickListener {
            val data = editTextF.text.toString()
            val bundle = Bundle()
            bundle.putString("data", data)
            val secondFragment = SecondFragment()
            secondFragment.arguments = bundle
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerViewMain, secondFragment)
                .addToBackStack(null)
                .commit()

        }

    return view
    }
}

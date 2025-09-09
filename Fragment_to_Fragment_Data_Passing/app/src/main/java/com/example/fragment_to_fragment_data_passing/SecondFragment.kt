import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.fragment_to_fragment_data_passing.R

class SecondFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_second, container, false)
        val textView2S: TextView = view.findViewById(R.id.textView2S)

        val reciveData = arguments?.getString("data")
        textView2S.text = reciveData ?: "No Data Recived"
        return view
    }


    }




import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.drogas.modulo.Grifa
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.proto.MaybeDocument.DocumentTypeCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.w3c.dom.DocumentType

class ViewModelFirebase : ViewModel() {
    val conexion = FirebaseFirestore.getInstance()

    private var _listaGrifa = MutableStateFlow(mutableStateListOf<Grifa>())
    var listaGrifa = _listaGrifa.asStateFlow()

    fun crearListener() {
        conexion.collection("Grifa").addSnapshotListener { datos, error ->
            if (error == null) {
                //Que cambios ha habido en la BD?
                datos?.documentChanges?.forEach { cambio ->
                    if (cambio.type == DocumentChange.Type.ADDED) {
                        //Añadimos elementos a la lista ui

                    } else if (cambio.type == DocumentChange.Type.REMOVED) {
                        //Quitamos elementos a la lista ui

                    } else if (cambio.type == DocumentChange.Type.MODIFIED) {

                        //Modificamos elementos a la lista ui

                    }
                }
            }

        }
    }
}


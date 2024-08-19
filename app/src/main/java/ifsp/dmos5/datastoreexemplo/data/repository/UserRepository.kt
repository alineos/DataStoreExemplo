package ifsp.dmos5.datastoreexemplo.data.repository

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException



//classe de acesso ao DataStore

private val Context.dataStore by preferencesDataStore(name = "file_datastore")

// o contexto deve ser o contexto da aplicação, não o contexto da main. (Não usar this)*****


class UserRepository (context: Context){
    /*
    * Definição de um companion object para representar os campos do arquivo DataStore.
    */

    companion object {
        val ATTR_USERNAME = stringPreferencesKey("username")
    }

    //Atributo de referência ao DataStore do Contex
    private val dataStore = context.dataStore

    //Atributo Flow que possui o username salvo no dataStore

    val usernameFlow: Flow<String?> = dataStore
        .data
        .catch { exception ->
            if (exception is IOException) {
                emit(emptyPreferences())
            } else {
                throw exception
            }
            }.map { it.get(ATTR_USERNAME)
                }
            suspend fun saveUsername (username: String){
                dataStore.edit{
                    it[ATTR_USERNAME] = username


            }

            }
}



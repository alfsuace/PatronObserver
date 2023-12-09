package com.alfsuace.patronobserver.data

import android.content.Context
import com.alfsuace.patronobserver.commons.Either
import com.alfsuace.patronobserver.commons.ErrorApp
import com.alfsuace.patronobserver.commons.Serializer
import com.alfsuace.patronobserver.commons.left
import com.alfsuace.patronobserver.commons.right
import com.alfsuace.patronobserver.domain.Editor

class EditorXmlLocalDataSource(
    private val context: Context,
    private val serializer: Serializer
) {

    private val sharedPref = context.getSharedPreferences("Resource", Context.MODE_PRIVATE)

    fun saveEditor(editor: Editor): Either<ErrorApp, Boolean> = try {
        sharedPref.edit().apply {
            putString(editor.toString(), serializer.toJson(editor, Editor::class.java))
        }.apply()
        true.right()
    } catch (ex: Exception) {
        ErrorApp.DataError.left()
    }

    fun getEditor(id: Int): Either<ErrorApp, Editor> = try{
        val id: Int = 1
        //vamos a coger siempre el editor cuya id sea siempre 1 para simplificar
        serializer.fromJson(
            sharedPref.getString(id.toString(), null)!!.toString(),
            Editor::class.java
        ).right()
    } catch (ex: Exception)
    {
        ErrorApp.DataError.left()
    }
}

package com.alfsuace.patronobserver

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alfsuace.patronobserver.commons.Serializer
import com.alfsuace.patronobserver.data.EditorDataRepository
import com.alfsuace.patronobserver.data.EditorXmlLocalDataSource
import com.alfsuace.patronobserver.domain.Editor
import com.alfsuace.patronobserver.domain.EventManager
import com.alfsuace.patronobserver.domain.SaveEditorUseCase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        main()
    }

    fun main() {
        val editor: Editor =
            Editor(
                events = EventManager(),
                id = 1,
                contenido = "abc"
            )
        val context: Context  // obtén tu contexto de alguna manera
        val serializer: Serializer  // inicializa tu serializador

        val editorXmlLocalDataSource: EditorXmlLocalDataSource =
            EditorXmlLocalDataSource(context = context, serializer = serializer)

        val editorDataRepository: EditorDataRepository =
            EditorDataRepository(localSource = editorXmlLocalDataSource)

        SaveEditorUseCase(editorDataRepository)
    }

}
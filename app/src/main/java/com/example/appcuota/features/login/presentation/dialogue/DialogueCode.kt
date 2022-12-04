package com.example.appcuota.features.login.presentation.dialogue

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.appcuota.databinding.DialogueInputCodeBinding

class DialogueCode(
 private val onClickDateDialogue: (String) -> Unit
) : DialogFragment(){
    lateinit var binding : DialogueInputCodeBinding

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = DialogueInputCodeBinding.inflate(layoutInflater)
        val builder = AlertDialog.Builder(requireActivity()).setView(binding.root)

        eventsHandlets()

        val dialogue = builder.create()
        return dialogue
    }

    private fun eventsHandlets() {
        binding.btVerificar.setOnClickListener { getDateCode()}
    }

    private fun getDateCode() {
        val codigo = binding.tvCodigo.text.toString()
        onClickDateDialogue.invoke(codigo)
        dismiss()
    }


}
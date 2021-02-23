package me.grishka.houseclub.api

import android.content.Context
import android.view.View
import android.widget.TextView
import android.widget.Toast
import me.grishka.appkit.api.ErrorResponse
import me.grishka.houseclub.R

class ClubhouseErrorResponse : ErrorResponse {
    private var message: String?

    constructor(code: Int, message: String?) {
        this.message = message
    }

    constructor(br: BaseResponse) {
        message = br.errorMessage
    }

    override fun bindErrorView(view: View) {
        // TODO: getString으로 하기
        val txt: TextView = view.findViewById(R.id.error_text)
        txt.text = """
        ${view.context.getString(R.string.error_loading)}:
        $message
        """.trimIndent()
    }

    override fun showToast(context: Context) {
        Toast.makeText(context, R.string.error_loading, Toast.LENGTH_SHORT).show()
    }
}

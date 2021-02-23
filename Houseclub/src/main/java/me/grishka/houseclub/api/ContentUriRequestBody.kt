package me.grishka.houseclub.api

import android.net.Uri
import android.provider.OpenableColumns
import me.grishka.houseclub.App
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody
import okio.BufferedSink
import okio.source
import java.io.IOException

class ContentUriRequestBody(private val uri: Uri?) : RequestBody() {
    private var size = 0L
    var fileName: String? = null

    @Throws(IOException::class)
    override fun contentLength() = size

    override fun contentType() = App.context.contentResolver.getType(uri!!)?.toMediaType()

    @Throws(IOException::class)
    override fun writeTo(sink: BufferedSink) {
        App.context.contentResolver.openInputStream(uri!!)?.let {
            it.source().use { source -> sink.writeAll(source) }
        }
    }

    init {
        App.context.contentResolver.query(uri!!, null, null, null, null)
            .use { cursor ->
                cursor!!.moveToFirst()
                size = cursor.getLong(cursor.getColumnIndex(OpenableColumns.SIZE))
                fileName = cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME))
            }
    }
}

package com.thanhvinh.demomvp.data.source.remote.fetchjson

import android.os.AsyncTask
import com.thanhvinh.demomvp.data.source.remote.OnFetchDataJsonListener
import org.json.JSONObject

class GetJsonFromUrl<T>(
    private val listener: OnFetchDataJsonListener<T>,
    private val keyEntity: String
) : AsyncTask<String?, Void?, String?>() {

    private var exception: Exception? = null
    override fun doInBackground(vararg params: String?): String? {
        var fcData = ""
        try {
            val parseDataWithJson = ParseDataWithJson()
            fcData = parseDataWithJson.getJsonFromUrl(params[0]).toString()
        } catch (e: Exception) {
            exception = e
        }
        return fcData
    }

    override fun onPostExecute(data: String?) {
        super.onPostExecute(data)
        if (data != null && !data.isBlank()) {
            val jsonObject = JSONObject(data)
            @Suppress("UNCHECKED_CAST")
            listener.onSuccess(ParseDataWithJson().parseJsonToData(jsonObject, keyEntity) as T)
        } else listener.onError(exception)
    }
}

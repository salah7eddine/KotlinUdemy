package com.abousaid.myappstartup

import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.io.StringBufferInputStream
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    protected fun GetSunset(view:View){

        var city=etCityName.text.toString()
        val url="https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22"+
                city+"%2C%20%22)&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys"

        //val url = "https://samples.openweathermap.org/data/2.5/forecast?q="+city+"&appid=b6907d289e10d714a6e88b30761fae22"
        MyAsyncTask().execute(url)
    }


    //openweathermap API : 1cf3dfefb08bdf649ee7de0969509b08

    inner class MyAsyncTask: AsyncTask<String, String, String>() {


            override fun onPreExecute() {
                //before task started
            }

            override fun doInBackground(vararg p0: String?): String {
                try {
                    val url=URL(p0[0])

                    val urlConnect=url.openConnection() as HttpURLConnection

                    urlConnect.connectTimeout = 7000

                    var inString = ConvertStreamToString(urlConnect.inputStream)
                    //Cannot access to ui
                    publishProgress(inString.toString())

                }catch (ex:Exception){}

                return " "
            }

            override fun onProgressUpdate(vararg values: String?) {
                try{
                    var json=JSONObject(values[0])
                    val query=json.getJSONObject("query")
                    val results=query.getJSONObject("results")
                    val channel=results.getJSONObject("channel")
                    val astronomy=channel.getJSONObject("astronomy")
                    var sunrise=astronomy.getJSONObject("sunrise")
                    var sunset=astronomy.getJSONObject("sunset")

                    tvSunsetTime.text = "Sunrise time is : " + sunrise+ "\n" +"Sunset time is : " + sunset



                }catch (ex:Exception){
                    tvSunsetTime.setText(ex.message)
                }
            }

            override fun onPostExecute(result: String?) {
                //after task run
            }

        }

    fun ConvertStreamToString(inputStream:InputStream){
        val bufferReader= BufferedReader(InputStreamReader(inputStream))
        var line:String
        var AllString:String=""

        try{

            do {
                line=bufferReader.readLine()
                if(line!=null){
                    AllString += line
                }
            }while (line != null)
            inputStream.close()

        }catch(ex:Exception){
            tvSunsetTime.setText(ex.message)
        }
    }
}

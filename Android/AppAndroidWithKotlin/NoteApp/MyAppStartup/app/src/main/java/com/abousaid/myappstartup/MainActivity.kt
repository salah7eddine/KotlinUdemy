package com.abousaid.myappstartup

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.EventLogTags
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.SearchView
import android.widget.Toast
import com.abousaid.myappstartupnotesapp.AddNotes
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.ticket.view.*
import java.time.LocalDateTime
import java.util.*

class MainActivity : AppCompatActivity() {

    var listNotes=ArrayList<Note>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //add dummy data
        //listNotes.add(Note(1,"meet professor","Dans l’attente de votre retour, je vous remercie par avance de l’attention que vous avez porté à ma candidature et vous prie d’accepter, Monsieur, l’expression de mes salutations respectueuses."))
        //listNotes.add(Note(2,"meet doctor","Dans l’attente de votre retour, je vous remercie par avance de l’attention que vous avez porté à ma candidature et vous prie d’accepter, Monsieur, l’expression de mes salutations respectueuses."))
        //listNotes.add(Note(3,"meet friends","Dans l’attente de votre retour, je vous remercie par avance de l’attention que vous avez porté à ma candidature et vous prie d’accepter, Monsieur, l’expression de mes salutations respectueuses."))

        var myNotesAdapter = MyNotesAdapter(this,listNotes)
        lvNotes.adapter = myNotesAdapter

        Toast.makeText(this,"onCreate",Toast.LENGTH_LONG).show()
        //Load from DB
        LoadQuery("%")
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this,"onResume",Toast.LENGTH_LONG).show()
        LoadQuery("%")
    }

    override fun onStart() {
        Toast.makeText(this,"onStart",Toast.LENGTH_LONG).show()
        super.onStart()
    }

    override fun onPause() {
        Toast.makeText(this,"onPause",Toast.LENGTH_LONG).show()
        super.onPause()
    }

    override fun onStop() {
        Toast.makeText(this,"onStop",Toast.LENGTH_LONG).show()
        super.onStop()
    }

    override fun onDestroy() {
        Toast.makeText(this,"onDestroy",Toast.LENGTH_LONG).show()
        super.onDestroy()
    }

    override fun onRestart() {
        Toast.makeText(this,"onRestart",Toast.LENGTH_LONG).show()
        super.onRestart()
    }

    fun LoadQuery(title:String){
        var dbManager=DbManager(this)
        val projections= arrayOf("ID","Title","Description")
        val selectionArgs=arrayOf(title)
        val cursor=dbManager.Query(projections,"Title like ?",selectionArgs,"Title")


        listNotes.clear()

        if(cursor.moveToFirst()){
            do{
                val ID = cursor.getInt(cursor.getColumnIndex("ID"))
                val Title=cursor.getString(cursor.getColumnIndex("Title"))
                val Description=cursor.getString(cursor.getColumnIndex("Description"))


                listNotes.add(Note(ID,Title,Description))


            }while (cursor.moveToNext())
        }

        var myNotesAdapter = MyNotesAdapter(this,listNotes)
        lvNotes.adapter = myNotesAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)

        val sv = menu!!.findItem(R.id.app_bar_search).actionView as SearchView
        val sm = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        sv.setSearchableInfo(sm.getSearchableInfo(componentName))
        sv.setOnQueryTextListener(object: SearchView.OnQueryTextListener{

            override fun onQueryTextSubmit(query: String): Boolean {
                Toast.makeText(applicationContext,query,Toast.LENGTH_LONG).show()
                LoadQuery("%" + query + "%")
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                return false
            }

        })

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        if (item != null) {
            when(item.itemId){
                R.id.addNote->{
                    //Go to add page
                    var intent = Intent(this,AddNotes::class.java)
                    startActivity(intent)

                }

            }
        }

        return super.onOptionsItemSelected(item)
    }
    inner class MyNotesAdapter:BaseAdapter{

        var listNotesAdapter=ArrayList<Note>()
        var context:Context?=null

        constructor(context:Context,listNotesAdapter:ArrayList<Note>):super(){
            this.listNotesAdapter=listNotesAdapter
            this.context=context
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

            var myView = layoutInflater.inflate(R.layout.ticket,null)
            var myNote = listNotesAdapter[p0]
            myView.tvTitle.text = myNote.noteName
            myView.tvDesc.text = myNote.noteDes
            myView.tvDate.text = myNote.noteDate

            myView.ivDelete.setOnClickListener(View.OnClickListener {
                var dbManager=DbManager(this.context!!)
                val selectionArgs = arrayOf(myNote.noteID.toString())
                dbManager.Delete("ID = ?", selectionArgs)
                LoadQuery("%")
            })

            myView.ivEdit.setOnClickListener(View.OnClickListener {
                GoToUpdate(myNote)
            })
            return myView
        }

        override fun getItem(p0: Int): Any {
            return listNotesAdapter[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getCount(): Int {
            return listNotesAdapter.size
         }


    }

    fun GoToUpdate(note:Note){
        var intent = Intent(this,AddNotes::class.java)
        intent.putExtra("ID",note.noteID)
        intent.putExtra("name",note.noteName)
        intent.putExtra("des",note.noteDes)
        startActivity(intent)
    }
}

package com.mrhgroups.grab

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.work.*
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.mrhgroups.grab.workmanager.MyWorker


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()*/
            val data: Data =Data.Builder()
                .putString(MyWorker.TASK_DESC, "The task data passed from MainActivity")
                .build()
            val constraints= Constraints.Builder().setRequiresCharging(true).build()
            val workRequest= OneTimeWorkRequestBuilder<MyWorker>().setInputData(data).setConstraints(constraints).build()
            WorkManager.getInstance(this).enqueue(workRequest)
            WorkManager.getInstance(this).getWorkInfoByIdLiveData(workRequest.id).observe(
                this,
                Observer { workInfo ->
                    if (workInfo.state == WorkInfo.State.SUCCEEDED) {
                        Toast.makeText(this, workInfo.state.name, Toast.LENGTH_LONG).show()
                    }
                })

        }
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
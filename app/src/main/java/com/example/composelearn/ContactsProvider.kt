package com.example.composelearn

import android.database.Cursor
import android.os.Bundle
import android.provider.ContactsContract
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.composelearn.ui.theme.ComposeLearnTheme
import android.content.ContentResolver
import android.content.Context
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.core.content.ContextCompat
import android.Manifest
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat

class ContactProvider : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeLearnTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val manager = ContactManager(this)
                    val contacts = manager.getContacts()
                    LazyColumn {
                        items(contacts){

                            Text(text = "${it.name} - ${it.number}")
                        }
                    }
                }
            }
        }
    }
}




class ContactManager(private val context: Context) {

    fun getContacts(): List<Contact> {

        // Check if the READ_CONTACTS permission is granted
        if (ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.READ_CONTACTS
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // Request the permission if not granted
            ActivityCompat.requestPermissions(
                context as ComponentActivity,
                arrayOf(Manifest.permission.READ_CONTACTS),
                1
            )
        }
        val contacts = mutableListOf<Contact>()

        // Define the columns you want to retrieve
        val projection = arrayOf(
            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
            ContactsContract.CommonDataKinds.Phone.NUMBER
        )

        // Query the Contacts Provider
        val contentResolver: ContentResolver = context.contentResolver
        val cursor: Cursor? = contentResolver.query(
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            projection,
            null,
            null,
            null
        )

        // Iterate through the cursor and retrieve contact information
        cursor?.use {
            while (it.moveToNext()) {
                val nameIndex = it.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)
                val numberIndex = it.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)

                val name = it.getString(nameIndex)
                val number = it.getString(numberIndex)

                val contact = Contact(name, number)
                contacts.add(contact)
            }
        }

        return contacts
    }
}

data class Contact(val name: String, val number: String)


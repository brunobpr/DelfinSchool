package app.getitright.com.example.android.delfinschool;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Button to open the facabook page
    public void facebook(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("https://www.facebook.com/delfinenglishschool/"));
        startActivity(intent);
    }

    //Button to open the instagram
    public void instagram(View view){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("https://www.instagram.com/delfinschool/"));
        startActivity(intent);
    }

    //Button to open the youtube channel
    public void youtube(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("https://www.youtube.com/user/delfinenglishschool"));
        startActivity(intent);
    }

    //Clickable textview to open the website
    public void website(View view){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("https://www.delfinschool.com"));
        startActivity(intent);
    }

    //Clickable textview to reveal the contact fields
    public void contactUs(View view) {
        LinearLayout contactLlt = (LinearLayout) findViewById(R.id.contactUsField);
        contactLlt.setVisibility(View.VISIBLE);
    }

    //Button to sent the message
    public void sendMessage(View view) {
        //Initiating the views
        EditText nameUser = (EditText) findViewById(R.id.name_user);
        EditText emailUser = (EditText) findViewById(R.id.email_user);
        EditText messageUser = (EditText) findViewById(R.id.message_user);
        //Set variables with strings from the editviews
        String name = nameUser.getText().toString();
        String message = messageUser.getText().toString();
        String email = emailUser.getText().toString();
        String emailDelfin = "delfinschool@gmail.com";
        //Intent to open a email app and send the message
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_EMAIL, email);
        intent.putExtra(Intent.ACTION_SEND, emailDelfin);
        intent.putExtra(Intent.EXTRA_TEXT, message);
        intent.putExtra(Intent.EXTRA_SUBJECT, "Email from " + name);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }
}
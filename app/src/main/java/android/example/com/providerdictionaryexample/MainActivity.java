package android.example.com.providerdictionaryexample;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.UserDictionary;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;


public class MainActivity extends ActionBarActivity {
    Uri mDictionaryWordsUri;
    //TextView mDictTextView;
    ListView mDictListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //mDictTextView = (TextView) findViewById(R.id.dictionary_contents);
        mDictListView = (ListView) findViewById(R.id.dictionary_contents);

        Uri dic = UserDictionary.Words.CONTENT_URI;
        ContentResolver resolver = getContentResolver();
        Cursor cursor = resolver.query(dic,null, null, null, null);


        String[] columnsToBeBound = new String[] {
                UserDictionary.Words.WORD,
                UserDictionary.Words.FREQUENCY
        };

        int[] layoutItemsToFill = new int[] {
                android.R.id.text1,
                android.R.id.text2
        };


        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
                android.R.layout.two_line_list_item,
                cursor,
                columnsToBeBound,
                layoutItemsToFill,
                0);


        mDictListView.setAdapter(adapter);




        //mDictTextView.setText("");

        /*while (cursor.moveToNext()) {
            int wordColumn = cursor.getColumnIndex(UserDictionary.Words.WORD);
            int frequencyColumn = cursor.getColumnIndex(UserDictionary.Words.FREQUENCY);
            int idColumn = cursor.getColumnIndex(UserDictionary.Words._ID);
            String word = cursor.getString(wordColumn);
            int frequency = cursor.getInt(frequencyColumn);
            int id = cursor.getInt(idColumn);
            mDictTextView.append(("\n" + id + " " + word + " : " + frequency));

        }*/


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

package br.ufc.dc.dspm.mynotes;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Iterator;
import java.util.List;

public class MyNotes extends Activity {
    private NoteDAO noteDAO;
    EditText titleText;
    EditText contentText, idNoteText;
    DatePicker datePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_notes);
        noteDAO = new NoteDAO(this);


        datePicker = (DatePicker) findViewById(R.id.datepicker);
        idNoteText = (EditText) findViewById(R.id.idnote);
         titleText = (EditText) findViewById(R.id.editTextTitle);
         contentText = (EditText) findViewById(R.id.editTextContent);

    }

    public void addNote(View view) {
        Note note = new Note();
        note.setTitle(titleText.getText().toString());
        note.setContent(contentText.getText().toString());
        note.setDateByString(datePicker.getDayOfMonth() + "/" + datePicker.getMonth() + "/" + datePicker.getYear()+ "/");
        noteDAO.create(note);

        List<Note> notes = noteDAO.list();
        Iterator<Note> it = notes.iterator();
        StringBuffer buffer = new StringBuffer();
        while (it.hasNext()) {
            note = it.next();
            buffer.append(note.toString());
            buffer.append("\n");
        }
        TextView list = (TextView) findViewById(R.id.textViewNotes);
        list.setText(buffer.toString());

    }

    public void editNote(View v){
        if(idNoteText.getText().toString().length()>0) {
            Note note = new Note();
            note.setId(Integer.parseInt(idNoteText.getText().toString()));
            note.setTitle(titleText.getText().toString());
            note.setContent(contentText.getText().toString());
            note.setDateByString(datePicker.getDayOfMonth() + "/" + datePicker.getMonth() + "/" + datePicker.getYear() + "/");
            noteDAO.update(note);

            List<Note> notes = noteDAO.list();
            Iterator<Note> it = notes.iterator();
            StringBuffer buffer = new StringBuffer();
            while (it.hasNext()) {
                note = it.next();
                buffer.append(note.toString());
                buffer.append("\n");
            }
            TextView list = (TextView) findViewById(R.id.textViewNotes);
            list.setText(buffer.toString());
        }
        else{
            Toast.makeText(this, "Digite o ID", Toast.LENGTH_LONG).show();
        }
    }

}

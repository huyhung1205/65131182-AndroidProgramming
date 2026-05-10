package hyhung.noteapp;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import hyhung.noteapp.models.Note;

public class AddNoteActivity extends AppCompatActivity {

    private EditText editTextName, editTextMessage;
    private Button buttonSave;
    private DatabaseReference databaseReference;
    private Note existingNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        editTextName = findViewById(R.id.editTextName);
        editTextMessage = findViewById(R.id.editTextMessage);
        buttonSave = findViewById(R.id.buttonSave);

        databaseReference = FirebaseDatabase.getInstance().getReference("notes");

        if (getIntent().hasExtra("note")) {
            existingNote = (Note) getIntent().getSerializableExtra("note");
            editTextName.setText(existingNote.getName());
            editTextMessage.setText(existingNote.getMessage());
            buttonSave.setText("Update Note");
            setTitle("Edit Note");
        } else {
            setTitle("Add Note");
        }

        buttonSave.setOnClickListener(v -> saveNote());
    }

    private void saveNote() {
        String name = editTextName.getText().toString().trim();
        String message = editTextMessage.getText().toString().trim();

        if (TextUtils.isEmpty(name)) {
            editTextName.setError("Name is required");
            return;
        }

        if (TextUtils.isEmpty(message)) {
            editTextMessage.setError("Message is required");
            return;
        }

        String date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault()).format(new Date());

        if (existingNote == null) {
            // Add new note
            String id = databaseReference.push().getKey();
            Note note = new Note(id, name, message, date, 1);
            if (id != null) {
                databaseReference.child(id).setValue(note)
                        .addOnSuccessListener(aVoid -> {
                            Toast.makeText(AddNoteActivity.this, "Note added", Toast.LENGTH_SHORT).show();
                            finish();
                        })
                        .addOnFailureListener(e -> Toast.makeText(AddNoteActivity.this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show());
            }
        } else {
            // Update existing note
            existingNote.setName(name);
            existingNote.setMessage(message);
            existingNote.setDate(date);

            databaseReference.child(existingNote.getId()).setValue(existingNote)
                    .addOnSuccessListener(aVoid -> {
                        Toast.makeText(AddNoteActivity.this, "Note updated", Toast.LENGTH_SHORT).show();
                        finish();
                    })
                    .addOnFailureListener(e -> Toast.makeText(AddNoteActivity.this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show());
        }
    }
}
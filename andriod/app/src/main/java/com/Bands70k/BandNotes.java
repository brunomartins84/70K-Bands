package com.Bands70k;

import android.os.Environment;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;

/**
 * Created by rdorn on 4/16/17.
 */

public class BandNotes {

    private String bandName;
    private File bandNoteFile;

    private boolean noteIsBlank = false;

    public BandNotes(String bandValue){

        bandName = bandValue;
        bandNoteFile = new File(showBands.newRootDir + FileHandler70k.directoryName + bandName + ".note");

    }

    public boolean fileExists(){
        return bandNoteFile.exists();
    }

    public boolean getNoteIsBlank(){
        return noteIsBlank;
    }

    public String getBandNote(){
        CustomerDescriptionHandler noteHandler = new CustomerDescriptionHandler();
        String bandNote = noteHandler.getDescription(bandName);

        return bandNote;

    }

    public String getBandNoteFromFile(){

        String note = "";
        try {

            BufferedReader br = new BufferedReader(new FileReader(bandNoteFile));

            String line;

            while ((line = br.readLine()) != null) {
                note += line + "<br>";
            }

            noteIsBlank = false;
        } catch (Exception error) {
            Log.e("writingBandRankings", "backupFile " + error.getMessage());
            note = "Comment text is not available yet. Please wait for Aaron to add his description. You can add your own if you choose, but when his becomes available it will not overwrite your data, and will not display.";

            noteIsBlank = true;
        }

        return note;
    }

    public void saveBandNote(String notesData){

        Log.d("saveNote", "attempting to write message " + notesData);
        if (notesData.startsWith("Comment text is not available yet") == false &&
                notesData.length() > 2) {

            notesData = notesData.replaceAll("\\n", "<br>");
            notesData = notesData.replaceAll("<br><br><br><br>", "<br><br>");

            Log.d("saveNote", "writing data to " + bandNoteFile + " - " + notesData);
            FileHandler70k.saveData(notesData, bandNoteFile);

            Log.d("saveNote", "Data saved for " + bandNoteFile);
        } else {
            bandNoteFile.delete();
        }

    }

}

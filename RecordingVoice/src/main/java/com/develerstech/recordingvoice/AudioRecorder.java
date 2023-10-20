package com.develerstech.recordingvoice;

import android.app.Activity;
import android.media.MediaRecorder;

public class AudioRecorder {
    private MediaRecorder mediaRecorder;
    private String outputFile;

    public AudioRecorder(Activity activity, String filename) {
        outputFile = activity.getExternalFilesDir(null).getAbsolutePath() + "/" + filename;
        mediaRecorder = new MediaRecorder();
        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        mediaRecorder.setOutputFile(outputFile);
    }

    public void startRecording() {
        try {
            mediaRecorder.prepare();
            mediaRecorder.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stopRecording() {
        mediaRecorder.stop();
        mediaRecorder.release();
    }

    public String getOutputFile() {
        return outputFile;
    }
}
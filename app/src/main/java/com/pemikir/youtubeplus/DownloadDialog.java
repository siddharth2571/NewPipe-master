package com.pemikir.youtubeplus;

import android.app.Dialog;
import android.app.DownloadManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;

import java.io.File;

/**
 * Created by Christian Schabesberger on 21.09.15.
 * <p/>
 * Copyright (C) Christian Schabesberger 2015 <chris.schabesberger@mailbox.org>
 * DownloadDialog.java is part of NewPipe.
 * <p/>
 * NewPipe is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p/>
 * NewPipe is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p/>
 * You should have received a copy of the GNU General Public License
 * along with NewPipe.  If not, see <http://www.gnu.org/licenses/>.
 */

public class DownloadDialog extends DialogFragment {
    public static final String TITLE = "name";
    public static final String FILE_SUFFIX_AUDIO = "file_suffix_audio";
    public static final String FILE_SUFFIX_VIDEO = "file_suffix_video";
    public static final String AUDIO_URL = "audio_url";
    public static final String VIDEO_URL = "video_url";
    private static final String TAG = DialogFragment.class.getName();
    Bundle arguments;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        arguments = getArguments();
        super.onCreateDialog(savedInstanceState);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.downloadDialogTitle)
                .setItems(R.array.downloadOptions, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Context context = getActivity();
                        SharedPreferences defaultPreferences = PreferenceManager.getDefaultSharedPreferences(context);
                        String suffix = "";
                        String title = arguments.getString(TITLE);
                        String url = "";
                        switch (which) {
                            case 0:     // Video
                                suffix = arguments.getString(FILE_SUFFIX_VIDEO);
                                url = arguments.getString(VIDEO_URL);
                                break;
                            case 1:
                                suffix = arguments.getString(FILE_SUFFIX_AUDIO);
                                url = arguments.getString(AUDIO_URL);
                                break;
                            default:
                                Log.d(TAG, "lolz");
                        }
                        DownloadManager dm = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
                        DownloadManager.Request request = new DownloadManager.Request(
                                Uri.parse(url));
                        request.setDestinationUri(Uri.fromFile(new File(
                                defaultPreferences.getString("download_path_preference", "/storage/emulated/0/NewPipe")
                                        + "/" + title + suffix)));
                        try {
                            dm.enqueue(request);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
        return builder.create();
    }

}

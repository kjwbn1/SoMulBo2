package com.example.joongwonkim.somulbo2.dbconnection;

import android.net.NetworkInfo;
import android.support.annotation.IntDef;

/**
 * Sample interface containing bare minimum methods needed for an asynchronous task
 * to update the UI Context.
 */

public interface DownloadCallback {
    interface Progress {
        int ERROR = -1;
        int CONNECT_SUCCESS = 0;
        int GET_INPUT_STREAM_SUCCESS = 1;
        int PROCESS_INPUT_STREAM_IN_PROGRESS = 2;
        int PROCESS_INPUT_STREAM_SUCCESS = 3;
    }

    /**
     * Indicates that the callback handler needs to update its appearance or information based on
     * the result of the task. Expected to be called from the main thread.
     */
    void updateFromDownload(String result);

    NetworkInfo getActiveNetworkInfo();
    /**
     * Get the device's active network status in the form of a NetworkInfo object.
     */


}

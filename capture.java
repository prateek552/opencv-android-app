package com.example.prateekbajaj.opencv;

import com.example.prateekbajaj.opencv.*;
import android.graphics.Bitmap;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.opencv.android.Utils;
import org.opencv.core.CvException;
import org.opencv.core.Mat;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * Created by Prateek bajaj on 15-08-2017.
 */

public class capture extends AppCompatActivity{
    void clickcapture(Mat subimg) {

        File sd = new File(Environment.getExternalStorageDirectory().toString()+File.separator+"/pb");
        boolean success = true;
        if (!sd.exists()) {
                sd.mkdir();
        }
       /* if (success) {
            File dest = new File(sd, filename);

            try {
                out = new FileOutputStream(dest);
                bmp.compress(Bitmap.CompressFormat.PNG, 100, out); // bmp is your Bitmap instance
                // PNG is a lossless format, the compression factor (100) is ignored

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (out != null) {
                        out.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
       /* Bitmap bmp = null;
        try {
            bmp = Bitmap.createBitmap(subimg.cols(), subimg.rows(), Bitmap.Config.ARGB_8888);
            Utils.matToBitmap(subimg, bmp);
        } catch (CvException e) {
        }

        subimg.release();
        String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

        FileOutputStream out = null;

        String filename = "Pic" + " " + timestamp + ".jpg";

        Log.i(tag,Environment.getExternalStorageDirectory().toString());

        File sd = new File(Environment.getExternalStorageDirectory().toString() + File.separator+"TheCameraApp");
        if(!sd.exists())
        {
            sd.mkdir();
        }
        File file = new File(sd, filename);
        try {
            out = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.JPEG, 100, out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
    }
    }



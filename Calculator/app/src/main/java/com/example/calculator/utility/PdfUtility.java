package com.example.calculator.utility;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.os.Build;
import android.os.Environment;
import android.util.Log;
import android.view.View;

import androidx.annotation.RequiresApi;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

public class PdfUtility {

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static String printPDF(String data) {
        String extstoragedir = Environment.getExternalStorageDirectory().toString();
        File fol = new File(extstoragedir, "Documents");
        /*
        File folder=new File(fol,"Documents");
        if(!folder.exists()) {
            boolean bool = folder.mkdir();
        }
        */
        try {
            //Log.i("PDF", fol.toString() + " " + folder.toString());
            Date d = new Date();
            final File file = new File(fol, d + ".pdf");
            file.createNewFile();
            FileOutputStream fOut = new FileOutputStream(file);

            PdfDocument document = new PdfDocument();
            int width = (int) Math.round(72*8.27);
            int height = (int) Math.round(72*11.69);
            PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(width, height, 1).create();
            PdfDocument.Page page = document.startPage(pageInfo);
            Canvas canvas = page.getCanvas();
            Paint paint = new Paint();

            canvas.drawText(data, 10, 10, paint);
            canvas.drawText(data, 10, 30, paint);

            document.finishPage(page);
            document.writeTo(fOut);
            document.close();

        } catch (IOException e) {
            Log.i("PDF error",e.getLocalizedMessage());
        }

        return extstoragedir;
    }


}

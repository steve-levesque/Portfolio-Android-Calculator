package com.example.calculator.utilities;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.graphics.pdf.PdfDocument.Page;
import android.graphics.pdf.PdfDocument.PageInfo;
import android.os.Build;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import androidx.annotation.RequiresApi;

import com.example.calculator.models.CalculatorItem;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Utility class
 * Generates PDF files on the device.
 */
public class PdfUtility {
    private static String folder = "Documents";
    private static String extPath = Environment.getExternalStorageDirectory().toString();
    private static String extension = ".pdf";

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static String printPDF(List<CalculatorItem> items) {
        File fol = new File(extPath, folder);

        try {
            Date date = new Date();
            final File file = new File(fol, date + extension);
            file.createNewFile();
            FileOutputStream fOut = new FileOutputStream(file);

            PdfDocument document = new PdfDocument();
            int width = (int) Math.round(72*8.27);
            int height = (int) Math.round(72*11.69);
            PageInfo pageInfo = new PageInfo.Builder(width, height, 1).create();
            Page page = document.startPage(pageInfo);
            Canvas canvas = page.getCanvas();
            Paint paint = new Paint();

            int initialLineSkip = 50;
            int lineskip = 10;
            int itemskip = lineskip*3;
            int itemsPerPage = 25;
            int counter = initialLineSkip, counterIdx = 1;
            for (CalculatorItem item : items) {
                canvas.drawText(item.id + ": " + item.content, 10, counter, paint);
                canvas.drawText(item.details, lineskip, counter + lineskip, paint);

                counterIdx++;
                counter += itemskip;

                // Create a new page when the current one is full.
                // At the same time, reopens a new FileOutputStream to dodge data saturation problems.
                if (counter % (itemskip*itemsPerPage+initialLineSkip) == 0) {
                    Log.i("PDF","Reached at item id: "+item.id + ", Items list size: " + items.size());
                    document.finishPage(page);
                    document.writeTo(fOut);
                    page = document.startPage(pageInfo);
                    canvas = page.getCanvas();
                    paint = new Paint();
                    counter = initialLineSkip;
                    fOut.close();
                    fOut = new FileOutputStream(file);
                }
            }

            Log.i("PDF","Counter = "+counter);

            document.finishPage(page);
            document.writeTo(fOut);
            document.close();

        } catch (IOException e) {
            Log.i("PDF error",e.getLocalizedMessage());
        }

        return fol.toString();
    }
}

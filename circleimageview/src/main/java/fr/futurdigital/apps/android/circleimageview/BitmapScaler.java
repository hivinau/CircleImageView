package fr.futurdigital.apps.android.circleimageview;

import android.graphics.Bitmap;

/**
 * <br>
 * <i>This class is for smartcar app</i>
 * <br>
 * <br>
 * Class : <b>BitmapScaler</b>
 * <br>
 * Subject : BitmapScaler utility class to resize a bitmap but preserve the aspect ratio
 *
 * @author Hivinau GRAFFE
 * @version 1.0
 *
 * Created by Hivinau on 12/11/2015.
 */
public class BitmapScaler {

    /**
     * Scale and maintain aspect ratio given a desired width
     * @param b bitmap to scale
     * @param width desired width
     * @return scaled bitmap
     */
    @SuppressWarnings({"unused"})
    public static Bitmap scaleToFitWidth(Bitmap b, int width)
    {
        float factor = width / (float) b.getWidth();
        return Bitmap.createScaledBitmap(b, width, (int) (b.getHeight() * factor), true);
    }


    /**
     * Scale and maintain aspect ratio given a desired height
     * @param b bitmap to scale
     * @param height desired height
     * @return scaled bitmap
     */
    @SuppressWarnings({"unused"})
    public static Bitmap scaleToFitHeight(Bitmap b, int height)
    {
        float factor = height / (float) b.getHeight();
        return Bitmap.createScaledBitmap(b, (int) (b.getWidth() * factor), height, true);
    }

}

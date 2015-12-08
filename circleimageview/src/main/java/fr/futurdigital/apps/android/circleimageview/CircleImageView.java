package fr.futurdigital.apps.android.circleimageview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * <br>
 * <i>This class is for smartcar app</i>
 * <br>
 * <br>
 * Class : <b>TextView</b>
 * <br>
 * Subject : load custom font
 *
 * @author Hivinau GRAFFE
 * @version 1.0
 *
 * Created by Hivinau on 12/11/2015.
 */
public class CircleImageView extends ImageView {
    private static final int DEFAULT_FILL_COLOR = Color.parseColor("#FFFFFF");

    private int mFillColor = DEFAULT_FILL_COLOR;

    /**
     * Constructor : initialize a new instance of {@link CircleImageView}
     *
     * @param context context
     */
    public CircleImageView(Context context) {
        super(context);

        initFillColor(null);
    }

    /**
     * Constructor : initialize a new instance of {@link CircleImageView}
     *
     * @param context context
     * @param attrs attrs
     */
    public CircleImageView(Context context, AttributeSet attrs) {
        super(context, attrs);

        initFillColor(attrs);
    }

    /**
     * Constructor : initialize a new instance of {@link CircleImageView}
     *
     * @param context context
     * @param attrs attrs
     * @param defStyleAttr defStyleAttr
     */
    public CircleImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initFillColor(attrs);
    }

    /**
     * Constructor : initialize a new instance of {@link CircleImageView}
     *
     * @param context context
     * @param attrs attrs
     * @param defStyleAttr defStyleAttr
     * @param defStyleRes defStyleRes
     */
    @SuppressWarnings({"unused"})
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CircleImageView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    /**
     * Init default value of color
     * @param attrs a collection of attributes associated with xml
     */
    private void initFillColor(AttributeSet attrs){
        if (attrs == null) {
            this.mFillColor = DEFAULT_FILL_COLOR;
        } else {
            TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.CircleImageView, 0, 0);

            this.mFillColor = a.getColor(R.styleable.CircleImageView_fill_color, DEFAULT_FILL_COLOR);

            a.recycle();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {

        Drawable drawable = getDrawable();

        if (drawable == null) {
            return;
        }

        if (getWidth() == 0 || getHeight() == 0) {
            return;
        }
        Bitmap b = ((BitmapDrawable) drawable).getBitmap();
        Bitmap bitmap = b.copy(Bitmap.Config.ARGB_8888, true);

        int w = getWidth(), h = getHeight();

        Bitmap roundBitmap = getRoundedCroppedBitmap(bitmap, w, h);
        canvas.drawBitmap(roundBitmap, 0, 0, null);

    }

    /**
     * Round a bitmap with specifics dimension
     * @param bitmap bitmap to round
     * @param width specific width
     * @param height specific heigth
     * @return new bitmap rounded
     */
    private Bitmap getRoundedCroppedBitmap(Bitmap bitmap, int width, int height) {
        Bitmap finalBitmap;
        if (bitmap.getWidth() != width || bitmap.getHeight() != height)
            finalBitmap = Bitmap.createScaledBitmap(bitmap, width, height, false);
        else
            finalBitmap = bitmap;

        Bitmap output = Bitmap.createBitmap(finalBitmap.getWidth(), finalBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, finalBitmap.getWidth(), finalBitmap.getHeight());

        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setDither(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(this.mFillColor);
        canvas.drawCircle(finalBitmap.getWidth() / 2 + 0.7f,
                finalBitmap.getHeight() / 2 + 0.7f,
                finalBitmap.getWidth() / 2 + 0.1f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));

        canvas.drawBitmap(bitmap, rect, rect, paint);

        return output;
    }
}

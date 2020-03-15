package esaph.spotlight.Esaph.EsaphCurvedTopNavigation;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import java.util.concurrent.atomic.AtomicInteger;

public class EsaphRoundedCirclesLogoLayoutHolder extends RelativeLayout
{
    private EsaphRoundedCirclesLogoView esaphRoundedCirclesLogoView;

    public EsaphRoundedCirclesLogoLayoutHolder(Context context)
    {
        super(context);
        init(context);
    }

    public EsaphRoundedCirclesLogoLayoutHolder(Context context, @Nullable AttributeSet attrs)
    {
        super(context, attrs);
        init(context);
    }

    public EsaphRoundedCirclesLogoLayoutHolder(Context context, @Nullable AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @RequiresApi(21)
    public EsaphRoundedCirclesLogoLayoutHolder(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes)
    {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private int getDP(Context context, int num)
    {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                num, context.getResources().getDisplayMetrics());
    }

    private static final AtomicInteger sNextGeneratedId = new AtomicInteger(1);
    public static int generateViewId()
    {
        for (;;)
        {
            final int result = sNextGeneratedId.get();
            // aapt-generated IDs have the high byte nonzero; clamp to the range under that.
            int newValue = result + 1;
            if (newValue > 0x00FFFFFF) newValue = 1; // Roll over to 1, not 0.
            if (sNextGeneratedId.compareAndSet(result, newValue))
            {
                return result;
            }
        }
    }

    private void init(Context context)
    {
        setWillNotDraw(false);
        LayoutParams layoutParamsProgressBar = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);

        esaphRoundedCirclesLogoView = new EsaphRoundedCirclesLogoView(context);
        esaphRoundedCirclesLogoView.enableShader(true);

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1)
        {
            esaphRoundedCirclesLogoView.setId(generateViewId());
        }
        else
        {
            esaphRoundedCirclesLogoView.setId(View.generateViewId());
        }

        addView(esaphRoundedCirclesLogoView, 0, layoutParamsProgressBar);
        setVisibility(VISIBLE);
    }

    @Override
    protected void removeDetachedView(View child, boolean animate)
    {
        super.removeDetachedView(child, false);
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
    }

    public void setEsaphShader(EsaphSwipeShader esaphShader)
    {
        esaphRoundedCirclesLogoView.setEsaphShader(esaphShader);
    }

    public interface ColorChangeCallback
    {
        void onTintChanged(int color);
    }

    public void addColorChangedListener(ColorChangeCallback colorChangeCallback) {
        esaphRoundedCirclesLogoView.addColorChangedListener(colorChangeCallback);
    }
}
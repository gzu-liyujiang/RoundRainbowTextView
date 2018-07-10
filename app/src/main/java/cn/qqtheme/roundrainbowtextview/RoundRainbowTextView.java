package cn.qqtheme.roundrainbowtextview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.util.AttributeSet;

/**
 * 带渐变边框的彩虹字，参阅 https://blog.csdn.net/gxp1182893781/article/details/78179248 及 http://blog.csdn.net/jack__frost/article/details/52279374
 * <p>
 * Created by liyujiang on 2018/7/9 18:24.
 */
public class RoundRainbowTextView extends android.support.v7.widget.AppCompatTextView {
    private static final int[] GRADIENT_COLORS = {0xFFE64433, 0xFFFDB628};
    private static final float BORDER_WIDTH = 1f;//dp
    private static final float BORDER_RADIUS = 3f;//dp
    private boolean drawBorder = true;
    private int[] borderColors = GRADIENT_COLORS;
    private float borderWidth = BORDER_WIDTH;
    private float borderRadius = BORDER_RADIUS;
    private int textWidth;
    private LinearGradient shader;
    private Rect rect;
    private RectF rectF;

    public RoundRainbowTextView(Context context) {
        super(context);
    }

    public RoundRainbowTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public RoundRainbowTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setBorder(float width, float radius) {
        setBorder(width, radius, GRADIENT_COLORS);
    }

    public void setBorder(float width, float radius, int[] colors) {
        this.drawBorder = width > 0;
        this.borderWidth = width;
        this.borderRadius = radius;
        this.borderColors = colors;
        invalidate();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (textWidth == 0) {
            textWidth = getMeasuredWidth();
        }
        if (shader == null) {
            shader = new LinearGradient(0, 0, textWidth, 0,
                    borderColors, null, Shader.TileMode.CLAMP);
        }
        if (textWidth > 0) {
            //得到父类中写字的那支笔，并套上线性渲染器
            TextPaint paint = getPaint();
            //设置渐变背景
            paint.setShader(shader);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //绘制渐变圆角边框
        if (textWidth > 0 && drawBorder) {
            canvas.save();
            TextPaint paint = getPaint();
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(dip2Px(borderWidth));
            if (rect == null) {
                rect = new Rect();
            }
            canvas.getClipBounds(rect);
            if (rectF == null) {
                rectF = new RectF(rect);
            }
            float radius = dip2Px(borderRadius);
            canvas.drawRoundRect(rectF, radius, radius, paint);
            canvas.restore();
        }
    }

    private float dip2Px(float dip) {
        float density = getResources().getDisplayMetrics().density;
        return dip * density + .5f;
    }

}

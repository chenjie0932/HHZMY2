package com.hhzmy.propertyanimation;

import android.animation.TypeEvaluator;

/**
 * Created by johpo on 2016/11/11 0011.
 */
public class FloatEvaluator implements TypeEvaluator {
    public Object evaluate(float fraction, Object startValue, Object endValue) {
               float startFloat = ((Number) startValue).floatValue();
                return startFloat + fraction * (((Number) endValue).floatValue() - startFloat);
         }

}

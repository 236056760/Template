package com.lvbo.template.common.Utils;

import android.graphics.Bitmap;
import android.widget.ImageView;

import com.bumptech.glide.request.target.BitmapImageViewTarget;

/**
 * Created by action on 16/8/3.
 */
public class ImageFitCenter extends BitmapImageViewTarget {
    public ImageFitCenter(ImageView view) {
        super(view);
    }

    @Override
    protected void setResource(Bitmap resource) {

        view.setScaleType(ImageView.ScaleType.FIT_CENTER);
        super.setResource(resource);
//        super.setResource(ImageUtils.upImageSize(view.getContext(),resource,resource.getWidth(),resource.getHeight()));
////        view.setImageBitmap(ImageUtils.upImageSize(view.getContext(),resource,resource.getWidth(),resource.getHeight()));
    }
}

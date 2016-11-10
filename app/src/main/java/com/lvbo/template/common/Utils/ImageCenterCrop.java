package com.lvbo.template.common.Utils;

import android.graphics.Bitmap;
import android.widget.ImageView;

import com.bumptech.glide.request.target.BitmapImageViewTarget;

/**按最大的比例放大，配合center_crop一起使用
 * Created by action on 16/8/3.
 */
public class ImageCenterCrop extends BitmapImageViewTarget {
    public ImageCenterCrop(ImageView view) {
        super(view);
    }

    @Override
    protected void setResource(Bitmap resource) {

        view.setScaleType(ImageView.ScaleType.CENTER_CROP);
        super.setResource(resource);
//        super.setResource(ImageUtils.upImageSize(view.getContext(),resource,resource.getWidth(),resource.getHeight()));
//        view.setImageBitmap(ImageUtils.upImageSize(view.getContext(),resource,resource.getWidth(),resource.getHeight()));
    }
}

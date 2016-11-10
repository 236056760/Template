package com.lvbo.template.common.Utils;

import android.net.Uri;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

/**
 * Created by Action on 16/8/3.
 */
public class ImageLoadUtil {

    public static void loadImg(ImageView v, int url) {
        Glide.with(v.getContext())
                .load(url)
                .centerCrop()
                .into(v);
    }

    public static void loadImg(ImageView v, String url) {
        Glide.with(v.getContext())
                .load(url)
                .centerCrop()
                .into(v);
    }
    public static void loadImg(ImageView v, Uri url) {
        Glide.with(v.getContext())
                .load(url)
                .centerCrop()
                .into(v);
    }

    public static void loadImg(ImageView v, byte[] url) {
        Glide.with(v.getContext())
                .load(url)
                .centerCrop()
                .into(v);
    }


    /***loadimgWithDefault**/

    public static void loadimgWithDefault(ImageView v, int url,int defaultImgId) {
        Glide.with(v.getContext())
                .load(url)
                .centerCrop()
                .placeholder(defaultImgId)
                .into(v);
    }

    public static void loadimgWithDefault(ImageView v, String url,int defaultImgId) {
        Glide.with(v.getContext())
                .load(url)
                .centerCrop()
                .placeholder(defaultImgId)
                .into(v);
    }
    public static void loadimgWithDefault(ImageView v, Uri url,int defaultImgId) {
        Glide.with(v.getContext())
                .load(url)
                .centerCrop()
                .placeholder(defaultImgId)
                .into(v);
    }

    public static void loadimgWithDefault(ImageView v, byte[] url,int defaultImgId) {
        Glide.with(v.getContext())
                .load(url)
                .centerCrop()
                .placeholder(defaultImgId)
                .into(v);
    }





    public static void loadFitCenter(ImageView v, byte[] url) {
        Glide.with(v.getContext())
                .load(url)
                .fitCenter()
                .into(v);
    }



    public static void loadCenterCropImg(ImageView v, String url, int placeImg, int errorImg) {
        Glide.with(v.getContext())
                .load(url)
                .asBitmap()
                .centerCrop()
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(placeImg)
                .error(errorImg)
                .into(v);
    }

    public static void loadRoundAndBgImg(ImageView v, String url, int placeImg, int errorImg) {
        Glide.with(v.getContext())
                .load(url)
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .asBitmap()
                .transform(new CircleTransform(v.getContext()))
                .placeholder(placeImg)
                .error(errorImg)
                .into(new ImageCenterCrop(v));
    }

}

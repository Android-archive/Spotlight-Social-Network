/*
 *  Copyright (C) Esaph, Julian Auguscik - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *  * Written by Julian Auguscik <esaph.re@gmail.com>, March  2020
 *
 */

package esaph.spotlight.Esaph.EsaphPhoneGalleryUtils.utility;

import android.net.Uri;
import android.provider.MediaStore;

public class Constants {
    public static final int sScrollbarAnimDuration = 300;
    public static String[] PROJECTION = new String[]{
            MediaStore.Images.Media.DATA,
            MediaStore.Images.Media._ID,
            MediaStore.Images.Media.BUCKET_DISPLAY_NAME,
            MediaStore.Images.Media.BUCKET_ID,
            MediaStore.Images.Media.DATE_TAKEN,
            MediaStore.Images.Media.DATE_ADDED,
            MediaStore.Images.Media.DATE_MODIFIED,
    };
    public static Uri URI = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
    public static String ORDERBY = MediaStore.Images.Media.DATE_TAKEN + " DESC";

}

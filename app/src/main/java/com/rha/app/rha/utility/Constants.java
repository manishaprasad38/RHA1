package com.rha.app.rha.utility;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.rha.app.rha.R;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import okhttp3.ResponseBody;
import retrofit2.Response;

public class Constants {
    public static void printErrorBody(final String tag, Response<?> response, int responseCode) {
        try {
            ResponseBody errorBody = response.errorBody();
            if (errorBody != null) {
                Log.e(tag, "failure response code :- " + responseCode);
                Log.e(tag, "failure :- " + errorBody.string());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void failure(final String tag, Throwable throwable) {
        Log.e(tag, "failure :- " + throwable.getMessage());
    }

    public static Bitmap decodeUri(Context context, Uri selectedImage) throws FileNotFoundException {
        // Decode image size
        // Decode image size
        BitmapFactory.Options o = new BitmapFactory.Options();
        o.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(context.getContentResolver().openInputStream(selectedImage), null, o);

        // The new size we want to scale to
        final int REQUIRED_SIZE = 100;

        // Find the correct scale value. It should be the power of 2.
        int width_tmp = o.outWidth, height_tmp = o.outHeight;
        int scale = 1;
        while (true) {
            if (width_tmp / 2 < REQUIRED_SIZE
                    || height_tmp / 2 < REQUIRED_SIZE) {
                break;
            }
            width_tmp /= 2;
            height_tmp /= 2;
            scale *= 2;
        }

        // Decode with inSampleSize
        BitmapFactory.Options o2 = new BitmapFactory.Options();
        o2.inSampleSize = scale;
        return BitmapFactory.decodeStream(context.getContentResolver().openInputStream(selectedImage), null, o2);
    }

    public static String getPathFromURI(Context context, Uri contentUri) {
        String res = null;
        String[] proj = {MediaStore.Images.Media.DATA};
        Cursor cursor = context.getContentResolver().query(contentUri, proj, null, null, null);
        if (cursor.moveToFirst()) {
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            res = cursor.getString(column_index);
        }
        cursor.close();
        return res;
    }

    public static String getBase64String(String extension, byte[] imageArray) {
        String encodeString = "";
        try {
            if (imageArray != null && imageArray.length > 0)
                encodeString = "data:image/" + extension + ";base64," + Base64.encodeToString(imageArray, Base64.DEFAULT);// | Base64.NO_WRAP | Base64.URL_SAFE
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encodeString;
    }

    public static void showToast(Context context, String message, boolean isShort) {
        if (isShort)
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

    public static void initializeToolBar(AppCompatActivity activity, Toolbar toolbar,
                                         String title, final AppInterface.ToolbarListener listener) {
        try {
            if (toolbar != null) {
                toolbar.setTitle(title);
                activity.setSupportActionBar(toolbar);
                activity.getSupportActionBar().setDisplayShowHomeEnabled(true);
                if (listener != null) {
                    toolbar.setNavigationIcon(R.drawable.ic_drawer);
                    toolbar.setNavigationOnClickListener(
                            new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    listener.onToolbarBack();
                                }
                            }
                    );
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void showProgressDialog(Context context, String message) {
        ProgressDialog dialog = new ProgressDialog(context);
        dialog.setMessage(message);
        dialog.show();

    }

    private void hideProgressDialog(ProgressDialog dialog) {
        dialog.dismiss();
    }


    public static boolean isValidMobile(String phone) {

        return android.util.Patterns.PHONE.matcher(phone).matches();
    }


    public static boolean isEmailValid(String email) {
        boolean isValid = false;
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = email;
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }

    public static String getDeviceToken(Context context) {
        String android_id = Settings.Secure.getString(context.getContentResolver(),
                Settings.Secure.ANDROID_ID);
        return android_id;
    }

    public static void setStringPreferences(Context context, int prefName, String key, String value) {
        SharedPreferences prefrence = context.getSharedPreferences(context.getResources().getString(prefName), 0);
        SharedPreferences.Editor editor = prefrence.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static void setIntPreferences(Context context, int prefName, String key, int value) {
        SharedPreferences prefrence = context.getSharedPreferences(context.getResources().getString(prefName), 0);
        SharedPreferences.Editor editor = prefrence.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    public static void setBooleanPreferences(Context context, int prefName, String key, boolean value) {
        SharedPreferences prefrence = context.getSharedPreferences(context.getResources().getString(prefName), 0);
        SharedPreferences.Editor editor = prefrence.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    public static String getStringPreferences(Context context, int prefName, String key) {
        SharedPreferences prefrence = context.getSharedPreferences(context.getResources().getString(prefName), 0);
        String data = prefrence.getString(key, "");
        return data;
    }

    public static int getIntPreferences(Context context, int prefName, String key) {
        SharedPreferences prefrence = context.getSharedPreferences(context.getResources().getString(prefName), 0);
        int data = prefrence.getInt(key, 0);
        return data;
    }

    public static boolean getBooleanPreferences(Context context, int prefName, String key) {
        SharedPreferences prefrence = context.getSharedPreferences(context.getResources().getString(prefName), 0);
        boolean data = prefrence.getBoolean(key, false);
        return data;
    }

    public static void clearPreference(Context context, int prefName) {
        SharedPreferences mySPrefs = context.getSharedPreferences(context.getResources().getString(prefName), 0);
        SharedPreferences.Editor editor = mySPrefs.edit();
        editor.clear();
        editor.commit();
    }

    public static void removeKeyPreference(Context context, int prefName, String key) {
//        SharedPreferences mySPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences mySPrefs = context.getSharedPreferences(context.getResources().getString(prefName), 0);
        SharedPreferences.Editor editor = mySPrefs.edit();
        editor.remove(key);
        editor.apply();
    }

    public static void switchActivity(final AppCompatActivity activity, final Class<?> switchActivity,
                                      final boolean isToolbar) {
        try {
            if (isToolbar) {
                activity.startActivity(new Intent(activity, switchActivity));
                activity.finish();
//                activity.overridePendingTransition(R.anim.exit_animation_enter_from_right,
//                        R.anim.exit_animation_leave_to_right);
            } else {
                activity.startActivity(new Intent(activity, switchActivity));
                activity.finish();
//                activity.overridePendingTransition(R.anim.animation_enter_from_right,
//                        R.anim.animation_leave_out_to_left);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

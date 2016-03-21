package com.wehubs.weservice.Utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import java.util.regex.Pattern;

/**
 * Created by Telvin on 21/12/15.
 */
public class CommonUtilities {
	public static final String COMMON_PREFE = "ComAPP";
	// adapted from post by Phil Haack and modified to match better
	public final static String tagStart =
			"\\<\\w+((\\s+\\w+(\\s*\\=\\s*(?:\".*?\"|'.*?'|[^'\"\\>\\s]+))?)+\\s*|\\s*)\\>";
	public final static String tagEnd =
			"\\</\\w+\\>";
	public final static String tagSelfClosing =
			"\\<\\w+((\\s+\\w+(\\s*\\=\\s*(?:\".*?\"|'.*?'|[^'\"\\>\\s]+))?)+\\s*|\\s*)/\\>";
	public final static String htmlEntity =
			"&[a-zA-Z][a-zA-Z0-9]+;";
	public final static Pattern htmlPattern = Pattern.compile(
			"(" + tagStart + ".*" + tagEnd + ")|(" + tagSelfClosing + ")|(" + htmlEntity + ")",
			Pattern.DOTALL
	);
	/**
	 * Check whether the given edit text contains the given number of letters.
	 * If not it will change its background
	 *
	 * @param editText   EditText to be validated
	 * @param minLetters Minimum character count
	 * @return whether it is valid or not
	 */
	public static boolean validateEditText(EditText editText, int minLetters) {
		return !changeEditTextBg(editText, editText.getText().toString().trim().length() < minLetters);
	}

	public static boolean validateEditTextField(EditText editText, int minLetters) {
		return (editText.getText().toString().trim().length() < minLetters);
	}
	/**
	 * Changes the background of EditText v based on isError. If isError is
	 * true, background will be with red border.
	 *
	 * @param v
	 * @param isError
	 * @return isError for the ease of some comparisons
	 */
	public static boolean changeEditTextBg(View v, boolean isError) {
		if (isError) {
		//	v.setBackgroundResource(R.drawable.edit_text_red_border);
		} else {
		//	v.setBackgroundResource(R.drawable.edit_text);
		}
		return isError;
	}
	/**
	 * Checks whether the given email address is valid, based on a regular
	 * expression. Note that this is not 100% correct, there may be a few valid
	 * email addresses which this regular expression can't detect. Also, this
	 * method checks for format only, there is no guarantee on the actual
	 * existence of the given email address.
	 *
	 * @param mEmailId Email address to be validated
	 * @return whether the given email address is valid or not
	 */
	public static boolean validateEmailAddress(String mEmailId) {
		return Pattern.compile("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$").matcher(mEmailId).matches();
	}
	/**
	 * Initializing SharedPreferences
	 *
	 * @param context {@link Context}
	 * @return {@link SharedPreferences}
	 */
	private static SharedPreferences createSharedPreferences(Context context, String type) {
		return context.getSharedPreferences(type, Context.MODE_PRIVATE);
	}

	/**
	 * Store default String value to {@link SharedPreferences}
	 *
	 * @param context {@link Context}
	 * @param key     {@link String}
	 * @param value   {@link String}
	 */
	public static void setStringSharedPreference(Context context, String key, String value) {
		SharedPreferences.Editor edit = createSharedPreferences(context, COMMON_PREFE).edit();
		edit.putString(key, value);
		edit.commit();
	}

	/**
	 * Get String values from default {@link SharedPreferences}
	 *
	 * @param context {@link Context}
	 * @param key     {@link String}
	 * @return {@link String}
	 */
	public static String getStringSharedPreference(Context context, String key) {
		return createSharedPreferences(context, COMMON_PREFE).getString(key, "");
	}

	/**
	 * Store default String value to {@link SharedPreferences}
	 *
	 * @param context {@link Context}
	 * @param key     {@link String}
	 * @param value   {@link int}
	 */
	public static void setIntSharedPreference(Context context, String key, int value) {
		SharedPreferences.Editor edit = createSharedPreferences(context, COMMON_PREFE).edit();
		edit.putInt(key, value);
		edit.commit();
	}

	/**
	 * Get String values from default {@link SharedPreferences}
	 *
	 * @param context {@link Context}
	 * @param key     {@link String}
	 * @return {@link int}
	 */
	public static int getIntSharedPreference(Context context, String key) {
		return createSharedPreferences(context, COMMON_PREFE).getInt(key, 0);
	}

	/**
	 * Store default String value to {@link SharedPreferences}
	 *
	 * @param context {@link Context}
	 * @param key     {@link String}
	 * @param value   {@link boolean}
	 */
	public static void setBooleanSharedPreference(Context context, String key, boolean value) {
		SharedPreferences.Editor edit = createSharedPreferences(context, COMMON_PREFE).edit();
		edit.putBoolean(key, value);
		edit.commit();
	}

	public static boolean getBooleanSharedPreference(Context context, String key) {
		SharedPreferences preferences = createSharedPreferences(context, COMMON_PREFE);
		boolean values = preferences.getBoolean(key, false);
		return values;
	}

	/**
	 * store float values to {@link SharedPreferences}
	 *
	 * @param context
	 * @param key
	 * @param value
	 */
	public static void setFloatSharedPreference(Context context, String key, float value) {
		SharedPreferences.Editor edit = createSharedPreferences(context, COMMON_PREFE).edit();
		edit.putFloat(key, value);
		edit.commit();
	}

	public static float getFloatSharedPreference(Context context, String key) {
		SharedPreferences preferences = createSharedPreferences(context, COMMON_PREFE);
		float values = preferences.getFloat(key, 0f);
		return values;
	}


	public static boolean isStringNullOrEmpty(String character) {
		return (character == null || character.isEmpty());
	}

	/**
	 * Will return true if s contains HTML markup tags or entities.
	 *
	 * @param s String to test
	 * @return true if string contains HTML
	 */
	public static boolean isHtml(String s) {
		boolean ret = false;
		if (s != null) {
			ret = htmlPattern.matcher(s).find();
		}
		return ret;
	}

	public static void clearCache(Context context) {
		SharedPreferences.Editor edit = createSharedPreferences(context, COMMON_PREFE).edit();
		edit.clear();
		edit.commit();

	}


	public static int getWidth(Activity activity) {
		DisplayMetrics metrics = new DisplayMetrics();
		activity.getWindowManager().getDefaultDisplay().getMetrics(metrics);
		return metrics.widthPixels;
	}
	/**
	 * Check if there is any connectivity
	 *
	 * @return
	 */
	public static  boolean isNetworkAvailable(Context context) {
		if (context != null) {
			boolean result = true;
			ConnectivityManager connectivityManager = (ConnectivityManager) context
					.getSystemService(Context.CONNECTIVITY_SERVICE);
			NetworkInfo networkInfo = connectivityManager
					.getActiveNetworkInfo();
			if (networkInfo == null || !networkInfo.isConnectedOrConnecting()) {
				result = false;
			}
			return result;
		} else {
			return false;
		}
	}

	/**
	 * hide keyBoard :-HIDE_IMPLICIT_ONLY property means if hides ,again
	 * function is called it shown
	 */
	public static void hideKeyBoard(Activity activity) {
		if (activity != null) {
			InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
			imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
		}

	}

	/**
	 * Show keyBoard :-SHOW_IMPLICIT property means if shown ,again function is
	 * called it hides
	 */
	public static void showKeyBoard(Activity activity) {
		InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT, 0);
	}
}

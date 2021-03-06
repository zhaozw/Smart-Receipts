package wb.receiptslibrary;

import java.util.Currency;

import android.content.SharedPreferences;

public class Preferences {
	
	//Preference Identifiers - Global
    private static final String SMART_PREFS = "SmartReceiptsPrefFile";
    private static final String INT_DEFAULT_TRIP_DURATION = "TripDuration";
    private static final String STRING_DEFAULT_EMAIL_TO = "EmailTo";
    private static final String STRING_USERNAME = "UserName";
    private static final String BOOL_PREDICT_CATEGORIES = "PredictCats";
    private static final String BOOL_MATCH_COMMENT_WITH_CATEGORIES = "MatchCommentCats";
    private static final String BOOL_MATCH_NAME_WITH_CATEGORIES = "MatchNameCats";
    private static final String BOOL_USE_NATIVE_CAMERA = "UseNativeCamera";
    private static final String BOOL_ACTION_SEND_SHOW_HELP_DIALOG = "ShowHelpDialog";
    private static final String BOOL_ONLY_INCLUDE_EXPENSABLE_ITEMS ="OnlyIncludeExpensable";
    private static final String BOOL_INCLUDE_TAX_FIELD ="IncludeTaxField";
    private static final String BOOL_ENABLE_AUTOCOMPLETE_SUGGESTIONS ="EnableAutoCompleteSuggestions";
    private static final String STRING_CURRENCY = "isocurr";
    private static final String FLOAT_MIN_RECEIPT_PRICE = "MinReceiptPrice";
	
	//Preference Instance Variables
    private boolean predictCategories, matchCommentCats, matchNameCats, useNativeCamera, onlyIncludeExpensable, showActionSendHelpDialog, includeTaxField, enableAutoCompleteSuggestions;
    private String emailTo, currency, userID;
    private int defaultTripDuration;
    private float minReceiptPrice;
    
    //Other Instance Variables
    private SmartReceiptsActivity activity;
    
    Preferences(SmartReceiptsActivity activity) {
		this.activity = activity;
		SharedPreferences prefs = activity.getSharedPreferences(SMART_PREFS, 0);
		this.defaultTripDuration = prefs.getInt(INT_DEFAULT_TRIP_DURATION, 3);
		this.minReceiptPrice = prefs.getFloat(FLOAT_MIN_RECEIPT_PRICE, -Float.MAX_VALUE);
		this.emailTo = prefs.getString(STRING_DEFAULT_EMAIL_TO, "");
		this.predictCategories = prefs.getBoolean(BOOL_PREDICT_CATEGORIES, true);
		this.useNativeCamera = prefs.getBoolean(BOOL_USE_NATIVE_CAMERA, false);
		this.matchCommentCats = prefs.getBoolean(BOOL_MATCH_COMMENT_WITH_CATEGORIES, false);
		this.matchNameCats = prefs.getBoolean(BOOL_MATCH_NAME_WITH_CATEGORIES, false);
		this.onlyIncludeExpensable = prefs.getBoolean(BOOL_ONLY_INCLUDE_EXPENSABLE_ITEMS, true);
		this.showActionSendHelpDialog = prefs.getBoolean(BOOL_ACTION_SEND_SHOW_HELP_DIALOG, true);
		this.includeTaxField = prefs.getBoolean(BOOL_INCLUDE_TAX_FIELD, false);
		this.enableAutoCompleteSuggestions = prefs.getBoolean(BOOL_ENABLE_AUTOCOMPLETE_SUGGESTIONS, true);
		this.userID = prefs.getString(STRING_USERNAME, "");
    	try {
    		this.currency = prefs.getString(STRING_CURRENCY, Currency.getInstance(SRUtils.LOCALE).getCurrencyCode());
    	} catch (IllegalArgumentException ex) {
    		this.currency = "USD";
		}
	}
    
    public void commit() {
    	SharedPreferences prefs = activity.getSharedPreferences(SMART_PREFS, 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(INT_DEFAULT_TRIP_DURATION, defaultTripDuration);
        editor.putFloat(FLOAT_MIN_RECEIPT_PRICE, minReceiptPrice);
        editor.putString(STRING_DEFAULT_EMAIL_TO, emailTo);
        editor.putString(STRING_CURRENCY, currency);
        editor.putBoolean(BOOL_PREDICT_CATEGORIES, predictCategories);
        editor.putBoolean(BOOL_USE_NATIVE_CAMERA, useNativeCamera);
        editor.putBoolean(BOOL_MATCH_NAME_WITH_CATEGORIES, matchNameCats);
        editor.putBoolean(BOOL_MATCH_COMMENT_WITH_CATEGORIES, matchCommentCats);
        editor.putBoolean(BOOL_ONLY_INCLUDE_EXPENSABLE_ITEMS, onlyIncludeExpensable);
        editor.putBoolean(BOOL_ACTION_SEND_SHOW_HELP_DIALOG, showActionSendHelpDialog);
        editor.putBoolean(BOOL_INCLUDE_TAX_FIELD, includeTaxField);
        editor.putBoolean(BOOL_ENABLE_AUTOCOMPLETE_SUGGESTIONS, enableAutoCompleteSuggestions);
        editor.putString(STRING_USERNAME, userID);
        editor.commit();
    }

    //Getters & Setters are below
    
	public boolean predictCategories() {
		return predictCategories;
	}

	public void setPredictCategories(boolean predictCategories) {
		this.predictCategories = predictCategories;
	}

	public boolean matchCommentToCategory() {
		return matchCommentCats;
	}

	public void setMatchCommentToCategory(boolean matchCommentCats) {
		this.matchCommentCats = matchCommentCats;
	}

	public boolean matchNameToCategory() {
		return matchNameCats;
	}

	public void setMatchNameToCategory(boolean matchNameCats) {
		this.matchNameCats = matchNameCats;
	}

	public boolean useNativeCamera() {
		return useNativeCamera;
	}

	public void setUseNativeCamera(boolean useNativeCamera) {
		this.useNativeCamera = useNativeCamera;
	}

	public boolean onlyIncludeExpensableReceiptsInReports() {
		return onlyIncludeExpensable;
	}

	public void setOnlyIncludeExpensableReceiptsInReports(boolean onlyIncludeExpensable) {
		this.onlyIncludeExpensable = onlyIncludeExpensable;
	}
	
	public boolean includeTaxField() {
		return includeTaxField;
	}

	public void setIncludeTaxField(boolean includeTaxField) {
		this.includeTaxField = includeTaxField;
	}
	
	public boolean enableAutoCompleteSuggestions() {
		return enableAutoCompleteSuggestions;
	}

	public void setEnableAutoCompleteSuggestions(boolean enableAutoCompleteSuggestions) {
		this.enableAutoCompleteSuggestions = enableAutoCompleteSuggestions;
	}

	public String getDefaultEmailReceipient() {
		return emailTo;
	}

	public void setDefaultEmailReceipient(String emailTo) {
		this.emailTo = emailTo;
	}

	public String getDefaultCurreny() {
		return currency;
	}

	public void setDefaultCurreny(String currency) {
		this.currency = currency;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public int getDefaultTripDuration() {
		return defaultTripDuration;
	}

	public void setDefaultTripDuration(int defaultTripDuration) {
		this.defaultTripDuration = defaultTripDuration;
	}

	public float getMinimumReceiptPriceToIncludeInReports() {
		return minReceiptPrice;
	}

	public void setMinimumReceiptPriceToIncludeInReports(float minReceiptPrice) {
		this.minReceiptPrice = minReceiptPrice;
	}

	public boolean showActionSendHelpDialog() {
		return showActionSendHelpDialog;
	}

	public void setShowActionSendHelpDialog(boolean showActionSendHelpDialog) {
		this.showActionSendHelpDialog = showActionSendHelpDialog;
	}
    
}
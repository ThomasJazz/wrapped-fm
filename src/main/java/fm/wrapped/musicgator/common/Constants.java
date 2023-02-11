package fm.wrapped.musicgator.common;

public final class Constants {

    public static final String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
            "[a-zA-Z0-9_+&*-]+)*@" +
            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
            "A-Z]{2,7}$";
    public static final String COMMENT_TYPE_REQUEST_DESCRIPTION = "Request Description";
    public static final String DATE_FORMAT_YYYY_MM_DD = "yyyy-MM-dd HH:mm:ss.SSS"; //2022-12-12 14:00:17.499
    public static final String ORGANIZATION = "ORGANIZATION";
    public static final String SYNONYM_HEADER = "x-synonym";
    public static final String CUSTOMER = "customer";
    public static final String COUNTRY = "country";
    public static final String AUTHORIZATION = "authorization";
    public static final String REQUEST_OBJECT_TYPE = "REQUEST";
    public static final String DEFAULT_ORG_NAME = "GWS Enterprise";
    public static final String SE_SLA_RESPONSE_VALUES = "responseValues";
    public static final String UTC_DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";
}

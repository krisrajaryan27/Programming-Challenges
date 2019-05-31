package com.nirvana.learning.moneytap.bitcoinsummary.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import java.util.Locale;

public class CustomMessageSource {

    @Autowired
    MessageSource messageSource;

    private static final Locale LOCALE = Locale.ENGLISH;

    /*
     * Constructor
     *
     */

    public CustomMessageSource() {
    }

    public String getMessage(String code) {
        return messageSource.getMessage(code, null, LOCALE);
    }

    public String getMessage(String code, Object[] args) {
        return messageSource.getMessage(code, args, LOCALE);
    }

    public String getMessage(String code, Object[] args, String defaultMessage) {
        return messageSource.getMessage(code, args, defaultMessage, LOCALE);
    }

    public String getMessage(String code, String defaultMessage) {
        return messageSource.getMessage(code, null, defaultMessage, LOCALE);
    }
}

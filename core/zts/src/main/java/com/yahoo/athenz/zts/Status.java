//
// This file generated by rdl 1.5.2. Do not modify!
//

package com.yahoo.athenz.zts;
import com.yahoo.rdl.*;

//
// Status - The representation for a status object
//
public class Status {
    public int code;
    public String message;

    public Status setCode(int code) {
        this.code = code;
        return this;
    }
    public int getCode() {
        return code;
    }
    public Status setMessage(String message) {
        this.message = message;
        return this;
    }
    public String getMessage() {
        return message;
    }

    @Override
    public boolean equals(Object another) {
        if (this != another) {
            if (another == null || another.getClass() != Status.class) {
                return false;
            }
            Status a = (Status) another;
            if (code != a.code) {
                return false;
            }
            if (message == null ? a.message != null : !message.equals(a.message)) {
                return false;
            }
        }
        return true;
    }
}

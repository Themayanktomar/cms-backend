package com.example.cms.utility;

import jakarta.servlet.http.HttpSession;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Utility {


    public String getUserInfo(HttpSession session) {
        return (String) session.getAttribute("ADMIN_ID");
    }
}

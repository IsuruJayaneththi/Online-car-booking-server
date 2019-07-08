package com.example.issa.pdm_project_2018_server.Common;

import com.example.issa.pdm_project_2018_server.Model.User;

public class Common {

    public static User currentUser;

    public static final String UPDATE = "Update";
    public static final String DELETE = "Delete";

    public static final int PICK_IMAGE_REQUEST = 71;


    public static String convertCodeToStatus(String code)
    {
        if (code.equals("0"))
            return "Placed";
        else
            return "On my way";
    }

    public static String convertCode1ToStatus(String code)
    {
        if (code.equals("0"))
            return "Placed";
        else
            return "Seen";
    }

}

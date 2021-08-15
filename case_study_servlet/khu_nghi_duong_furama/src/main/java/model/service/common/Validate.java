package model.service.common;

public class Validate {
    private static final String REGEX_CUSTOMER_CODE = "^(KH)-[0-9]{4}$";
    private static final String REGEX_SERVICE_CODE = "^(DV)-[0-9]{4}$";
    private static final String REGEX_PHONE_NUMBER = "^(090|091|\\(84\\)\\+90|\\(84\\)\\+91)[0-9]{7}$";
    private static final String REGEX_ID_CARD = "[0-9]{9}|[0-9]{12}";
    private static final String REGEX_EMAIL = "^[a-z]+((_|\\.)?[a-z 0-9]+)?@[a-z]*\\.[a-z]{2,3}$";

    public static String validateCustomerCode(String customerCode){
        String message = null;
        if (!customerCode.matches(REGEX_CUSTOMER_CODE)){
            message = "Mã Khách hàng có định dạng là KH-XXXX (X là số từ 0-9)";
        }
        return message;
    }

    public static String validateServiceCode(String serviceCode){
        String message = null;
        if (!serviceCode.matches(REGEX_SERVICE_CODE)){
            message = "Mã Dịch vụ có định dạng là DV-XXXX (X là số 0-9)";
        }
        return message;
    }

    public static String validatePhoneNumber(String phone){
        String message = null;
        if (!phone.matches(REGEX_PHONE_NUMBER)){
            message = "Số điện thoại phải đúng định dạng 090xxxxxxx hoặc 091xxxxxxx hoặc (84)+90xxxxxxx hoặc (84)+91xxxxxxx";
        }
        return message;
    }

    public static String validateIdCard(String phone){
        String message = null;
        if (!phone.matches(REGEX_ID_CARD)){
            message = "Số CMND phải đúng định dạng XXXXXXXXX hoặc XXXXXXXXXXXX (X là số 0-9)";
        }
        return message;
    }

    public static String validateEmail(String phone){
        String message = null;
        if (!phone.matches(REGEX_EMAIL)){
            message = "Địa chỉ email phải đúng định dạng email";
        }
        return message;
    }

    public static String validateNumber(int number){
        String message = null;
        if (number < 0){
            message = "Vui lòng nhập số dương";
        }
        return message;
    }

    public static String validateAmount(double number){
        String message = null;
        if (number < 0){
            message = "Vui lòng nhập số dương";
        }
        return message;
    }
}

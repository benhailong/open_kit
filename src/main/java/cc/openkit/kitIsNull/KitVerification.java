package cc.openkit.kitIsNull;


import cc.openkit.common.KitUtil;

import java.util.HashMap;
import java.util.Map;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

public class KitVerification {

    /**
     * 对象字段校验方法
     * @param model
     * @return
     */
    public static Map<String,Object> verification(Object model){
        Map<String,Object> map = new HashMap<>();

        // 1. 获取对象Class
        Class c = model.getClass();
        // 遍历所有的对象
        Field[] fArray = c.getDeclaredFields();

        for(Field field : fArray){

            // 拿到字段的名
            String filedName = field.getName();
            String getMethodName = "get"+filedName.substring(0,1).toUpperCase()+filedName.substring(1);
            // 拿到字段的值
            Object filedValue = null;
            try {
                Method getMethod = c.getMethod(getMethodName);
                filedValue = getMethod.invoke(model);
            } catch (Exception e) {
                e.printStackTrace();
            }

            // 查看是不是验证非空
            boolean fExists = field.isAnnotationPresent(KitIsNull.class);
            // 如果是ISnull说明不能为空，那就直接找到他的get里边的内容看看是不是为空
            if(fExists){
                // 判断值是不是为空，如果为空则直接返回
                if(filedValue==null || "".equals(filedValue)){
                    // 如果为空，说明不符合，返回值
                    KitIsNull isNull = (KitIsNull) field.getAnnotation(KitIsNull.class);
                    String msg = isNull.value();
                    map = KitUtil.returnMap("101",msg);
                    return map;
                }
                continue;
            }

            // 如果可以为空
            if(filedValue==null||"".equals(filedValue)){
                continue;
            }

            // 查看是不是验证手机号码
            boolean kitIsPhoneExists = field.isAnnotationPresent(KitIsPhone.class);
            if(kitIsPhoneExists){
                // 判断值是不是为空，如果为空则直接返回
                if(!isMobile(String.valueOf(filedValue))){
                    // 如果为空，说明不符合，返回值
                    KitIsPhone isNull = (KitIsPhone) field.getAnnotation(KitIsPhone.class);
                    String msg = isNull.value();
                    map = KitUtil.returnMap("101",msg);
                    return map;
                }
                continue;
            }

            // 查看是不是邮箱
            boolean kitIsEmailExists = field.isAnnotationPresent(KitIsEmail.class);
            if(kitIsEmailExists){
                // 验证是不是邮箱
                if(!isEmail(String.valueOf(filedValue))){
                    // 如果为空，说明不符合，返回值
                    KitIsEmail isNull = (KitIsEmail) field.getAnnotation(KitIsEmail.class);
                    String msg = isNull.value();
                    map = KitUtil.returnMap("101",msg);
                    return map;
                }
                continue;
            }

            // 查看是不是身份证号码
            boolean kitIsCodeExists = field.isAnnotationPresent(KitIsCode.class);
            if(kitIsCodeExists){
                // 验证是不是邮箱
                if(!isIDCard(String.valueOf(filedValue))){
                    // 如果为空，说明不符合，返回值
                    KitIsCode isNull = (KitIsCode) field.getAnnotation(KitIsCode.class);
                    String msg = isNull.value();
                    map = KitUtil.returnMap("101",msg);
                    return map;
                }
                continue;
            }

            // 查看长度是否合法
            boolean kitIsLongExists = field.isAnnotationPresent(KitIsLong.class);
            if(kitIsLongExists){
                KitIsLong isNull = (KitIsLong) field.getAnnotation(KitIsLong.class);
                int min = isNull.min();
                int max = isNull.max();

                Boolean f = false;
                if(min==-1 && max!=-1){
                    f = String.valueOf(filedValue).length()<max;
                }
                if(min!=-1 && max==-1){
                    f = String.valueOf(filedValue).length()>min;
                }
                if(min==-1 && max==-1){
                    f = true;
                }
                if(min!=-1 && max!=-1){
                    f = String.valueOf(filedValue).length()>min && String.valueOf(filedValue).length()<max;
                }

                // 验证是不是邮箱
                if(!f){
                    // 如果为空，说明不符合，返回值
                    String msg = isNull.value();
                    map = KitUtil.returnMap("101",msg);
                    return map;
                }
                continue;
            }

            // 查看是不是网站
            boolean kitIsUrlExists = field.isAnnotationPresent(KitIsUrl.class);
            if(kitIsUrlExists){
                // 验证是不是邮箱
                if(!isUrl(String.valueOf(filedValue))){
                    // 如果为空，说明不符合，返回值
                    KitIsUrl isNull = (KitIsUrl) field.getAnnotation(KitIsUrl.class);
                    String msg = isNull.value();
                    map = KitUtil.returnMap("101",msg);
                    return map;
                }
                continue;
            }

            // 查看是不是其他
            boolean kitIsOtherExists = field.isAnnotationPresent(KitIsOther.class);
            KitIsOther isNull = (KitIsOther) field.getAnnotation(KitIsOther.class);
            if(kitIsOtherExists){
                // 验证是不是邮箱
                boolean a = isOther(isNull.rule(),String.valueOf(filedValue));
                System.out.println("a = "+a);

                if(!isOther(isNull.rule(),String.valueOf(filedValue))){
                    // 如果为空，说明不符合，返回值
                    String msg = isNull.value();
                    map = KitUtil.returnMap("101",msg);
                    return map;
                }
                continue;
            }
        }

        map = KitUtil.returnMap("200","");
        return map;
    }


    /**
     * 正则表达式：验证用户名
     */
    public static final String REGEX_USERNAME = "^[a-zA-Z]\\w{5,20}$";

    /**
     * 正则表达式：验证密码
     */
    public static final String REGEX_PASSWORD = "^[a-zA-Z0-9]{6,20}$";

    /**
     * 正则表达式：验证手机号
     */
    public static final String REGEX_MOBILE = "^((17[0-9])|(14[0-9])|(13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";

    /**
     * 正则表达式：验证邮箱
     */
    public static final String REGEX_EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";

    /**
     * 正则表达式：验证汉字
     */
    public static final String REGEX_CHINESE = "^[\u4e00-\u9fa5],{0,}$";

    /**
     * 正则表达式：验证身份证
     */
    public static final String REGEX_ID_CARD = "(^\\d{18}$)|(^\\d{15}$)";

    /**
     * 正则表达式：验证URL
     */
    public static final String REGEX_URL = "http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?";

    /**
     * 正则表达式：验证IP地址
     */
    public static final String REGEX_IP_ADDR = "^(1\\\\d{2}|2[0-4]\\\\d|25[0-5]|[1-9]\\\\d|[1-9])\\\\."
            +"(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
            +"(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
            +"(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.";

    /**
     * 校验用户名
     *
     * @param username
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isUsername(String username) {
        return Pattern.matches(REGEX_USERNAME, username);
    }

    /**
     * 校验密码
     *
     * @param password
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isPassword(String password) {
        return Pattern.matches(REGEX_PASSWORD, password);
    }

    /**
     * 校验手机号
     *
     * @param mobile
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isMobile(String mobile) {
        return Pattern.matches(REGEX_MOBILE, mobile);
    }

    /**
     * 校验邮箱
     *
     * @param email
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isEmail(String email) {
        return Pattern.matches(REGEX_EMAIL, email);
    }

    /**
     * 校验汉字
     *
     * @param chinese
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isChinese(String chinese) {
        return Pattern.matches(REGEX_CHINESE, chinese);
    }

    /**
     * 校验身份证
     *
     * @param idCard
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isIDCard(String idCard) {
        return Pattern.matches(REGEX_ID_CARD, idCard);
    }

    /**
     * 校验URL
     *
     * @param url
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isUrl(String url) {
        return Pattern.matches(REGEX_URL, url);
    }

    /**
     * 校验IP地址
     *
     * @param ipAddr
     * @return
     */
    public static boolean isIPAddr(String ipAddr) {
        return Pattern.matches(REGEX_IP_ADDR, ipAddr);
    }

    /**
     * 其他类型
     *
     * @param ipAddr
     * @param rule
     * @return
     */
    public static boolean isOther(String rule,String ipAddr) {
        return Pattern.matches(rule, ipAddr);
    }


}

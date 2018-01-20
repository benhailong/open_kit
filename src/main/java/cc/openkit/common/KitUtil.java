package cc.openkit.common;

import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.*;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * QQ交流群
 * 696279396
 */

public class KitUtil {
    /**
     * 测试是否调用成功
     * @return String
     */
    public static String hellow(){
        return "Hello openkit";
    }

    /**
     * Md5 加密工具
     * @param s   String   not null
     * @return 加密后的 MD5 值 32位大写的
     */
    public static String md5(String s) {
        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 时间格式化 data 转 String
     * @param date 时间
     * @param type 状态
     * @throws Exception 异常处理
     * @return data 时间
     */
    public static String dataToString(Date date, String type) throws Exception{
        SimpleDateFormat simpleFormat = null;
        simpleFormat = getSimpleDateFormat(type);
        return simpleFormat.format(date);
    }

    /**
     * 时间格式化 String 转 data
     * @param string 时间字符串
     * @param type 类型
     * @throws Exception 异常处理
     * @return date 时间
     */

    public static Date stringToData(String string,String type)throws Exception{
        SimpleDateFormat simpleFormat = null;
        Date date = null;
        simpleFormat = getSimpleDateFormat(type);
        date = simpleFormat.parse(string);
        return date;
    }

    /**
     * 生成随机数
     * @param type 你要几位的验证码 默认可以使用 2-8 位的验证码，type 非法，直接返回6位
     * @return 随机数
     */
    public static int randomNumber(int type){
        if(type==8){return (int)((Math.random()*9+1)*10000000);}
        if(type==7){return (int)((Math.random()*9+1)*1000000);}
        if(type==6){return (int)((Math.random()*9+1)*100000);}
        if(type==5){return (int)((Math.random()*9+1)*10000);}
        if(type==4){return (int)((Math.random()*9+1)*1000);}
        if(type==3){return (int)((Math.random()*9+1)*100);}
        if(type==2){return (int)((Math.random()*9+1)*10);}
        return (int)((Math.random()*9+1)*100000);
    }

    /**
     * 生成字母+数字（8位）随机数
     * @param length 长度
     * @return val 转换好的文本
     */
    public static String getStringRandom(int length) {
        String val = "";
        Random random = new Random();
        //length为几位密码
        for(int i = 0; i < length; i++) {
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            //输出字母还是数字
            if( "char".equalsIgnoreCase(charOrNum) ) {
                //输出是大写字母还是小写字母
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val += (char)(random.nextInt(26) + temp);
            } else if( "num".equalsIgnoreCase(charOrNum) ) {
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }

    /**
     * 计算两个时间之间的时间
     * @param start   开始时间
     * @param end  结束时间
     * @param type 计算 1：分钟  2：小时  3：天
     * @return 时间差
     */
    public static int timeDifference(Date start, Date end, int type){
        int figure=0;
        // 时间改成String
        long from1 = start.getTime();
        long to1 = end.getTime();
//        秒
        if(type==1){
            figure = (int) ((to1 - from1)/(1000));
        }
//        分钟
        if(type==2){
            figure = (int) ((to1 - from1)/(1000 * 60));
        }
//        小时
        if(type==3){
            figure = (int) ((to1 - from1)/(1000 * 60 * 60));
        }
//        天
        if(type==4){
            figure = (int) ((to1 - from1)/(1000 * 60 * 60 * 24));
        }
        return figure;
    }

    /**
     * 返回Map的集合
     * @param code 状态码
     * @param msg 说明
     * @return map Map 转换好的 map
     */
    public static Map<String, Object> returnMap(String code, String msg){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code",code);
        map.put("msg",msg);
        return map;
    }

    /**
     * UUID
     * @return 返回没有'-'的 UUID
     */

    public static String uuid(){
        String uuid = UUID.randomUUID().toString();
        return uuid.replaceAll("-","");
    }

    /**
     * 订单编号
     * @return s2 String 生成的订单编号
     */
    public static String getOrderCode() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        int a = (int)(Math.random()*(9999-1000+1))+1000;
        System.out.println(a);
        Date date = new Date();
        String str = sdf.format(date);
        String[] split = str.split("-");
        String s = split[0] + split[1] + split[2];
        String[] split1 = s.split(" ");
        String s1 = split1[0] + split1[1];
        String[] split2 = s1.split(":");
        String s2 = split2[0] + split2[1] + split2[2]+a;
        System.out.println(s2);
        return s2;
    }


    /**
     * 时间调用 时间格式
     * @param type 状态
     * @throws Exception 异常处理
     * @return simpleFormat 时间格式
     */
    private static SimpleDateFormat getSimpleDateFormat(String type) throws Exception{
        SimpleDateFormat simpleFormat;
        if("1".equals(type)){
            simpleFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");//如 2016-08-10 20:40
        } else if("2".equals(type)){
            simpleFormat = new SimpleDateFormat("yyyy-MM-dd");//如 2016-08-10
        } else if("3".equals(type)){
            simpleFormat = new SimpleDateFormat("yyyy/MM");//如 2016/09
        } else if("4".equals(type)){
            simpleFormat = new SimpleDateFormat("yyyyMMdd");//如 20160911
        } else if("5".equals(type)){
            simpleFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//如 2016/09/11 12:30:32
        } else if("6".equals(type)){
            simpleFormat = new SimpleDateFormat("yyyyMMddHHmmss");//如 201609111230
        } else if("7".equals(type)){
            simpleFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//如 2016/09/11 12:30
        } else if("8".equals(type)){
            simpleFormat = new SimpleDateFormat("HH:mm");//如 2016-08-10
        } else if("9".equals(type)){
            simpleFormat = new SimpleDateFormat("yyyy-MM-dd");//如 2016-08-10
        } else if("10".equals(type)){
            simpleFormat = new SimpleDateFormat("HH:mm");// 15:30
        } else if("11".equals(type)){
            simpleFormat = new SimpleDateFormat("yyyy-MM");//如 2016-08
        } else if("".equals(type)||type==null){
            simpleFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 默认以标准格式
        } else {
            simpleFormat = new SimpleDateFormat(type);// 否则，传什么现实什么
        }
        return simpleFormat;
    }

    /**
     * 去除指定字符
     * @param resource  字符串
     * @param ch  需要去除的字符  如：char c=' ';
     * @return 字符串
     */
    public static String remove(String resource,char ch) {
        StringBuffer buffer=new StringBuffer();
        int position=0;
        char currentChar;

        while(position<resource.length()) {
            currentChar=resource.charAt(position++);
            //如果当前字符不是要去除的字符，则将当前字符加入到StringBuffer中
            if(currentChar!=ch) {
                buffer.append(currentChar);
            }
        }
        return buffer.toString();
    }

    /**
     * 非空验证
     * @param string 需要验证的文字
     * @return Boolean 返回成功或者失败
     */
    public static Boolean feikong(Object string){
        if (string == null || "".equals(string)) {
            return false;
        }
        return true;
    }

    /**
     * 非空验证
     * @param map 需要验证的Map集合
     * @return Map 返回的验证结果
     */
    public static Map<String,Object> isNull(Map<String, Object> map){
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
            if(entry.getValue() == null || "".equals(entry.getValue())){
                return returnMap("300","参数："+entry.getKey()+" 不能为空！");
            }
        }
        return returnMap("200","");
    }

    /**
     * 将Javabean转换为Map
     *
     * @param javaBean  需要转换的 javaBean 对象
     * @return Map 转换好了的对象
     */
    public static Map toMap(Object javaBean) {
        Map result = new HashMap();
        Method[] methods = javaBean.getClass().getDeclaredMethods();
        for (Method method : methods) {
            try {
                if (method.getName().startsWith("get")) {
                    String field = method.getName();
                    field = field.substring(field.indexOf("get") + 3);
                    field = field.toLowerCase().charAt(0) + field.substring(1);

                    Object value = method.invoke(javaBean, (Object[]) null);
                    result.put(field, null == value ? "" : value.toString());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 将Json对象转换成Map
     *
     * @param jsonString json对象
     * @return result 最终的对象
     * @throws JSONException 异常处理
     */
    public static Map toMap(String jsonString) throws JSONException {
        JSONObject jsonObject = new JSONObject(jsonString);
        Map result = new HashMap();
        Iterator iterator = jsonObject.keys();
        String key = null;
        String value = null;
        while (iterator.hasNext()) {
            key = (String) iterator.next();
            value = jsonObject.getString(key);
            result.put(key, value);
        }
        return result;
    }

    /**
     * 将JavaBean转换成JSONObject（通过Map中转）
     *
     * @param bean javaBean
     * @return json对象
     */
    public static JSONObject toJSON(Object bean) {
        return new JSONObject(toMap(bean));
    }

    /**
     * 将Map转换成Javabean
     *
     * @param javabean
     *            javaBean
     * @param data
     *            Map数据
     * @return json对象
     */
    public static Object toJavaBean(Object javabean, Map data) {
        Method[] methods = javabean.getClass().getDeclaredMethods();
        for (Method method : methods) {
            try {
                if (method.getName().startsWith("set")) {
                    String field = method.getName();
                    field = field.substring(field.indexOf("set") + 3);
                    field = field.toLowerCase().charAt(0) + field.substring(1);
                    method.invoke(javabean, new Object[] {
                            data.get(field)
                    });
                }
            } catch (Exception e) {
            }
        }
        return javabean;
    }

    /**
     * 从最小值到最大值之间，随机取 N 个不重复的数字
     * @param min 最小值
     * @param max 最大值 (min,max]
     * @param num 个数
     * @return Set 最后生成的set集合
     */
    public static Set<Integer> mathMinToMaxAndNum(int min,int max,int num) {

        Set<Integer> set=new HashSet<Integer>();
        while(true){
            set.add((int)(Math.random()*(max-min)+min+1));
            if(set.size()==num){
                break;
            }
        }
        System.out.println(set);
        return set;
    }

    /**
     * 随机红包（部分有红包，部分没有）
     * @param num 红包总数
     * @param number 这是第几个
     * @param restHasNoMoney 已经拆开的没有钱的红包
     * @param scale 带红包的比例
     * @return Boolean 返回又还是没有
     */
    public static Boolean redPaper(int num, int number, int restHasNoMoney, float scale) {
        // 一共多少个带红包的数量
        int hasMoney = (int) Math.floor(num * scale);
//        System.out.println(hasMoney);
        // 一共多少个不带红包的数量
        int hasNoMoney = num-hasMoney;
        // 剩余不带红包的数量
        int surplusHasNoMoney = hasNoMoney - restHasNoMoney;
        // 剩余的带红包的数量  多少个带红包 - （总共被领取的 - 被领取的不带红包的）
        int surplusHasMoney = hasMoney - ( number - 1 - restHasNoMoney);
        // 所有剩余的
        int surplusAll = num-number+1;
        // 当剩余的不带红包的数量 >= 剩余红包数量，那么直接 生成没有钱
        if(surplusHasNoMoney >= (num-number+1) ){
            return false;
        }
        // 如果剩余没钱的为0，直接给钱
        if(surplusHasNoMoney==0){
            return true;
        }
        // 当剩余的不带红包的 < 所有的
        // 生成一个随机数 0 或者 1
        int i = (int)(Math.random()*(surplusAll-1)+1+1);
        if(i<=surplusHasMoney){
            // 如果数字 == 1，给他钱
            return true;
        }
        return false;
    }
}

package com.zqq.util;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author YunYang
 * @version 1.0
 * @createDate 2017/11/27
 * @modifyBy YunYang
 * @modifyDate 2017/11/27
 */
public class CommonUtils {


    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    public static boolean isEmpty(Object target) {
        if (target == null) {
            return true;
        } else if (target instanceof String) {
            return String.valueOf(target).trim().equals("");
        } else if (target instanceof Collection<?>) {
            return ((Collection<?>) target).isEmpty();
        } else if (target instanceof Object[]) {
            return ((Object[]) target).length == 0;
        } else {
            return false;
        }
    }

    public static boolean isNotEmpty(Object target) {
        return !isEmpty(target);
    }

    /**
     * 格式化日期（默认：yyyy-MM-dd HH:mm:ss）
     *
     * @param date 日期
     * @return
     */
    public static String formatDateToStr(Object date, String formart) {
        if (isEmpty(formart)) {
            formart = "yyyy-MM-dd HH:mm:ss";
        }
        boolean b = false;
        if (formart.contains("T")) {
            formart = formart.replace("T", " ");
            b = true;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(formart);
        String dateFormat = sdf.format(date);
        if (b) {
            dateFormat = dateFormat.replace(" ", "T");
        }

        return dateFormat;
    }


    /**
     * 格式化日期
     *
     * @param date    日期
     * @param formart 格式
     * @return 格式化后的日期
     * @throws ParseException
     */
    public static Date parseDate(String date, String formart) {
        if (isEmpty(formart)) {
            formart = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(formart);
        try {
            return sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Date formatDateToDate(Object date, String formart) {
        Date dateFormat = null;
        String dateStr = formatDateToStr(date, formart);
        if (isNotEmpty(dateStr)) {
            dateFormat = parseDate(dateStr, formart);
        }
        return dateFormat;
    }


    /**
     * 判断日期格式
     *
     * @param dateStr 日期字符串
     * @param formart 日期格式
     * @return
     */
    public static boolean isValidDate(String dateStr, String formart) {
        DateFormat formatter = new SimpleDateFormat(formart);
        try {
            Date date = (Date) formatter.parse(dateStr);
            return dateStr.equals(formatter.format(date));
        } catch (Exception e) {
            return false;
        }
    }


    /**
     * 获取两数相除的结果保留两位小数
     *
     * @param param1 被除数
     * @param param2 除数
     * @return
     */
    public static double division(String param1, String param2) {
        if (isEmpty(param2) || "0".equals(param2)) {
            return 0.00;
        }
        Double d1 = Double.valueOf(param1);
        Double d2 = Double.valueOf(param2);
        BigDecimal bd = new BigDecimal(d1 / d2);
        double result = bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        return result;
    }


    /**
     * 功能：得到当前月份月初 格式为：xxxx-yy-zz (eg: 2007-12-01)<br>
     *
     * @return String
     * @author pure
     */
    public static String thisMonth() {
        int x; // 日期属性：年
        int y; // 日期属性：月
        Calendar localTime = Calendar.getInstance(); // 当前日期
        String strY = null;
        x = localTime.get(Calendar.YEAR);
        y = localTime.get(Calendar.MONTH) + 1;
        strY = y >= 10 ? String.valueOf(y) : ("0" + y);
        return x + "-" + strY + "-01 00:00:00";
    }

    /**
     * 功能：得到当前月份月底 格式为：xxxx-yy-zz (eg: 2007-12-31)<br>
     *
     * @return String
     * @author pure
     */
    public static String thisMonthEnd() {
        int x; // 日期属性：年
        int y; // 日期属性：月
        Calendar localTime = Calendar.getInstance(); // 当前日期
        String strY = null;
        String strZ = null;
        boolean leap = false;
        x = localTime.get(Calendar.YEAR);
        y = localTime.get(Calendar.MONTH) + 1;
        if (y == 1 || y == 3 || y == 5 || y == 7 || y == 8 || y == 10 || y == 12) {
            strZ = "31";
        }
        if (y == 4 || y == 6 || y == 9 || y == 11) {
            strZ = "30";
        }
        if (y == 2) {
            leap = leapYear(x);
            if (leap) {
                strZ = "29";
            } else {
                strZ = "28";
            }
        }
        strY = y >= 10 ? String.valueOf(y) : ("0" + y);
        return x + "-" + strY + "-" + strZ + " 23:59:59";
    }

    /**
     * 功能：判断输入年份是否为闰年<br>
     *
     * @param year
     * @return 是：true 否：false
     * @author pure
     */
    private static boolean leapYear(int year) {
        boolean leap;
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0)
                    leap = true;
                else
                    leap = false;
            } else
                leap = true;
        } else
            leap = false;
        return leap;
    }

    /**
     * 计算两个日期相差的天数
     *
     * @param early 减数日期
     * @param late  被减日期
     * @return
     */
    public static int daysBetween(Date early, Date late) {
        Calendar calst = Calendar.getInstance();
        Calendar caled = Calendar.getInstance();
        calst.setTime(early);
        caled.setTime(late);
        // 设置时间为0时
        calst.set(Calendar.HOUR_OF_DAY, 0);
        calst.set(Calendar.MINUTE, 0);
        calst.set(Calendar.SECOND, 0);
        caled.set(Calendar.HOUR_OF_DAY, 0);
        caled.set(Calendar.MINUTE, 0);
        caled.set(Calendar.SECOND, 0);
        // 得到两个日期相差的天数
        int days = ((int) (caled.getTime().getTime() / 1000) - (int) (calst.getTime().getTime() / 1000)) / 3600 / 24;
        return days;
    }


    /**
     * 获取指定日期计算后的日期(分钟计算)
     *
     * @param _date 指定日期
     * @param _time 待计算的数(分)
     * @param flag  计算标示（加：ADDITIVE；减： MINUS）
     * @return
     */
    public static String getOppointDateMinute(Date _date, Integer _time, String flag) {
        Calendar c = Calendar.getInstance();
        c.setTime(_date);
        if ("ADDITIVE".equals(flag)) {
            c.add(Calendar.MINUTE, _time);
            return sdf.format(c.getTimeInMillis());
        } else if ("MINUS".equals(flag)) {
            c.add(Calendar.MINUTE, -_time);
            return sdf.format(c.getTimeInMillis());
        }
        return null;
    }

    /**
     * 获取指定日期计算后的日期(分钟计算)
     *
     * @param _date  指定日期
     * @param dayNum 相差天数
     * @param flag   计算标示（加：ADDITIVE；减： MINUS）
     * @return
     */
    public static String getOppointDateDay(Date _date, Integer dayNum, String flag) {
        Calendar c = Calendar.getInstance();
        c.setTime(_date);
        if ("ADDITIVE".equals(flag)) {
            c.add(Calendar.DATE, dayNum);
            return sdf.format(c.getTimeInMillis());
        } else if ("MINUS".equals(flag)) {
            c.add(Calendar.MINUTE, -dayNum);
            return sdf.format(c.getTimeInMillis());
        }
        return null;
    }

    /**
     * 获取当天开始时间
     *
     * @return
     */
    public static String getTodayStartTime() {
        Calendar todayStart = Calendar.getInstance();
        todayStart.set(Calendar.HOUR_OF_DAY, 0);
        todayStart.set(Calendar.MINUTE, 0);
        todayStart.set(Calendar.SECOND, 0);
        todayStart.set(Calendar.MILLISECOND, 0);
        return sdf.format(todayStart.getTimeInMillis());
    }

    /**
     * 获取当天结束时间
     *
     * @return
     */
    public static String getTodayEndTime() {
        Calendar todayStart = Calendar.getInstance();
        todayStart.set(Calendar.HOUR_OF_DAY, 23);
        todayStart.set(Calendar.MINUTE, 59);
        todayStart.set(Calendar.SECOND, 59);
        todayStart.set(Calendar.MILLISECOND, 999);
        return sdf.format(todayStart.getTimeInMillis());
    }

    /**
     * 手机号验证
     *
     * @param str 手机号
     * @return 验证通过返回true
     */
    public static boolean isMobile(String str) {
        return str.matches("^[1][3,4,5,7,8][0-9]{9}$");
    }

    /**
     * 格式化数字_保留${roundingMode}位小数,并去除多余的零
     *
     * @param number       待格式的数据
     * @param roundingMode 小数位数
     * @return
     */
    public static String formatNumberAddZero(String number, int roundingMode) {
        if ("" == number || null == number || number.equals("") || number.equals(null)) {
            number = "0";
        }
        BigDecimal b = new BigDecimal(number);
        number = b.setScale(roundingMode, BigDecimal.ROUND_HALF_UP).toString();
        if (number.indexOf(".") > 0) {
            number = number.replaceAll("[.]$", "");// 如最后一位是.则去掉
        }
        return number;
    }

    /**
     * 格式化数字_保留${roundingMode}位小数,并去除多余的零
     *
     * @param number       待格式的数据
     * @param roundingMode 小数位数
     * @return
     */
    public static String formatNumber(String number, int roundingMode) {

        BigDecimal b = new BigDecimal(number);
        number = b.setScale(roundingMode, BigDecimal.ROUND_HALF_UP).toString();
        if (number.indexOf(".") > 0) {
            number = number.replaceAll("0+?$", "");// 去掉多余的0
            number = number.replaceAll("[.]$", "");// 如最后一位是.则去掉
        }
        return number;
    }

    /**
     * 去掉小数多余的零
     *
     * @param number 小数
     * @return
     */
    public static String formatZero(String number) {
        if (number.indexOf(".") > 0) {
            number = number.replaceAll("0+?$", "");// 去掉多余的0
            number = number.replaceAll("[.]$", "");// 如最后一位是.则去掉
        }
        return number;
    }

    /**
     * 使用java正则表达式去掉多余的.与0
     *
     * @param s 待格式的数据
     * @return
     */
    public static String subZeroAndDot(String s) {
        if (s.indexOf(".") > 0) {
            s = s.replaceAll("0+?$", "");// 去掉多余的0
            s = s.replaceAll("[.]$", "");// 如最后一位是.则去掉
        }
        return s;
    }

    /**
     * 将一个字符串的首字母转为大写
     *
     * @param target 字符串
     * @return
     */
    public static String capitalize(String target) {
        if (target == null || target.length() == 0) {
            return target;
        }
        StringBuilder sb = new StringBuilder(target.length());
        sb.append(Character.toUpperCase(target.charAt(0)));
        sb.append(target.substring(1));
        return sb.toString();
    }

    /**
     * 校验字符串中是否含有中文或全角字符，是返回true,否则返回false
     *
     * @param str 待校验的字符串
     * @return
     */
    public static boolean checkStr(String str) {

        for (int i = 0; i < str.length(); i++) {
            String r = str.substring(i, i + 1);
            if (r.matches("[^\\x00-\\xff]+")) {
                return true;
            }
        }
        return false;
    }


    /**
     * 根据属性名校验实体属性是否为空
     *
     * @param obj    对象
     * @param params 属性名称
     * @return 不为空：true;为空:false
     */
    public static boolean checkObjectParam(Object obj, String[] params) {
        if (isEmpty(obj) || isEmpty(params) || params.length == 0) {
            return false;
        }
        for (String property : params) {
            String readMethod = "get" + capitalize(property);
            Class<?> sourceCls = obj.getClass();
            try {
                Object sresult = sourceCls.getDeclaredMethod(readMethod).invoke(obj);
                if (isEmpty(sresult)) {
                    return false;
                }
            } catch (NoSuchMethodException e) {
                try {
                    Object sresult = sourceCls.getSuperclass().getDeclaredMethod(readMethod).invoke(obj);
                    if (isEmpty(sresult)) {
                        return false;
                    }
                } catch (Exception e1) {
                    e1.printStackTrace();
                    return false;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    /**
     * 生成随机数字和字母,
     *
     * @param length      长度
     * @param isLowerCase 是否小写（true:小写；false:大写；null:混合）默认为混合
     * @return
     */
    public static String getStringRandom(int length, Boolean isLowerCase) {
        String val = "";
        Random random = new Random();
        // 参数length，表示生成几位随机数
        for (int i = 0; i < length; i++) {
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            // 输出字母还是数字
            if ("char".equalsIgnoreCase(charOrNum)) {
                // 输出是大写字母还是小写字母
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                if (isLowerCase != null) {
                    if (!isLowerCase) {
                        temp = 65;
                    } else {
                        temp = 97;
                    }
                }
                val += (char) (random.nextInt(26) + temp);
            } else if ("num".equalsIgnoreCase(charOrNum)) {
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }

    /**
     * 生成随机自定类型和长度的字母,
     *
     * @param length      长度
     * @param isLowerCase 是否小写（true:小写；false:大写；null:混合）默认为混合
     * @return
     */
    public static String getRandomNoNumStr(int length, Boolean isLowerCase) {
        String val = "";
        Random random = new Random();
        // 参数length，表示生成几位随机数
        for (int i = 0; i < length; i++) {
            // 输出是大写字母还是小写字母
            int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
            if (isLowerCase != null) {
                if (!isLowerCase) {
                    temp = 65;
                } else {
                    temp = 97;
                }
            }
            val += (char) (random.nextInt(26) + temp);
        }
        return val;
    }

    /**
     * 获取IP地址
     * <p>
     * 使用Nginx等反向代理软件， 则不能通过request.getRemoteAddr()获取IP地址
     * 如果使用了多级反向代理的话，X-Forwarded-For的值并不止一个，而是一串IP地址，X-Forwarded-For中第一个非unknown的有效IP字符串，则为真实IP地址
     */
    public static String getIpAddr(HttpServletRequest request) {

        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return "0:0:0:0:0:0:0:1".equals(ip) ? "127.0.0.1" : ip;
    }


    /**
     * 根据日期获取所属季度
     *
     * @param month 所属月
     * @return
     */
    public static String getSeason(String month) {
        if (isNotEmpty(month)) {
            int m = Integer.valueOf(month);
            if (m >= 1 && m <= 3) {
                return "1";
            } else if (m >= 4 && m <= 6) {
                return "2";
            } else if (m >= 7 && m <= 9) {
                return "3";
            } else if (m >= 10 && m <= 12) {
                return "4";
            }
        }
        return null;
    }

    //获取指定长度的UUID
    public static String getUuidStr(Integer length) {
        String uuidStr = UUID.randomUUID().toString().replace("-", "").toUpperCase();
        if (isNotEmpty(length) && length.intValue() < 33) {
            return uuidStr.substring(0, length);
        }
        return uuidStr;
    }

    /**
     * 加密字符串
     *
     * @param str  字符串
     * @param full (true:32位；false:中间16位（8-24）)
     * @return
     */
    public static String getMD5(String str, boolean full) {
        byte[] input = str.getBytes();
        char[] hexchr = "0123456789abcdef".toCharArray();
        char[] outstr = new char[32];
        String strout = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(input);
            byte[] output = md.digest();
            int k = 0;
            for (int i = 0; i < output.length; i++) {
                outstr[k++] = hexchr[(output[i] & 0xF0) >>> 4];
                outstr[k++] = hexchr[output[i] & 0x0F];
            }
            strout = new String(outstr);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        if (full) {
            return strout;
        } else {
            return strout.substring(8, 24);
        }
    }

    /**
     * 获取文件的扩展名
     *
     * @param fileName 文件名
     * @return
     */
    public static String getExtension(String fileName) {
        if (isEmpty(fileName)) {
            return "Unknown";
        }
        return fileName.substring(fileName.lastIndexOf("."));
    }


    /**
     * 给文件名加上时间戳后，返回经过MD5算法Hash后的文件名
     *
     * @param fileName 文件名
     * @return
     */
    public static String getSaveName(String fileName) {
        String ext = getExtension(fileName);
        fileName = fileName + new Date().getTime();
        return getMD5(fileName, false) + ext;
    }

    /**
     * @return
     */
    public static HttpServletRequest getHttpServletRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    public static void main(String[] args) {
        System.out.println(parseDate("2018-05-25 00:00:00", null));
        //System.out.println("2017/07".substring(0,4)+"-"+getSeason("2017/07".substring(6,7)));
    }
}

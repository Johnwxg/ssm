package com.ssm.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

import com.ssm.exception.SelfException;

/**
 * 字符串工具类
 */
public final class StringUtil {
    /** Private Constructor **/
    private StringUtil(){
    }

    /***
     *
     * @Description:  字符集
     * @ClassName ENCODING
     * @author: qinzheng
     * @Created 2015年9月10日 上午9:48:26
     */
    public interface ENCODING {
        String UTF_8 = "UTF-8";
        String GBK = "GBK";
        String ISO_8858_1 = "ISO-8859-1";
        String GB2312 = "GB2312";
    }

    /**
     *
     * @Description: 生成UUID
     * @return
     * @ReturnType String
     * @author: qinzheng
     * @Created 2015年8月31日 上午11:31:30
     */
    public static String uuid(){
        return UUID.randomUUID().toString();
    }

    /**
     * int字符串装int值
     * @Description:
     * @param intstr
     * @return
     * @ReturnType int
     * @author: qinzheng
     * @Created 2015年8月21日 上午10:44:01
     */
    public static int toInt(String intstr){
        try {
            return Integer.parseInt(intstr);
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * 判断字符串是否非null && 非空字符
     *
     * @param param
     * @return
     */
    public static boolean isNotEmpty(String param) {
        return param != null && !"".equals(param.trim());
    }

    /**
     * 判断字符串是否为null || 空字符串
     *
     * @param param
     * @return
     */
    public static boolean isEmpty(String param) {
        return param == null || "".equals(param.trim());
    }

    /**
     * 判断是否为数字
     * @param str
     * @return True为数字
     */
    public static boolean isNum(String str) {
        String regex = "^(-?\\d+)(\\.\\d+)?$";
        return matchRegex(str, regex);
    }

    public static String trim2Empty(String str) {
        return isEmpty(str) ? "" : str.trim();
    }

    private static boolean matchRegex(String value, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(value);
        return matcher.matches();
    }

    /**
     *
     * @Description: 字符串字符转换
     * @param str
     * @param encoding
     * @param toEncoding
     * @return
     * @throws Exception
     * @ReturnType String
     * @author: qinzheng
     * @Created 2015年9月10日 上午9:52:45
     */
    public static String convertCharacter(String str, String encoding, String toEncoding) throws Exception{
        return new String(str.getBytes(encoding), toEncoding);
    }

    /**
     * author 高利强
     *
     *2016年7月1日 下午5:28:43
     *
     * 判断逗号分隔的字符串是否包含特定数字字符
     *
     * @parame  str
     *
     * @param subStr
     */
    public static boolean dealStr(String str,String subStr) {
        boolean flag=false;
        String[] array = str.split(",");
        for (String element : array) {
            if(element.equals(subStr)){
                flag=true;
            };
        }
        return flag;
    }

    /**
     * author 高利强
     *
     *2016年7月11日 上午10:50:14
     *
     * 岗位类型特殊处理
     */
    public static String getPostType(String postType){

        if (postType.length() < 1) {
            return postType;
        }

        String postTypeStr = "";
        String[] postTypeAarry = postType.split(",");
        for (String element : postTypeAarry) {
            if("03".equals(element))
            {
                postTypeStr="03";
                break;
            }
        }
        return postTypeStr;
    }

    // 去除字符串数组中的重复项
    public static String removerepeatedchar(String value) {
        if (StringUtil.isEmpty(value)) {
            return value;
        }
        String[] str = value.split(",");
        // 第一步：将字符串数组转化为字符串list；
        List<String> strList = Arrays.asList(str);
        // 第二步：将字符串list转化为hashset.利用hashset无重复元 素的特性解决问题。
        Set<String> strSet = new HashSet<String>(strList);
        String[] temp = new String[strSet.size()];
        Iterator<String> ite = strSet.iterator();
        for (int i = 0; ite.hasNext(); i++) {
            temp[i] = ite.next();
            // System.out.println(temp[i]);
        }
        String reStr = StringUtils.join(temp, ",");
        return reStr;
    }

    /**
     * 手机号验证
     *
     * @param  str
     * @return 验证通过返回true
     */
    public static boolean isMobile(String str) {
        Pattern p;
        Matcher m;
        boolean b = false;
        if (StringUtil.isEmpty(str)) {
            return b;
        }
        p = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$"); // 验证手机号
        m = p.matcher(str);
        b = m.matches();
        return b;
    }

    /**
     *
     * @Description: 输出身份证前6后4中间星号
     * @param str
     * @param encoding
     * @param toEncoding
     * @return
     * @throws Exception
     * @ReturnType String
     * @author: lvchong
     * @Created 2016年9月27日 上午1:50:45
     */
    public static String dealIdCard(String idCard) throws SelfException{
        String first = idCard.substring(0, 6);
        String last=idCard.substring(idCard.length()-4, idCard.length());
        StringBuilder sb=new StringBuilder();
        sb.append(first);
        sb.append(last);
        int d = idCard.length()-sb.length();
        sb.delete(sb.length()-4, sb.length());
        for (int i = 0; i < d; i++) {
            sb.append("*");
        }
        sb.append(last);
        return sb.toString();
    }
    /**
     * author 高利强
     *
     * 2016年12月19日 下午5:48:39
     *
     * 在线渠道编码自增1后前面自动补零
     */
    public static String frontCompWithZore(String currentNum ){
        AtomicInteger num= new AtomicInteger(Integer.parseInt(currentNum));
        return String.format("%07d",num.incrementAndGet());
    }

    public static String getAndCheckNullFromMap(Map<String, String> params, String keyStr, String errMsg)
            throws SelfException {

        if (StringUtil.isEmpty(params.get(keyStr))) {
            throw new SelfException(errMsg);
        }
        return params.get(keyStr);
    }
}

package com.ibairah.Medium.lc468ValidateIPAddress;

/**
 * Created by ibairah on 6/16/20.
 * Write a function to check whether an input string is a valid
 * IPv4 address or IPv6 address or neither.
 *
 * IPv4 addresses are canonically represented in dot-decimal
 * notation, which consists of four decimal numbers, each ranging
 * from 0 to 255, separated by dots ("."), e.g.,172.16.254.1;
 *
 * Besides, leading zeros in the IPv4 is invalid. For example, the
 * address 172.16.254.01 is invalid.
 *
 * IPv6 addresses are represented as eight groups of four
 * hexadecimal digits, each group representing 16 bits. The groups
 * are separated by colons (":"). For example, the address
 * 2001:0db8:85a3:0000:0000:8a2e:0370:7334 is a valid one. Also, we
 * could omit some leading zeros among four hexadecimal digits and
 * some low-case characters in the address to upper-case ones, so
 * 2001:db8:85a3:0:0:8A2E:0370:7334 is also a valid IPv6 address
 * (Omit leading zeros and using upper cases).
 *
 * However, we don't replace a consecutive group of zero value with
 * a single empty group using two consecutive colons (::) to pursue
 * simplicity. For example, 2001:0db8:85a3::8A2E:0370:7334 is an
 * invalid IPv6 address.
 *
 * Besides, extra leading zeros in the IPv6 is also invalid. For
 * example, the address 02001:0db8:85a3:0000:0000:8a2e:0370:7334 is
 * invalid.
 *
 * Note: You may assume there is no extra space or special
 * characters in the input string.
 *
 * Example 1:
 * Input: "172.16.254.1"
 *
 * Output: "IPv4"
 *
 * Explanation: This is a valid IPv4 address, return "IPv4".
 * Example 2:
 * Input: "2001:0db8:85a3:0:0:8A2E:0370:7334"
 *
 * Output: "IPv6"
 *
 * Explanation: This is a valid IPv6 address, return "IPv6".
 * Example 3:
 * Input: "256.256.256.256"
 *
 * Output: "Neither"
 *
 * Explanation: This is neither a IPv4 address nor a IPv6 address.
 */

class Solution {
    private boolean isIPv4(String IP) {
        // 1. dot num
        int dotNum = 0;
        for (int i = 0; i < IP.length(); i++) {
            if (IP.charAt(i) == '.') dotNum++;
        }
        if (dotNum != 3) return false;

        // 2. number of fields
        // . is special character in regular expression,
        // so we need "\\." because ...
        // \\ -> will be interpreted as \ escape character
        // \. -> will be interpreted as .
        String[] fields = IP.split("\\.");
        if (fields.length != 4) return false;

        // 3. each field
        for (String field : fields) {
            // 3.1 length of each field
            if (field.isEmpty() || field.length() > 3) {
                return false;
            }

            // 3.2 each character of each field should contain only digit!!
            int fieldLen = field.length();
            for (int i = 0; i < fieldLen; ++i) {
                if (!Character.isDigit(field.charAt(i))) {
                    return false;
                }
            }

            // 3.3 check digit is within range [0, 255]
            // After we have confirmed that each character of each field is digit
            // we can now convert String into Integer
            // Integer.valueOf(String) -> Integer vs Integer.setInt(String) -> int
            int num = Integer.valueOf(field);
            // 01.01.01.01 String.valueOf(num).equals(field) is for the cases like 0001
            // Any number that has in front.
            if (!String.valueOf(num).equals(field) || num < 0 || num > 255) {
                return false;
            }
        }

        return true;
    }

    private boolean isIPv6(String IP) {
        // 1. colon num
        int colonNum = 0;
        for (int i = 0; i < IP.length(); i++) {
            if (IP.charAt(i) == ':') colonNum++;
        }
        if (colonNum != 7) return false;

        // 2. number of fields
        String[] fields = IP.split(":");
        if (fields.length != 8) return false;

        // 3. each field
        for (String field : fields) {
            // 3.1 length of field
            if (field.isEmpty() || field.length() > 4) {
                return false;
            }

            // 3.2 check whether it is digit as well as character range from 'A' to 'F'(Hex).
            int fieldLen = field.length();
            for (int i = 0; i < fieldLen; ++i) {
                if (!Character.isDigit(field.charAt(i)) && (field.charAt(i) < 'A' || field.charAt(i) > 'F')) {
                    return false;
                }
            }
        }

        return true;
    }

    // When n is the length of IP
    public String validIPAddress(String IP) {
        // O(n)
        if (isIPv4(IP)) return "IPv4";
        // impressive toUpperCase(): O(n)
        if (isIPv6(IP.toUpperCase())) return "IPv6";

        return "Neither";
    }
}

public class MainClass {
}

package com.driver;

import java.util.HashMap;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name, balance, 5000);
        this.tradeLicenseId = tradeLicenseId;
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        if(!isStringValid(tradeLicenseId)) {
            String rearrangedID = arrangeString(tradeLicenseId);
            if(rearrangedID.equals("")) {
                throw new Exception("Valid License can not be generated");
            }
            this.tradeLicenseId = rearrangedID;
        }
    }

    public String arrangeString(String licenseID) {
        int n = tradeLicenseId.length();
        int[] freq = new int[26];

        for(int i = 0; i < n; i++) {
            char ch = tradeLicenseId.charAt(i);
            freq[ch - 'A']++;
        }

        char ch_max = getMaxChar(freq);
        int maxCount = freq[ch_max - 'A'];

        if(n % 2 == 0) {
            if(maxCount > (n/2 + 1)) {
                return "";
            }
        } else {
            if(maxCount > (n/2 + 2)) {
                return "";
            }
        }

        char[] ans = new char[n];
        int idx = 0;
        for(idx = 0; idx < n; idx+=2) {
            if(freq[ch_max - 'A'] > 0) {
                ans[idx] = ch_max;
                freq[ch_max - 'A']--;
            } else {
                break;
            }
        }

        for(int i = 0; i < 26; i++) {
            char ch = (char)('A' + i);
            while(freq[ch - 'A'] > 0) {
                if(idx >= n) {
                    idx = 1;
                }
                ans[idx] = ch;
                idx += 2;
                freq[ch - 'A']--;
            }
        }
        return new String(ans);
    }

    public char getMaxChar(int[] arr) {
        int maxVal = 0;
        char ch = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > maxVal) {
                maxVal = arr[i];
                ch = (char)((int)'A' + i);
            }
        }
        return ch;
    }

    public boolean isStringValid(String licenseID) {
        for(int i = 0; i < licenseID.length()-1; i++) {
            if(licenseID.charAt(i) == licenseID.charAt(i+1)) {
                return false;
            }
        }
        return true;
    }

    public String getTradeLicenseId() {
        return tradeLicenseId;
    }
}

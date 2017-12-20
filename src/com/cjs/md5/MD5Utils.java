package com.cjs.md5;

import java.security.MessageDigest;

public class MD5Utils
{
  public static String toMD5(String plainText)
  {
    try
    {
      MessageDigest md = MessageDigest.getInstance("MD5");
      md.update(plainText.getBytes());
      byte[] b = md.digest();
      

      StringBuffer buf = new StringBuffer("");
      for (int offset = 0; offset < b.length; offset++)
      {
        int i = b[offset];
        if (i < 0) {
          i += 256;
        }
        if (i < 16) {
          buf.append("0");
        }
        buf.append(Integer.toHexString(i));
      }
      return buf.toString();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return null;
  }
  
  public static void main(String[] args) {
	  System.out.println(toMD5("admin11234"));
  }
}
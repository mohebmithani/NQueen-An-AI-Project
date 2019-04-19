/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author Moheb
 */
public class StringManager {
    
    public String intToString(String string, int a)
    {
        string += a;
        return string;
    }
    
    public String intToString(int[] a)
    {
        int length = a.length;
        String string = "";
        
        for (int i = 0; i < length; i++) 
        {
            string += a[i];
        }
        return string;
    }
    
    public String intToString(int[] a, int[] b)
    {
        String string = "";
        
        for (int i = 0; i < a.length; i++) 
            string += a[i];
        for (int i = 0; i < b.length; i++) 
            string += b[i];
        
        return string;
    }

    public int[] stringToInt(String s)
    {
        int length = s.length();
        int[] data = new int[length];
        
        for (int i = 0; i < length; i++) 
        {
            data[i] = Character.getNumericValue(s.charAt(i));
        }
        return data;
    }
    
    public int[][] patternIn2d(String s)
    {
        int length = s.length();
        int[][] data = new int[length][length];
        
        for (int i = 0; i < length; i++) 
        {
            data[i][Character.getNumericValue(s.charAt(i))] = 1;
        }
        return data;
    }
    
    public String[] stringSplit(String s, int splitIndex)
    {
        String[] string = new String[2];
        string[0] = "";
        string[1] = "";
        
        for (int i = 0; i <= splitIndex; i++) 
        {
            string[0] += s.charAt(i); 
        }
        
        for (int i = 0; i < (s.length() - (splitIndex + 1)); i++) 
        {
            string[1] += s.charAt(splitIndex + 1 + i);
        }
        
        return string;
    }

}

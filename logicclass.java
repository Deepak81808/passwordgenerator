
package com.mycompany.javapasswordhenerat;

import java.util.Random;

public class passwordGenerator {
    
    public static final String LOWERCASE_CHARACTER="abcdefghijklmnopqrstuvwxyz";
    public static final String UPPERCASE_CHARACTER="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String NUMBERS="0123456789";
    public static final String SPECIAL_SYMBOL="!@#$%^&*()_-+={}[]:;<>,./?";
    
    private final Random random;
    
    public  passwordGenerator()
    {
        random=new Random();
    }
    
    public String generatpassword(int length,boolean includeuppercase,boolean includelowercase,boolean includenumber,boolean includesymbol)
    {
        StringBuilder passwordbuilder=new StringBuilder();
        
        String validCharacters="";
        
        if(includeuppercase) validCharacters+=UPPERCASE_CHARACTER;
        if(includelowercase) validCharacters+=LOWERCASE_CHARACTER;
        if(includenumber) validCharacters+=NUMBERS;
        if(includesymbol) validCharacters+=SPECIAL_SYMBOL;
        
        for(int i=0;i<length;i++)
        {
            int randomIndex=random.nextInt(validCharacters.length());
            
            char randomchar=validCharacters.charAt(randomIndex);
            
            passwordbuilder.append(randomchar);
        }
        
        return passwordbuilder.toString();
    }
}

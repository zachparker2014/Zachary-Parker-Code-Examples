package JavaProgram5;

import java.nio.file.*; //allows use of Path and File Classes
import static java.nio.file.StandardOpenOption.*; // allows use of StandardOpenOption methods/arguments
import java.io.*; //allows use of BufferedReader methods


public class JavaProgram5_Parker
{

   public static void main(String[] args)
   {
      //Declaring Variables
       String key = null;
       String inputString = null;
       //String encryptedOutput = "";
       //String decryptedOutput = "";
       String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
       
       //Obtains keyword from keyword.txt file
       Path keyword = Paths.get("JavaProgram5/keyword.txt");
       // *For testing* System.out.println(keyword.toAbsolutePath());
       InputStream input = null;
       try
       {
       input = Files.newInputStream(keyword);
       BufferedReader reader = new BufferedReader(new InputStreamReader(input));
       key = reader.readLine();
       input.close();
       }
       catch (IOException e)
       {
       System.out.println(e);
       }
       
       //Calls the removeRedundants method to create the fixed key
       StringBuilder fixedkey = removeRedundants(key);
       
       
       //Calls the encryptedAlphabetic method to create an encrypted version of the alphabet
       StringBuilder encryptedAlphabetic = encryptAlphabetic(alphabet, fixedkey);
       System.out.println("A method is used to create this encrypted alphabet as a key for the encryption method: " + encryptedAlphabetic);
       //Obtains the original input from input.txt file
       Path phrase = Paths.get("JavaProgram5/input.txt");
       try
       {
       input = Files.newInputStream(phrase);
       BufferedReader reader = new BufferedReader(new InputStreamReader(input));
       
       inputString = reader.readLine();
       System.out.println("This string is read from an input.txt file: " + inputString);
       input.close();
       }
       catch (IOException e)
       {
       System.out.println(e);
       }
       
       //Calls the encryptedString method to encrypt the input.txt file using the encrypted Alphabetic
       StringBuilder encryptedString = encryptor(inputString, encryptedAlphabetic, alphabet);
       
       //Writes the encrypted text to a new encrypt.txt file
       Path encrypt = Paths.get("JavaProgram5/encrypt.txt");
       byte[] encryptedData = encryptedString.toString().getBytes();
       OutputStream output = null;
       try
       {
       output = new BufferedOutputStream(Files.newOutputStream(encrypt, CREATE));
       System.out.println("This data is then encrypted and sent to a new encrypt.txt file: " + encryptedString);
       output.write(encryptedData);
       output.flush();
       output.close();
       }
       catch(Exception e)
       {
       System.out.println("Message: " + e);
       }
       
       
       //Calls the decryptedString method to decrypt the encrypt.txt file
       StringBuilder decryptedString = decryptor(encryptedString, encryptedAlphabetic, alphabet);
       
       //Writes the decrypted file to a new output.txt file
       Path out =
       Paths.get("JavaProgram5/output.txt");
       byte[] outputData = decryptedString.toString().getBytes();
       try
       {
       output = new BufferedOutputStream(Files.newOutputStream(out, CREATE));
       output.write(outputData);
       System.out.println("This is the final decrypted data which is sent to an output.txt file: " + decryptedString);
       output.flush();
       output.close();
       }
       catch(Exception e)
       {
       System.out.println("Message: " + e);
       }
       


   
   }
   
   //Method which removes redundant letter from the keyword
   public static StringBuilder removeRedundants(String s)
   {
   
      StringBuilder newString = new StringBuilder();
      
      process: for(int i = 0; i < s.length(); i++)
         {
            
            char c = s.charAt(i);
            for(int x=0; x < newString.length(); x++)
            {
              
               if(c == newString.charAt(x))
                  {
                     continue process;
                  }
            }
               
               newString.append(c);
         
         }
      
      return newString;
   
   }
   
   //Method which creates the encrypted alphabetic
   public static StringBuilder encryptAlphabetic(String alphabet, StringBuilder key)
   {
      StringBuilder encryptedAlphabetic = new StringBuilder(key);
      
      process: for(int i = 0; i < alphabet.length(); i++)
      {
      
         char c = alphabet.charAt(25 - i);
         for(int x = 0; x < encryptedAlphabetic.length(); x++)
         {
            if(c == encryptedAlphabetic.charAt(x))
            {
               continue process;
            }
         }
         
         encryptedAlphabetic.append(c);
      
      }
      
      return encryptedAlphabetic;
   
    }
   
   //Method which encrypts input using the encrypted alphabetic
   public static StringBuilder encryptor(String inputString, StringBuilder encryptedAlphabetic, String alphabet)
   {
      StringBuilder encryptedString = new StringBuilder();
      
      process: for(int x = 0; x < inputString.length(); x++)
      {
         if (inputString.charAt(x) == ' ')
         {
         encryptedString.append(' ');
         continue process;
         }
      
         for(int i = 0; i < alphabet.length(); i++)
         {
         
            if (inputString.charAt(x) ==  alphabet.charAt(i))
               {
                  char y = encryptedAlphabetic.charAt(i);
                  encryptedString.append(y);
                  continue process;
               }
         
         }
      }
      
      return encryptedString;
   
   }
   
   //Method which decrypts the encrypted String using the encrypted alphabetic
   public static StringBuilder decryptor(StringBuilder encryptedString, StringBuilder encryptedAlphabetic, String alphabet)
   {
      StringBuilder decryptedString = new StringBuilder();
      
      process: for(int x = 0; x < encryptedString.length(); x++)
      {
         if (encryptedString.charAt(x) == ' ')
         {
            decryptedString.append(' ');
            continue process;
         }

      
         for(int i = 0; i < encryptedAlphabetic.length(); i++)
         {
         
            if (encryptedString.charAt(x) == encryptedAlphabetic.charAt(i))
            {
            
               char y = alphabet.charAt(i);
               decryptedString.append(y);
            
            } 
         
         }
      
      }
      
      return decryptedString;
      
   }


}
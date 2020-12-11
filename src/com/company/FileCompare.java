package com.company;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class FileCompare {
    public static void startProgram(){
        File file1=new File("D:\\Файлы\\Doc2.txt");
        File file2=new File("D:\\Файлы\\Doc.txt");
        String text=loadFromFile(file1);
        text = text.replace("\n"," ").replace("\r"," ");
        String text1=loadFromFile(file2);
        text1 = text1.replace("\n"," ").replace("\r"," ");
        newFile(compareTwoFiles(text,text1));
    }

    public static String loadFromFile(File file) {
        StringBuilder sb = new StringBuilder();
        try (Scanner sc = new Scanner(file)) {
            for (; sc.hasNextLine();) {
                sb.append(sc.nextLine()).append(System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println(e);
        } return sb.toString();
    }

    public static String  compareTwoFiles(String text1, String text2){
        String [] wordsText1=text1.split(" ");
        String [] wordsText2=text2.split(" ");
        String sum="";
        for(int i=0;i<wordsText1.length;i++){
            for (int j=0; j<wordsText2.length;j++){
                if(wordsText1[i].equals(wordsText2[j])){
                    sum=sum+wordsText1[i]+" ";
                }
            }
        }
        return sum;
    }

    public static void newFile(String str){
        FileOutputStream f=null;
        byte[] b=str.getBytes();
        try{
            f=new FileOutputStream("D:\\Файлы\\compare.txt");
            f.write(b);
        }catch(IOException e){
            System.out.println("I/O ошибка");
        }
        finally{
            try{
                f.close();
            } catch(IOException e){
                System.out.println("Error close file");
            }
        }
    }

}

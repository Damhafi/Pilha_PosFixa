package Calcualdora;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

public class PilhaNPR {
    public static void main(String[] args) throws IOException{
        PilhaSE p = new PilhaSE();
        int arg1, arg2;
        char c;
        
        String input=JOptionPane.showInputDialog("Expressão:","10 20+");
        StringTokenizer inputTokens=new StringTokenizer(input);
        while (inputTokens.hasMoreTokens()){
            JOptionPane.showMessageDialog(null,inputTokens.nextToken());
        }
        System.exit(0);
        System.out.println("Calculadora notação posfixaNPR");
        System.out.println("   Exempl de uso:\n 59 +2 * 6 5 * +");
        System.out.println("Informe sua expressao:\n ");
        String s = lerStr();
        for(int i=0;i<s.length(); i++){
            c = s.charAt(i); //lendo carater por caracter
            if(Character.isDigit(c)){//caracter é  numero ?
                p.push(Character.digit(c,10));// transofrma char em int e add 
            }                                    // na pilha
            
            
            else if(c=='+'){
                arg1 = p.top(); p.pop();
                arg2 = p.top(); p.pop();
                p.push(arg1+arg2);
            }
            
            else if(c=='*'){
                arg1 = p.top(); p.pop();
                arg2 = p.top(); p.pop();
                p.push(arg1*arg2);
            }
            
            else if(c=='-'){
                arg1 = p.top(); p.pop();
                arg2 = p.top(); p.pop();
                p.push(arg1-arg2);
            }
            else if(c=='/'){
                arg1 = p.top(); p.pop();
                arg2 = p.top(); p.pop();
                p.push(arg1/arg2);
            }
            else if(c=='^'){
                arg1 = p.top(); p.pop();
                arg2 = p.top(); p.pop();
                p.push((int) Math.pow(arg1,arg2));
            }
        }
        System.out.println("Resposta =" + p.top());//imprimindo calculo final
        p.pop();      
    }//fim do programa
    
    public static String lerStr() throws IOException{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        return br.readLine();
    }
}

import java.util.Scanner;

public class Contador {
    public static void main(String[] args) {
        Scanner terminal = new Scanner(System.in);
        int param1 = terminal.nextInt();
        int param2 = terminal.nextInt();
        try {
            contar(param1,param2);
        } catch (ParametrosInvalidosException e) {
            e.printStackTrace();
        }
    }    

    static void contar(int p1, int p2) throws ParametrosInvalidosException{
        if(p1 > p2)
            throw new ParametrosInvalidosException();
        for(int i = 0; i < p2-p1;i++)
            System.out.println("Imprimindo o número " +(i+1));
    }

    public static class ParametrosInvalidosException extends Exception{
        static String mensagem = "O segundo parâmetro deve ser maior que o primeiro";
        
        public ParametrosInvalidosException(){
            super(mensagem);    
        }
    }
}

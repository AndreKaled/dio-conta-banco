

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo{

    public static void main(String[] args) {
        String[] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO", "MIRELA", "DANIELA", "JORGE"};
        int n = 5;
        selecaoCandidatos(candidatos, n);
    }

    static void selecaoCandidatos(String[] candidatos, int quantidadeSelecao){
        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000.0;
        List<String> list = new ArrayList<>();

        while(candidatosSelecionados < quantidadeSelecao && candidatoAtual < candidatos.length){
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();
            System.out.println("O candidato " +candidato +" solicitou o valor de " +salarioPretendido);
            if(salarioBase >= salarioPretendido){
                System.out.println("Candidato " +candidato +" foi selecionado para a vaga");
                candidatosSelecionados++;
                list.add(candidato);
            }
            candidatoAtual++;
        }
        imprimeSelecionados(list);
    }

    static void entrarEmContato(String candidato){
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;

        do { 
            atendeu = atender();
            continuarTentando = !atendeu;
            if(continuarTentando)
                tentativasRealizadas++;
            else
                System.out.println("CONTATO REALIZADO COM SUCESSO!");
        } while (continuarTentando && tentativasRealizadas < 3);
        if(atendeu)
            System.out.println("CONSEGUIMOS CONTATO COM " +candidato +" em " +tentativasRealizadas +" tentativas!");
        else
            System.out.println("SEM SUCESSO AO ENTRAR EM CONTATO COM " +candidato);
    }

    static boolean atender(){
        return new Random().nextInt(3) == 1;
    }

    static void imprimeSelecionados(List<String> list){
        int cont = 0;
        System.out.println("CANDIDATOS SELECIONADOS!");
        for(String s: list){
            cont++;
            System.out.println("Candidato nº" +cont +": " +s);
        }
    }
    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static void analisarCandidato(double salarioPretendido){
        double salarioBase = 2000.0;
        if(salarioBase > salarioPretendido)
            System.out.println("LIGAR PARA CANDIDATO!");
        else if(salarioBase == salarioPretendido)
            System.out.println("LIGAR PARA CANDIDATO COM CONTRA PROPOSTA!");
        else
            System.out.println("AGUARDANDO RESULTADO DOS DEMAIS CANDIDATOS.");
    }
}
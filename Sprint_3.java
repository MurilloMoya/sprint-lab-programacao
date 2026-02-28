import java.util.Scanner;

public class Sprint_3 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);


        //VARIÁVEIS
        int qtdEquipes = 0, qtdCombate = 0, pontosEquip = 0, auxPon=0, auxNum=0, auxDesign=0, n=0;
        char resulComb = 0;



        //CARREGAR VARIÁVEL
        System.out.print("Digite a quantidade de equipes participantes:");
        qtdEquipes = entrada.nextInt();


        //VETORES
        int[] numEquipe = new int[qtdEquipes];
        int[] totPontos = new int[qtdEquipes];
        int[] notasDesign = new int[qtdEquipes];



        for (int i = 0; i < qtdEquipes; i++) {

            boolean valido = false;

            System.out.print("Digite o número da equipe:");
            numEquipe[i] = entrada.nextInt();


            while (numEquipe[i] < 10 || numEquipe[i] > 99) {
                System.out.print("O número da equipe deve ser entre 10 - 99, Digite Novamente:");
                numEquipe[i] = entrada.nextInt();
            }

        boolean existe = false;

            for (int j=0;j<i;j++){
                if(numEquipe[j]==numEquipe[i]){
                    existe = true;
                    break;

            }
        }
            if(existe){
                System.out.println("*O número escolhido já está sendo usado por outra equipe!*");
                System.out.print("O número da equipe deve ser entre 10 - 99, Digite Novamente:");
                numEquipe[i] = entrada.nextInt();
            }else{
                valido=true;
            }



            System.out.print("Digite a nota de design do robô:");
            notasDesign[i] = entrada.nextInt();

            System.out.print("Digite a quantidade(s) de combate(s) realizado(s):");
            qtdCombate = entrada.nextInt();


            //PONTUAÇÃO E CLASSIFICAÇÃO DOS COMBATES
            pontosEquip = 0;
            for (int a = 0; a < qtdCombate; a++) {
                System.out.print("Resultado do " + (a + 1) + " Combate:");
                resulComb = entrada.next().toUpperCase().charAt(0);

                while (resulComb != 'V' && resulComb != 'E' && resulComb != 'D') {
                    System.out.print("Digite corretamente( V-Vitória / E-Empate/ D-Derrota):");
                    resulComb = entrada.next().toUpperCase().charAt(0);
                }

                if (resulComb == 'V') {
                    pontosEquip += 7;
                } else if (resulComb == 'E') {
                    pontosEquip += 4;
                } else {
                    pontosEquip += 0;
                }
            }

            totPontos[i] = pontosEquip;

        }



        //FOR RANKING
        for (int i=0; i<qtdEquipes; i++){
            for (int j=0; j<qtdEquipes -1; j++){

                //Pontos

                if (totPontos[j] < totPontos[j + 1] || (totPontos[j] == totPontos[j + 1] && notasDesign[j] < notasDesign[j + 1])) {

                    auxPon = totPontos[j];
                    totPontos[j] = totPontos[j + 1];
                    totPontos[j + 1] = auxPon;


                    auxNum = numEquipe[j];
                    numEquipe[j] = numEquipe[j + 1];
                    numEquipe[j + 1] = auxNum;


                    auxDesign = notasDesign[j];
                    notasDesign[j] = notasDesign[j + 1];
                    notasDesign[j + 1] = auxDesign;
                }

            }
        }


        //Saída
        System.out.println();
        System.out.println("-------------------- Raking ----------------------");
        for (int i=0; i<qtdEquipes; i++){
            System.out.println((i + 1) + "º lugar - Equipe " + numEquipe[i] + " - Pontos: " + totPontos[i] + " - Design: " + notasDesign[i]);
        }


    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculoNumerico;

    public class Algoritmos {
        /**
         * Método com uma função pre-definida, sendo esta: 2.02x^5 - 1.28x^4 + 3.06x^3 - 2,92x^2 - 5.66x + 6.08.
         * @param x é qualquer numero interio ou decimal para ser usado na função.
         * @return o retorno é um doble. 
         */
        public static double funcao(double x){
            // Calculando a função
            //double expressao = (4 * Math.cos(x)) - (Math.pow(Math.E, (2 * x)));
            double expressao = (Math.pow((2.02 * x),5)) - (Math.pow((1.28 * x),4)) + (Math.pow((3.06 * x),3)) - (Math.pow((2.92 * x),2)) - (5.66 * x) + 6.08;
            return expressao;
        }
        
        /**
         * Método para calculo da média aritmética
         * @param a valor qualquer para se calcular a média.
         * @param b valor qualquer para se calcular a média.
         * @return o retorno é um doble.
         */
        public static double mediaAritmetica(double a, double b){
            // Calculando a média
            System.out.println("Fazendo a média dos dois pontos...............");
            System.out.println("a |======= x =======| b");
            double media = (a + b)/2;
            System.out.printf("x = (a+b)/2 => (%f + %f)/2 = %f \n", a, b, media);
            System.out.printf("%f |======= %f =======| %f \n", a, media, b);
            return media;
        }
        
        public static void printCondicao(double a, double b){
            System.out.println("Verificando se f(a)f(b) < 0...............");
            System.out.printf("f(a) = %f \n", funcao(a));
            System.out.printf("f(b) = %f \n", funcao(b));
            System.out.printf("f(a)f(b) = %f \n", funcao(a)*funcao(b));
            System.out.println();
        }
        
        public static void printFucaoSinal(double a, double x, double b){
            System.out.println("Verificando onde a função muda de sinal...............");
            System.out.printf("a = %f, x = %f, b = %f \n", a, x, b);
            System.out.printf("f(a) = %f \n", funcao(a));
            System.out.printf("f(x) = %f \n", funcao(x));
            System.out.printf("f(b) = %f \n", funcao(b));
        }
        
        /**
         * Método para tenta encontrar uma aproximação da raíz em um determinado intervalo, caso exista.
         * @param intervalo é uma arrya contendo dois elementos, que serão os intervalos usados para achar uma aproximação da raíz neste intervalo.
         * @param precisao é o critério de para para a melhor aproximação da raíz.
         */
        public static void metodoBisseccao(double[] intervalo, double precisao){
            double a = intervalo[0];
            double b = intervalo[1];
            int k = 1;
            double modulo;
            // Verificando se f(a)f(b) < 0.
            printCondicao(a, b);
            if((funcao(a)*funcao(b)) < precisao){
                // Enquanto for verdadeiro.
                System.out.println("Aplicando o método...............");
                while(true){
                    System.out.printf("K = %d \n", k);
                    // Calculando a media dos intervalos.   
                    
                    double x = mediaAritmetica(a, b);
                    
                    // Verificando onde a funcão muda de sinal.
                    printFucaoSinal(a,x,b);
                    if(funcao(x) > 0)
                        b = x;
                    else
                        a = x;
                    // Calculando o médulo para o critério de parada.
                    System.out.println("Critério de Parada....");
                    System.out.printf("|b - a|/|b| = |(%f) - (%f)|/|%f| \n", b, a, b);
                    modulo = Math.abs((b - a)/b);
                    // Verificando o erro relativo com a precisão.
                    System.out.println("Verificando o erro relativo com a precião...............");                  
                    if(modulo < precisao){
                        System.out.printf("E < precisao => %f < %f \n", modulo, precisao);
                        // Mostrando a melhor aproximação para raiz.
                        System.out.printf("O valor mais proximo para raíz é: %f \n", (x));
                        System.out.println("Fim...");
                        // Quebrando o loop.
                        break;
                    }
                    System.out.printf("E > precisao => %f > %f \n", modulo, precisao);
                    System.out.println();
                    System.out.println();
                    // Incrementando o contador de interações.
                    k++;
                    }        
            } else {
                // Mostrando que não existe raiz no intervalo.
                System.out.println("A valor da f(a)f(b) é maior que 0."); 
            }
                        
        }


        public static void main(String[] args){
            
            double[] array = {-2, 0};

            metodoBisseccao(array, 0.01);
            System.out.println();
            
        }
}

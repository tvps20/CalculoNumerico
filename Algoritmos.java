/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculoNumerico;

    public class Algoritmos {
        /**
         * Método para verificar se existe troca de sinal e consequêntemente uma raiz no limete informado.
         * @param a Limite inferior
         * @param b Limite superior
         * @return Retorna true se existir uma raiz no intervalo dado
         */
        public static boolean existeRaiz(double a, double b){
            double limiteA = funcao(a);
            double limiteB = funcao(b);
                       
            if(((limiteA * -1) > 0) && (limiteB > 0))
                return true;
            else if ((Math.pow(limiteA,-1) < 0) && (limiteB < 0))
                return true;
            
            return false;
        }
        
        /**
         * Método com uma função pre-definida, sendo esta: 2.02x^5 - 1.28x^4 + 3.06x^3 - 2,92x^2 - 5.66x + 6.08.
         * @param x é qualquer numero interio ou decimal para ser usado na função.
         * @return o retorno é um doble. 
         */
        public static double funcao(double x){
            // Calculando a função
            //double expressao = (4 * Math.cos(x)) - (Math.pow(Math.E, (2 * x)));
            //double expressao = (2.02 * Math.pow(x ,5))  - (1.28 * Math.pow(x ,4)) + (3.06 * Math.pow(x,3)) - (2.92 * Math.pow(x,2)) - (5.66 * x) + 6.08;
            double expressao = (Math.pow(x,5)-6);
            return expressao;
        }
        
        /**
         * Método com derivada da função pre-definida, sendo esta: 10.1x^4 - 5.12x^3 + 9.18x^2 - 5.84x - 5.66;
         * @param x é qualquer numero interio ou decimal para ser usado na função.
         * @return o retorno é um double.
         */
        public static double funcaoDerivada(double x){
            // Calculando a derivada da função
            //double expressao = (10.1 * Math.pow(x,4)) - (5.12 * Math.pow(x,3)) + (9.18 * Math.pow(x,2)) - (5.84 * x) - 5.66;
            double expressao = (5 * Math.pow(x, 4));
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
            double media = (a + b)/2;

            return media;
        }      
        
        /**
         * Método para tenta encontrar uma aproximação da raíz em um determinado intervalo, caso exista.
         * @param intervalo é uma arrya contendo dois elementos, que serão os intervalos usados para achar uma aproximação da raíz neste intervalo.
         * @param precisao é o critério de para para a melhor aproximação da raíz.
         */
        public static void metodoBisseccao(double[] intervalo, double precisao, int qtdInteracoes){
            double a = intervalo[0];
            double b = intervalo[1];
            int k = 1;
            double E;
            // Verificando se f(a)f(b) < 0.
            //if((funcao(a)*funcao(b)) < 0){
            //if(existeRaiz(a, b)){        
                System.out.println("#=============== Método da Bissecção ===============#");
                System.out.printf("Intervalo = [%.2f, %.2f] \n", a, b);
                System.out.println("Precisão = " + precisao);
                System.out.println("k = " + k);
                System.out.println("Aplicando o método...............\n\n");

                while(true){

                    double x = mediaAritmetica(a,b);

                    System.out.println("K = " + k);
                    System.out.printf("x%d = (a+b)/2 = (%f + %f)/2 \n", k, a, b);
                    System.out.printf("x%d = %f \n", k, x);
                    System.out.printf("a|================= x%d ==================|b \n", k);
                    System.out.printf("%f|======= %f =======|%f \n", a, x, b);
                    System.out.printf("f(x%d) = %f \n", k, funcao(x));

                    System.out.println("Verificando onde a função muda de sinal...............");
                    System.out.printf("a = %f, x = %f, b = %f \n", a, x, b);
                    System.out.printf("f(a) = %f \n", funcao(a));
                    System.out.printf("f(x) = %f \n", funcao(x));
                    System.out.printf("f(b) = %f \n", funcao(b));

                    if(funcao(x) > 0)
                        b = x;
                    else
                        a = x;


                    E = (b - a)/b;
                    E = Math.abs(E);
                    System.out.println("Critério de Parada...............");
                    System.out.printf("E = |b - a|/|b| = |(%f) - (%f)|/|%f| \n", b, a, b);
                    System.out.println("E = " + E);

                    if((E < precisao) || (k >= qtdInteracoes)){
                        System.out.printf("E < precisao => %f < %f \n", E, precisao);
                        System.out.printf("O valor mais proximo para raíz é: %f \n\n", x);
                        System.out.println("Resumo");
                        System.out.println("k = " + k);
                        System.out.printf("x%d = %f \n", k, x);
                        System.out.printf("f(x%d) = %f \n", k, funcao(x));
                        System.out.println("E = " + E);
                        System.out.println("Fim...");
                        break;
                    }           
                    System.out.printf("E > precisao => %f > %f \n", E, precisao);
                    System.out.println("\n\n");

                    k++;
                }        
            //}else {
                //Mostrando que não existe raiz no intervalo.
                //System.out.println("Não existe raiz nesse intervalo!"); 
            //}                     
        }
        
        /**
         * Método para determinar um valor entre o intervalo dado.
         * @param intervalo um array contendo dois elementos, limite superior e limite inferior.
         * @return O retorno é um double.
         */
        public static double calcularX0(double[] intervalo){
            return ((intervalo[0]+intervalo[1])/2);
        }
        
        
        /**
         * Método para tenta encontrar uma aproximação da raíz em um determinado intervalo, caso exista.
         * @param intervalo é uma arrya contendo dois elementos, que serão os intervalos usados para achar uma aproximação da raíz neste intervalo.
         * @param precisao é o critério de para para a melhor aproximação da raíz.
         * @param qtdInteracoes é a quantidade maximas de interações que será realizada
         */
        public static void metodoNewton(double[] intervalo, double precisao, int qtdInteracoes){
            double a = intervalo[0];
            double b = intervalo[1];
            int k = 0;
            double xNovo;
            double xInicial = calcularX0(intervalo);
            double E;
            // Verificando se f(a)f(b) < 0.

            //if((funcao(a)*funcao(b)) < 0){
                System.out.println("#=============== Método de Newton-Raphson ===============#");
                System.out.printf("Intervalo = [%.2f, %.2f] \n", a, b);
                System.out.println("Precisão = " + precisao);
                System.out.println("k = " + k);
                System.out.printf("x0 = %f \n\n", xInicial);
                System.out.println("Aplicando o método...............\n\n");
                
                do{          
                    xNovo = xInicial - (funcao(xInicial)/funcaoDerivada(xInicial));  
                    
                    System.out.println("K = " + k);
                    System.out.printf("x%d = %f \n", (k), xInicial);
                    System.out.printf("f(x%d) = %f \n", (k), funcao(xInicial));
                    System.out.printf("f'(x%d) = %f \n", (k), funcaoDerivada(xInicial));
                    System.out.printf("x%d = x%d + f(x)/f'(x) = %f - (%f/%f) \n", (k+1), k, xInicial, funcao(xInicial), funcaoDerivada(xInicial));
                    System.out.printf("x%d = %f \n", (k+1), xNovo);
                    System.out.printf("f(x%d) = %f \n", (k+1), funcao(xNovo));

                    
                    E = Math.abs((xNovo-xInicial)/xNovo);
                    System.out.println("Critério de Parada...............");
                    System.out.printf("E = |x%d - x%d|/|x%d| = |(%f) - (%f)|/|%f| \n", (k+1), k, (k+1), xNovo, xInicial, xNovo);
                    System.out.println("E = " + E);

                    System.out.println("Verificando o erro relativo com a precião..............."); 
                    if((precisao > E) || (k >= qtdInteracoes)){
                        System.out.printf("E < precisao => %f < %f \n", E, precisao);
                        System.out.printf("O valor mais proximo para raíz é: %f \n\n", xNovo);
                        System.out.println("Resumo");
                        System.out.println("k = " + k);
                        System.out.printf("x%d = %f \n", (k+1), xNovo);
                        System.out.printf("f(x%d) = %f \n", (k+1), funcao(xNovo));
                        System.out.println("E = " + E);
                        System.out.println("Fim...");
                        break;
                    }
                    
                    System.out.printf("E > precisao => %f > %f \n", E, precisao);
                    System.out.println("\n\n");

                    k++;
                    xInicial = xNovo;
            
                }while(true);
                
            //}else {
                //System.out.println("A raíz não existe nesse intervalo"); 
            //}
        }

        public static void main(String[] args){
            
            double[] array = {1.4, 1.4};

            //metodoBisseccao(array, 0.0001, 20);
            metodoNewton(array, 0.0001, 20);
                                                         
        }
}

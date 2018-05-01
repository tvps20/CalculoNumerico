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
            //double expressao = (Math.pow((2.02 * x),5)) - (Math.pow((1.28 * x),4)) + (Math.pow((3.06 * x),3)) - (Math.pow((2.92 * x),2)) - (5.66 * x) + 6.08;
            double expressao = (Math.pow(x,5)-6);
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
        
        /**
         * Método para mostrar prints na tela de como a condição esta sendo feita.
         * @param a Limite inferior
         * @param b Limite superior
         */
        public static void printCondicao(double a, double b){
            System.out.println("Verificando se f(a)f(b) < 0...............");
            System.out.printf("f(a) = %f \n", funcao(a));
            System.out.printf("f(b) = %f \n", funcao(b));
            System.out.printf("f(a)f(b) = %f \n", funcao(a)*funcao(b));
            System.out.println();
        }
        
        /**
         * Método para mostrar na tela os prints de como a esta sendo selecionando os novos limites.
         * @param a Limete superior
         * @param x Media entre os limites
         * @param b Limite inferior
         */
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
                    // Calculando o modulo para o critério de parada.
                    System.out.println("Critério de Parada....");
                    System.out.printf("E = |b - a|/|b| = |(%f) - (%f)|/|%f| \n", b, a, b);
                    modulo = Math.abs((b - a)/b);
                    System.out.println("E = " + modulo);
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
            }else {
                // Mostrando que não existe raiz no intervalo.
                System.out.println("A valor da f(a)f(b) é maior que 0."); 
            }                     
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
         * Método com derivada da função pre-definida, sendo esta: 10.1x^4 - 5.12x^3 + 9.18x^2 - 5.84x - 5.66;
         * @param x é qualquer numero interio ou decimal para ser usado na função.
         * @return o retorno é um double.
         */
        public static double funcaoDerivada(double x){
            // Calculando a derivada da função
            //double expressao = (Math.pow((10.1 * x),4)) - (Math.pow((5.12 * x),3)) + (Math.pow((9.18 * x),2)) - (5.84 * x) - 5.66;
            double expressao = (5 * Math.pow(x, 4));
            return expressao;
        }
        
        /**
         * Método para tenta encontrar uma aproximação da raíz em um determinado intervalo, caso exista.
         * @param intervalo é uma arrya contendo dois elementos, que serão os intervalos usados para achar uma aproximação da raíz neste intervalo.
         * @param precisao é o critério de para para a melhor aproximação da raíz.
         */
        public static void metodoNewton(double[] intervalo, double precisao){
            double a = intervalo[0];
            double b = intervalo[1];
            int k = 0;
            double x = calcularX0(intervalo);
            double modulo;
            int count = 1;
            // Verificando se f(a)f(b) < 0.
            if((funcao(a)*funcao(b)) < precisao){
                // Enquanto for verdadeiro.
                System.out.println("Aplicando o método...............");
                while(true){
                    System.out.printf("K = %d \n", k);    
                    // Calculando o x da vez
                    System.out.printf("x%d = x%d + f(x)/f'(x) = %f - (%f/%f) \n", count, k, x, funcao(x), funcaoDerivada(x));
                    double aux = (x - ((funcao(x))/funcaoDerivada(x)));
                    System.out.println("x" + count + " = " + aux);
                    
                    // Calculando o modulo para o critério de parada.
                    System.out.println("Critério de Parada....");
                    System.out.printf("E = |xn - x(n-1)|/|xn| = |(%f) - (%f)|/|%f| \n", aux, x, aux);
                    modulo = Math.abs((aux - x)/aux);
                    System.out.println("E = " + modulo);
                    // Verificando o erro relativo com a precisão.
                    System.out.println("Verificando o erro relativo com a precião..............."); 
                    if(modulo < precisao){
                        System.out.printf("E < precisao => %f < %f \n", modulo, precisao);
                        // Mostrando a melhor aproximação para raiz.
                        System.out.printf("O valor mais proximo para raíz é: %f \n", (aux));
                        System.out.println("Fim...");
                        // Quebrando o loop.
                        break;
                    }
                    System.out.printf("E > precisao => %f > %f \n", modulo, precisao);
                    System.out.println();
                    System.out.println();
                    // fazendo o x se tornar o novo x0.
                    x = aux;
                    // Incrementando o contador de interações.
                    k++; 
                    // Incrementando o contatador do x.
                    count++;
                }
            }else {
                // Mostrando que não existe raiz no intervalo.
                System.out.println("A valor da f(a)f(b) é maior que 0."); 
            }
        }

        public static void main(String[] args){
            
            double[] array = {1, 1.5};

            //metodoBisseccao(array, 0.01);
            metodoNewton(array, 0.01);
            //System.out.println(calcularX0(array));
            
            
        }
}

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
            double media = (a + b)/2;
            return media;
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
            if((funcao(a)*funcao(b)) < precisao){
                // Enquanto for verdadeiro.
                while(true){
                    // Calculando a media dos intervalos.           
                    double x = mediaAritmetica(a, b);
                    // Verificando onde a funcão muda de sinal.
                    if(funcao(x) > 0)
                        b = x;
                    else
                        a = x;
                    // Calculando o médulo para o critério de parada.
                    modulo = Math.abs((b - a)/b);
                    // Verificando o erro relativo com a precisão.
                    if(modulo < precisao){
                        // Mostrando a melhor aproximação para raiz.
                        System.out.printf("O valor mais proximo para raíz é: %f", (x));
                        // Quebrando o loop.
                        break;
                    }
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

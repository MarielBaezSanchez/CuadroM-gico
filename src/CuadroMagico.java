import java.util.Scanner;

public class CuadroMagico {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Introduce el número de filas de la matriz: ");
        int filas = input.nextInt();
        System.out.print("Introduce el número de columnas de la matriz: ");
        int columnas = input.nextInt();

        if (filas != columnas) {
            System.out.println("La matriz debe ser cuadrada (misma cantidad de filas y columnas) para ser un cuadro mágico.");
            return;
        }

        int[][] cuadroMagico = new int[filas][columnas];

        //valores(intrpducir)
        System.out.println("Introduce los valores de la matriz uno por uno:");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print("Introduce el valor en la fila " + (i + 1) + " y columna " + (j + 1) + ": ");
                cuadroMagico[i][j] = input.nextInt();
            }
        }

        //suma constante
        int sumaConstante = (filas * (filas * filas + 1)) / 2;

        //¿cuadro mágico o impostor?
        boolean esCuadroMagico = esCuadroMagicoValido(cuadroMagico, sumaConstante);

        if (esCuadroMagico) {
            System.out.println("Cuadro Mágico:");
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    System.out.print(cuadroMagico[i][j] + "\t");
                }
                System.out.println();
            }

            System.out.println("La constante es: " + sumaConstante);
        } else {
            System.out.println("No es un cuadro mágico. Si no le sabes, no le muevas.");
        }
    }

    //¿cuadro mágico o impostor?
    private static boolean esCuadroMagicoValido(int[][] cuadroMagico, int sumaConstante) {
        int n = cuadroMagico.length;

        //suma de fila 1
        int sumaPrimeraFila = 0;
        for (int j = 0; j < n; j++) {
            sumaPrimeraFila += cuadroMagico[0][j];
        }

        //suma de cada fila = suma constante
        for (int i = 1; i < n; i++) {
            int sumaFila = 0;
            for (int j = 0; j < n; j++) {
                sumaFila += cuadroMagico[i][j];
            }
            if (sumaFila != sumaConstante) {
                return false;
            }
        }

        //suma de cada columna = suma constante
        for (int j = 0; j < n; j++) {
            int sumaColumna = 0;
            for (int i = 0; i < n; i++) {
                sumaColumna += cuadroMagico[i][j];
            }
            if (sumaColumna != sumaConstante) {
                return false;
            }
        }

        //suma de la diagonal principal = suma constante
        int sumaDiagonalPrincipal = 0;
        for (int i = 0; i < n; i++) {
            sumaDiagonalPrincipal += cuadroMagico[i][i];
        }
        if (sumaDiagonalPrincipal != sumaConstante) {
            return false;
        }

        //suma de la diagonal secundaria =  constante
        int sumaDiagonalSecundaria = 0;
        for (int i = 0; i < n; i++) {
            sumaDiagonalSecundaria += cuadroMagico[i][n - i - 1];
        }
        if (sumaDiagonalSecundaria != sumaConstante) {
            return false;
        }

        return true;
    }
}
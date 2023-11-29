package vista;

import java.util.Scanner;

import logica.Graficar;
import logica.LGrafo;

public class Menu {

    public Menu() {
    }

    public void MenuPrincipal() {
        Scanner escaner = new Scanner(System.in);
        System.out.println("Ingrese el grafo");
        LGrafo grafo = new LGrafo(escaner.next());
        int opc;
        do {
            System.out.println("---------------Menu-------------");
            System.out.println("1.Matriz de Adyacencia");//ya
            System.out.println("2.Matriz de Incidencia");//ya
            System.out.println("3.Lista de Adyacencia");//falta
            System.out.println("4.Mostrar el grafo");//falta
            System.out.println("5.BFS");//falta
            System.out.println("6.DFS");//falta
            System.out.println("7.Distancia Minima");//ya
            System.out.println("8.Otro algoritmo de busqueda");//falta
            System.out.println("0.Salir");
            try {
                opc = escaner.nextInt();
            } catch (Exception e) {
                // TODO: handle exception
                opc = -1;
            }
            switch (opc) {
                case 1:
                    System.out.println(grafo.MatrizAdyacencia());
                    break;
                case 2:
                    System.out.println(grafo.MatrizIncidencia());
                    break;
                case 3:

                    break;
                case 4:
                    Graficar x = new Graficar(grafo);
                    x.pintarGrafo(grafo.MatrizAdyacenciaint());
                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:
                    System.out.println("Ingrese primero el inicio, y luego el final");
                    String inicio = escaner.next(), Final = escaner.next();
                    if (grafo.Existe(Final) && grafo.Existe(inicio)) {
                        System.out.println(grafo.DistanciaMinima(inicio, Final));
                    } else {
                        System.out.println("No existe el inicio o el final");
                    }
                    break;
                case 8:

                    break;
                case 9:

                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion Incorrecta");
                    break;
            }
        } while (opc != 0);
        escaner.close();
    }
}

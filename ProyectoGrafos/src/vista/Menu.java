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
            System.out.println("1.Matriz de Adyacencia");// ya
            System.out.println("2.Matriz de Incidencia");// ya
            System.out.println("3.Lista de Adyacencia");// ya
            System.out.println("4.Mostrar el grafo");// ya
            System.out.println("5.BFS");// ya
            System.out.println("6.DFS");// ya
            System.out.println("7.Distancia Minima");// ya
            System.out.println("8.Busqueda Limitada");// ya
            System.out.println("0.Salir");
            try {
                opc = escaner.nextInt();
            } catch (Exception e) {
                opc = -1;
            }
            String inicio, Final;
            switch (opc) {
                case 1:
                    System.out.println(grafo.MatrizAdyacencia());
                    break;
                case 2:
                    System.out.println(grafo.MatrizIncidencia());
                    break;
                case 3:
                    grafo.ListaDeAdyacencia();
                    break;
                case 4:
                    Graficar x = new Graficar(grafo);
                    x.pintarGrafo(grafo.MatrizAdyacenciaint());
                    break;
                case 5:
                    System.out.println("Ingrese el inicio");
                    inicio = escaner.next();
                    if (grafo.Existe(inicio)) {
                        grafo.BFS(inicio);
                    } else {
                        System.out.println("No existe el inicio");
                    }
                    break;
                case 6:
                    System.out.println("Ingrese el inicio");
                    inicio = escaner.next();
                    if (grafo.Existe(inicio)) {
                        grafo.DFS(inicio);
                    } else {
                        System.out.println("No existe el inicio");
                    }
                    break;
                case 7:
                    System.out.println("Ingrese primero el inicio, y luego el final");
                    inicio = escaner.next();
                    Final = escaner.next();
                    if (grafo.Existe(Final) && grafo.Existe(inicio)) {
                        System.out.println(grafo.DistanciaMinima(inicio, Final));
                    } else {
                        System.out.println("No existe el inicio o el final");
                    }
                    break;
                case 8:
                    System.out.println("Ingrese primero el inicio, luego el final, y por ultimo el limite pasos");
                    inicio = escaner.next();
                    Final = escaner.next();
                    int pasos = -1;
                    try {
                        pasos = escaner.nextInt();
                    } catch (Exception e) {
                    }
                    if (grafo.Existe(Final) && grafo.Existe(inicio)) {
                        if(grafo.BusquedaLimitada(inicio, Final, pasos)){
                            System.out.println("Desde "+inicio+" hasta "+Final+" si se puede llegar en "+pasos+" pasos");
                        }else{
                            System.out.println("Desde "+inicio+" hasta "+Final+" no se puede llegar en "+pasos+" pasos");
                        }
                    } else if(pasos != -1){
                        System.out.println("No existe el inicio o el final");
                    }else{
                        System.out.println("Numero de pasos incorrecto");
                    }
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

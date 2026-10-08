package com.ejercicio4.ejercicio4;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TablaController {

    @GetMapping(value = "/tabla", produces = "text/html")
    public String generarTabla(
            @RequestParam(required = false) String filas,
            @RequestParam(required = false) String columnas) {

        int numFilas = convertirNumero(filas);
        int numColumnas = convertirNumero(columnas);


        numFilas = Math.max(1, Math.min(20, numFilas));
        numColumnas = Math.max(1, Math.min(20, numColumnas));

        StringBuilder html = new StringBuilder();

        html.append("<!DOCTYPE html>");
        html.append("<html>");
        html.append("<head>");
        html.append("<meta charset='UTF-8'>");
        html.append("<title>Tabla</title>");
        html.append("</head>");
        html.append("<body>");

        html.append("<table border='1'>");

        //Encabezado
        html.append("<thead>");
        html.append("<tr>");
        html.append("<th>Fila / Columna</th>");

        for (int columna = 1; columna <= numColumnas; columna++) {
            html.append("<th>Columna ").append(columna).append("</th>");
        }

        html.append("</tr>");
        html.append("</thead>");

        //Cuerpo
        html.append("<tbody>");

        for (int fila = 1; fila <= numFilas; fila++) {

            html.append("<tr>");

            for (int columna = 1; columna <= numColumnas; columna++) {
                html.append("<td>");
                html.append("Fila ").append(fila)
                        .append(", Columna ").append(columna);
                html.append("</td>");
            }

            html.append("</tr>");
        }

        html.append("</tbody>");
        html.append("</table>");

        html.append("</body>");
        html.append("</html>");

        return html.toString();
    }

    private int convertirNumero(String valor) {
        if (valor == null) {
            return 1;
        }

        try {
            return Integer.parseInt(valor);
        } catch (NumberFormatException e) {
            return 1;
        }
    }
}
package ejercicioRefactorizacion;

import java.time.LocalDate;
/**
 * @author Tristán
 */
public class Reserva {
	
    private int idPista;
    private LocalDate fecha;
    private int duracion;
/**
 * Constructor de reservas
 * @param idPista id de la pista
 * @param fecha fecha
 * @param duracion duración
 */
    public Reserva(int idPista, LocalDate fecha, int duracion) {
        this.idPista = idPista;
        this.fecha = fecha;
        this.duracion = duracion;
    }
/**
 * Conseguir id de la pista
 * @return devuelve el id de la pista
 */
    public int getIdPista() {
        return idPista;
    }
/**
 * Conseguir fecha
 * @return devuelve la fecha
 */
    public LocalDate getFecha() {
        return fecha;
    }
/**
 * Conseguir la duración
 * @return devuelve la duración
 */
    public int getDuracion() {
        return duracion;
    }
}
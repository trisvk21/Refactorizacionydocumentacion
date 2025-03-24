package ejercicioRefactorizacion;
/**
 * @author Tristán
 */
import java.util.ArrayList;
import java.util.List;

public class SistemaReservasDeportivas {

    private List<Reserva> reservas;
    private boolean[] iluminacion;
    private static final int MAX_PISTAS = 10; // Asumimos un máximo de 10 pistas
/**
 * Crea array
 */
    public SistemaReservasDeportivas() {
        reservas = new ArrayList<>();
        iluminacion = new boolean[MAX_PISTAS];
    }
/**
 * Mira si la pista en cuestión se puede reservar
 * @param idPista id de la pista
 * @param fecha fecha de la reserva
 * @param duracion duración de la reserva
 * @return devuelve true si se puede reservar y false si no
 */
    public boolean reservarPista(int idPista, String fecha, int duracion) {
        if (idPista < 0 || idPista >= MAX_PISTAS) {
            return false; // ID de pista inválido
        }
        for (Reserva r : reservas) {
            if (r.getIdPista() == idPista && r.getFecha().equals(fecha)) {
                return false; // La pista ya está reservada en esa fecha
            }
        }
        reservas.add(new Reserva(idPista, fecha, duracion));
        return true;
    }
/**
 * Para cancelar reserva
 * @param idReserva id de la reserva
 * @return devuelve falso si no encuentra la reserva y true si sí
 */
    public boolean cancelarReserva(int idReserva) {
        for (int i = 0; i < reservas.size(); i++) {
            if (reservas.get(i).getIdPista() == idReserva) {
                reservas.remove(i);
                return true;
            }
        }
        return false; // No se encontró la reserva
    }
/**
 * Activa la iluminación
 * @param idPista id de la pista cuya iluminación se quiere activar
 * @return devuelve false si no encuentra la pista y true si sí
 */
    public boolean activarIluminacion(int idPista) {
        if (idPista < 0 || idPista >= MAX_PISTAS) {
            return false; // ID de pista inválido
        }
        iluminacion[idPista] = true;
        return true;
    }
/**
 * Desactiva la iluminación
 * @param idPista id de la pista cuya iluminación se quiere desactivar
 * @return devuelve false si no encuentra la pista y true si sí
 */
    public boolean desactivarIluminacion(int idPista) {
        if (idPista < 0 || idPista >= MAX_PISTAS) {
            return false; // ID de pista inválido
        }
        iluminacion[idPista] = false;
        return true;
    }
/**
 * Verifica la disponibilidad de la pista
 * @param idPista id de la pista
 * @param fecha fecha a comprobar
 * @param hora hora a comprobar
 * @return devuelve false si no está disponible y true si sí
 */
    public boolean verificarDisponibilidad(int idPista, String fecha, String hora) {
        if (idPista < 0 || idPista >= MAX_PISTAS) {
            return false; // ID de pista inválido
        }
        for (Reserva r : reservas) {
            if (r.getIdPista() == idPista && r.getFecha().equals(fecha)) {
                return false; // La pista no está disponible en esa fecha
            }
        }
        return true; // La pista está disponible
    }
}

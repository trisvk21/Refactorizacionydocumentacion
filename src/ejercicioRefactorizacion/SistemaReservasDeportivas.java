package ejercicioRefactorizacion;
/**
 * @author Tristán
 */
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

/**
 * Clase que gestiona el sistema de reservas deportivas
 * Permite reservar pistas, cancelar reservas y verificar disponibilidad
 */
public class SistemaReservasDeportivas {

    private List<Reserva> reservas;
    private GestorIluminacion gestorIluminacion;
    private static final int MAX_PISTAS = 10; // Asumimos un máximo de 10 pistas
/**
 * Crea array
 */
    public SistemaReservasDeportivas() {
        reservas = new ArrayList<>();
        gestorIluminacion = new GestorIluminacion(MAX_PISTAS);
    }
/**
 * Mira si la pista en cuestión se puede reservar
 * @param idPista id de la pista
 * @param fecha fecha de la reserva
 * @param duracion duración de la reserva
 * @return devuelve true si se puede reservar y false si no
 */
    public boolean reservarPista(Reserva reserva) {
        if (reserva.getIdPista()<0||reserva.getIdPista()>=MAX_PISTAS) {
            return false; // ID de pista inválido
        }
        for (Reserva r : reservas) {
            if (!esFechaDisponible(reserva.getIdPista(),reserva.getFecha())) {
                return false; // La pista ya está reservada en esa fecha
            }
        }
        reservas.add(reserva);
        return true;
    }
    
    private boolean esFechaDisponible(int idPista, LocalDate fecha) {
	// TODO Auto-generated method stub
	return false;
    }
	
/**
 * Para cancelar reserva
 * @param idReserva id de la reserva
 * @return devuelve falso si no encuentra la reserva y true si sí
 */
    public boolean cancelarReserva(int idReserva) {
        boolean eliminada = reservas.removeIf(r -> r.getIdPista() == idReserva);
        if(!eliminada) {
        	System.out.println("Error, reserva no encontrada");
        }
        return eliminada;
    }
    
    private boolean esFechaDisponible1(int idPista, LocalDate fecha) {
    	for (Reserva r : reservas) {
    		if (r.getIdPista() == idPista && extracted(fecha,r)) {
    			return false;
    		}
    	}
    	return true;
    }
    
    private boolean extracted(LocalDate fecha, Reserva r) {
		return r.getFecha().equals(fecha);
	}
/**
 * Activa la iluminación
 * @param idPista id de la pista cuya iluminación se quiere activar
 * @return devuelve false si no encuentra la pista y true si sí
 */
    public boolean encenderLuces(int idPista) {
        if (idPista < 0 || idPista >= MAX_PISTAS) {
            return false; // ID de pista inválido
        }
        return gestorIluminacion.encenderLuces(idPista);
    }
/**
 * Desactiva la iluminación
 * @param idPista id de la pista cuya iluminación se quiere desactivar
 * @return devuelve false si no encuentra la pista y true si sí
 */
    public boolean apagarLuces(int idPista) {
        if (idPista < 0 || idPista >= MAX_PISTAS) {
            return false; // ID de pista inválido
        }
        return gestorIluminacion.apagarLuces(idPista);
    }
/**
 * Verifica la disponibilidad de la pista
 * @param idPista id de la pista
 * @param fecha fecha a comprobar
 * @param hora hora a comprobar
 * @return devuelve false si no está disponible y true si sí
 */
    public boolean verificarDisponibilidad(int idPista, LocalDate fecha, String hora) {
        if (idPista < 0 || idPista >= MAX_PISTAS) {
            return false; // ID de pista inválido
        }
        
        return esFechaDisponible(idPista, fecha);
    }
}

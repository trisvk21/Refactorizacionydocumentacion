package ejercicioRefactorizacion;
/**
 * @author Tristán
 */
public class GestorIluminacion {
	private boolean[] iluminacion;
	
	/**
	 * Constructor que inicializa las luces apagadas
	 * @param maxPistas número total de pistas
	 */
	public GestorIluminacion(int maxPistas) {
		iluminacion = new boolean[maxPistas];
	}

	/**
	 * Enciende la iluminación de una pista
	 * @param idPista ID de la pista
	 * @return true si se enciende, false si el ID es invalido
	 */
	public boolean encenderLuces(int idPista) {
		if(idPista < 0 || idPista >= iluminacion.length) {
			return false;
		}
		iluminacion[idPista] = true;
		return true;
	}

	/**
	 * Apaga la iluminación de una pista
	 * @param idPista ID de la pista
	 * @return true si se apaga, false si el ID es invalido
	 */
	public boolean apagarLuces(int idPista) {
		if(idPista < 0 || idPista >= iluminacion.length) {
			return false;
		}
		iluminacion[idPista] = false;
		return true;
	}
}
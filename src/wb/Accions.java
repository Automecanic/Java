package wb;

import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

public class Accions {
	private double numeroHores = 0;
	private double preuHora;
	private int TipusLlicencia;
	private double preuSortida;
	private double preuLlicencia;

	/**
	 * activa el grup que li pasem
	 * 
	 * @param group
	 */
	public void activarBloc(Group group) {
		group.setEnabled(true);

	}

	/**
	 * desactiva el grup que li pasem per parametre
	 * 
	 * @param group
	 */
	public void desactivarBloc(Group group) {
		group.setEnabled(false);

	}

	/**
	 * comprova que les dades del camp hores sigui correcte
	 * 
	 * @param String  Text
	 * @param sortida imprimeix l'errada
	 * @return boolean
	 */
	public Boolean comporvaHores(String h, Text sortida) {

		try {
			numeroHores = Double.parseDouble(h);
			if (numeroHores > 0 && numeroHores <= 24) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {

			sortida.setText("Error hores incorrectes");
			return false;
		}
	}

	/**
	 * comprova que les dades del camp hores sigui correcte
	 * 
	 * @param String     Text
	 * @param txtSortida imprimeix l'errada
	 * @return boolean
	 */
	public boolean comprovaPreu(String text, Text txtSortida) {
		try {
			preuHora = Double.parseDouble(text);
			if (preuHora > 0 && preuHora < 100) {
				return true;
			} else
				return false;
		} catch (Exception e) {
			txtSortida.setText("Error al preu per hora");
			return false;
		}

	}

	/**
	 * comprova els parametres de la llicencia.
	 * 
	 * @param txtTipus relp el parametre del quadre de text.
	 * @return boolean
	 */
	public boolean ComprovaLlicencia(String txtTipus) {
		try {
			TipusLlicencia = Integer.parseInt(txtTipus);
			if (TipusLlicencia == 1 || TipusLlicencia == 2 || TipusLlicencia == 3) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}

	}

	/**
	 * estreu el numero de la llicencia
	 * 
	 * @param txtTipus
	 * @param txtTipusLlicencia2
	 * @param txtImportLlicencia
	 */
	public void extreuLlicencia(String txtTipus, Text txtTipusLlicencia2, Text txtImportLlicencia) {
		try {
			int num = Integer.parseInt(txtTipus);
			switch (num) {
			case 1:
				txtTipusLlicencia2.setText("No s’ha instal·lat cap");
				preuLlicencia = 0;
				txtImportLlicencia.setText("" + preuLlicencia + "€");
				break;
			case 2:
				txtTipusLlicencia2.setText("S’ha instal·lat SO amb llicència.");
				preuLlicencia = 50;
				txtImportLlicencia.setText("" + preuLlicencia + "€");
				break;
			case 3:
				txtTipusLlicencia2.setText("S’ha instal·lat SO amb llicència i Suite ofimàtica amb llicència.");
				preuLlicencia = 100;
				txtImportLlicencia.setText("" + preuLlicencia + "€");
				break;
			default:
				break;
			}
		} catch (Exception e) {

		}
	}

	/**
	 * comprova que el valor que rep es correcte.
	 * 
	 * @param s
	 * @return boolean
	 */
	public boolean comprovaSortida(String s) {
		try {
			int sortida = Integer.parseInt(s);
			if (sortida == 0 || sortida == 1) {
				return true;
			} else
				return false;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Extreu el valor del String i assigna el preu depenent del valor
	 * 
	 * @param s
	 * @param txtSortidaDomicili
	 */
	public void extreuPreuSortida(String s, Text txtSortidaDomicili) {

		switch (Integer.parseInt(s)) {
		case 0:
			preuSortida = 0;
			txtSortidaDomicili.setText("" + preuSortida + "€");
			break;
		case 1:
			preuSortida = 30;
			txtSortidaDomicili.setText("" + preuSortida + "€");
		default:
			break;
		}

	}

	/**
	 * Retorna el preu de l'assistència
	 * 
	 * @return double
	 */
	public double preuAssistència() {
		return preuHora * numeroHores;
	}

	/**
	 * retornta l'import total
	 * 
	 * @return double
	 */
	public double importTotal() {
		return preuAssistència() + preuSortida + preuLlicencia;
	}

}

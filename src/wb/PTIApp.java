package wb;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

public class PTIApp {
	private static Group grpShell;
	private static Group grpParametresPresupost_1;
	private static Group grpImportPressupost;
	private static Label lblParametresPresupost;
	private static Label lblImportPresupost;
	private static Label lblPreuHora;
	private static Label lblNumeroHores;
	private static Text txtPreuHores;
	private static Text txtNumeroHores;
	private static Button btnSeleccionar;
	private static Label lblTipusLlicencia;
	private static Label lblSortidaDomicili;
	private static Label lblPreuAssistencia;
	private static Label lblImportTotal;
	private final static int ESQUERRA = 15;
	private final static int LBL_AMPLE = 135;
	private final static int LBL_ALT = 20;
	private static Text txtTipusLlicencia;
	private static Text txtSortidaDomicili;
	private static Text txtPreuAssistencia;
	private static Text txtImportoTotal;
	private static Text txtSortida;
	private static Button btnRestablir;
	private static Button btnCalcular;
	private static Label lblTipusLlicencia2;
	private static Label lblImportLlicencia;
	private static Label lblImportDomicili;
	private static Text txtTipusLlicencia2;
	private static Text txtImportLlicencia;
	private static Text txtImportDomicili;

	// private final static int ESQUERRA = 15;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Display display = Display.getDefault();
		Shell shell = new Shell();
		shell.setSize(1000, 570);
		shell.setText("Presupost Tècnic Informàtic");
		shell.setLayout(new FillLayout(SWT.HORIZONTAL));
		Accions accions = new Accions();

		grpShell = new Group(shell, SWT.NONE);
		grpShell.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));

		lblParametresPresupost = new Label(grpShell, SWT.NONE);
		lblParametresPresupost.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblParametresPresupost.setBounds(25, 3, 135, 24);
		lblParametresPresupost.setText("Parametres Presupost");

		lblImportPresupost = new Label(grpShell, SWT.NONE);
		lblImportPresupost.setBounds(25, 148, 135, 24);
		lblImportPresupost.setText("Import Pressupost");

		grpParametresPresupost_1 = new Group(grpShell, SWT.BORDER);
		grpParametresPresupost_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		grpParametresPresupost_1.setBounds(10, 10, 964, 132);

		lblPreuHora = new Label(grpParametresPresupost_1, SWT.NONE);
		lblPreuHora.setBounds(ESQUERRA, 40, LBL_AMPLE, LBL_ALT);
		lblPreuHora.setText("Preu Hora");

		lblNumeroHores = new Label(grpParametresPresupost_1, SWT.NONE);
		lblNumeroHores.setBounds(ESQUERRA, 80, LBL_AMPLE, LBL_ALT);
		lblNumeroHores.setText("Número d'hores");

		txtPreuHores = new Text(grpParametresPresupost_1, SWT.BORDER);
		txtPreuHores.setToolTipText("El preu de l'hora no pot ser superior a 100");
		txtPreuHores.setFont(SWTResourceManager.getFont(".AppleSystemUIFont", 16, SWT.NORMAL));
		txtPreuHores.setBounds(162, 35, 100, 30);

		txtNumeroHores = new Text(grpParametresPresupost_1, SWT.BORDER);
		txtNumeroHores.setToolTipText("El número d'hores ha de ser  de 0 a 24");
		txtNumeroHores.setFont(SWTResourceManager.getFont(".AppleSystemUIFont", 16, SWT.NORMAL));
		txtNumeroHores.setBounds(162, 73, 100, 30);

		btnSeleccionar = new Button(grpParametresPresupost_1, SWT.NONE);
		btnSeleccionar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				boolean numHores;
				boolean preuHora;

				numHores = accions.comporvaHores(txtNumeroHores.getText(), txtSortida);
				preuHora = accions.comprovaPreu(txtPreuHores.getText(), txtSortida);
				if (!preuHora) {
					txtSortida.setText("Error! El preu per hora es incorrecte");
					txtPreuHores.forceFocus();
					txtPreuHores.selectAll();
				}
				if (!numHores) {
					txtSortida.setText("Error! El número d'hores es incorrecte");
					txtNumeroHores.forceFocus();
					txtNumeroHores.selectAll();
				}
				if (numHores && preuHora) {
					accions.activarBloc(grpImportPressupost);
					accions.desactivarBloc(grpParametresPresupost_1);
					txtSortida.setText("");
				}
			}
		});
		btnSeleccionar.setBounds(299, 65, 126, 41);
		btnSeleccionar.setText("Seleccionar");

		grpImportPressupost = new Group(grpShell, SWT.BORDER);
		grpImportPressupost.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		grpImportPressupost.setBounds(10, 156, 964, 366);

		lblTipusLlicencia = new Label(grpImportPressupost, SWT.NONE);
		lblTipusLlicencia.setBounds(ESQUERRA, 40, LBL_AMPLE, LBL_ALT);
		lblTipusLlicencia.setText("Tipus llicència");

		lblSortidaDomicili = new Label(grpImportPressupost, SWT.NONE);
		lblSortidaDomicili.setBounds(ESQUERRA, 80, LBL_AMPLE, LBL_ALT);
		lblSortidaDomicili.setText("Sortida domicili");

		lblPreuAssistencia = new Label(grpImportPressupost, SWT.NONE);
		lblPreuAssistencia.setBounds(ESQUERRA, 150, LBL_AMPLE, LBL_ALT);
		lblPreuAssistencia.setText("Preu assistència");

		lblImportTotal = new Label(grpImportPressupost, SWT.NONE);
		lblImportTotal.setBounds(15, 300, LBL_AMPLE, LBL_ALT);
		lblImportTotal.setText("Import Total");

		txtTipusLlicencia = new Text(grpImportPressupost, SWT.BORDER);
		txtTipusLlicencia.setToolTipText(
				"1 - No s'ha instal·lat cap\n2 - S’ha instal·lat SO amb llicència.\n3 -S’ha instal·lat SO amb llicència i Suite ofimàtica amb llicència. ");
		txtTipusLlicencia.setFont(SWTResourceManager.getFont(".AppleSystemUIFont", 16, SWT.NORMAL));
		txtTipusLlicencia.setBounds(166, 30, 100, 30);

		txtSortidaDomicili = new Text(grpImportPressupost, SWT.BORDER);
		txtSortidaDomicili.setToolTipText("0 - No sortida\n1 - Sortida");
		txtSortidaDomicili.setFont(SWTResourceManager.getFont(".AppleSystemUIFont", 16, SWT.NORMAL));
		txtSortidaDomicili.setBounds(166, 70, 100, 30);

		txtPreuAssistencia = new Text(grpImportPressupost, SWT.BORDER);
		txtPreuAssistencia.setEditable(false);
		txtPreuAssistencia.setFont(SWTResourceManager.getFont(".AppleSystemUIFont", 16, SWT.NORMAL));
		txtPreuAssistencia.setBounds(166, 140, 100, 30);

		txtImportoTotal = new Text(grpImportPressupost, SWT.BORDER);
		txtImportoTotal.setEditable(false);
		txtImportoTotal.setFont(SWTResourceManager.getFont(".AppleSystemUIFont", 16, SWT.NORMAL));
		txtImportoTotal.setBounds(166, 290, 100, 30);

		txtSortida = new Text(grpImportPressupost, SWT.BORDER);
		txtSortida.setEditable(false);
		txtSortida.setFont(SWTResourceManager.getFont(".AppleSystemUIFont", 16, SWT.NORMAL));
		txtSortida.setBounds(295, 290, 643, 30);

		btnRestablir = new Button(grpImportPressupost, SWT.NONE);
		btnRestablir.setGrayed(true);
		btnRestablir.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				accions.activarBloc(grpParametresPresupost_1);
				accions.desactivarBloc(grpImportPressupost);
				txtPreuHores.setText("");
				txtImportDomicili.setText("");
				txtImportLlicencia.setText("");
				txtImportoTotal.setText("");
				txtNumeroHores.setText("");
				txtPreuAssistencia.setText("");
				txtSortida.setText("");
				txtSortidaDomicili.setText("");
				txtTipusLlicencia.setText("");
				txtTipusLlicencia2.setText("");
			}
		});
		btnRestablir.setBounds(295, 73, 126, 41);
		btnRestablir.setText("Restablir");

		btnCalcular = new Button(grpImportPressupost, SWT.NONE);
		btnCalcular.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// comprova els tipus de llicencia estigui correcte.
				if (accions.ComprovaLlicencia(txtTipusLlicencia.getText())) {
					accions.extreuLlicencia(txtTipusLlicencia.getText(), txtTipusLlicencia2, txtImportLlicencia);

					// comprova que el tipus de sortida de domicili sigui correcta
					if (accions.comprovaSortida(txtSortidaDomicili.getText())) {
						accions.extreuPreuSortida(txtSortidaDomicili.getText(), txtImportDomicili);
						txtPreuAssistencia.setText("" + accions.preuAssistència() + "€");
						txtImportoTotal.setText(accions.importTotal() + "€");
						txtSortida.setText("");

					} else {
						txtSortida.setText("Error en el tipus sortida");
						txtSortidaDomicili.forceFocus();
						txtSortidaDomicili.selectAll();

					}
				} else {
					txtSortida.setText("Error en el tipus llicència");
					txtTipusLlicencia.forceFocus();
					txtTipusLlicencia.selectAll();
				}

			}
		});
		btnCalcular.setBounds(433, 74, 126, 41);
		btnCalcular.setText("Calcular");

		lblTipusLlicencia2 = new Label(grpImportPressupost, SWT.NONE);
		lblTipusLlicencia2.setBounds(295, 150, 135, 20);
		lblTipusLlicencia2.setText("Tipús llicència");

		lblImportLlicencia = new Label(grpImportPressupost, SWT.NONE);
		lblImportLlicencia.setBounds(295, 190, 135, 20);
		lblImportLlicencia.setText("Import llIcència");

		lblImportDomicili = new Label(grpImportPressupost, SWT.NONE);
		lblImportDomicili.setBounds(295, 230, 135, 20);
		lblImportDomicili.setText("Import domicili");

		txtTipusLlicencia2 = new Text(grpImportPressupost, SWT.BORDER);
		txtTipusLlicencia2.setEditable(false);
		txtTipusLlicencia2.setFont(SWTResourceManager.getFont(".AppleSystemUIFont", 16, SWT.NORMAL));
		txtTipusLlicencia2.setBounds(463, 140, 475, 30);

		txtImportLlicencia = new Text(grpImportPressupost, SWT.BORDER);
		txtImportLlicencia.setEditable(false);
		txtImportLlicencia.setFont(SWTResourceManager.getFont(".AppleSystemUIFont", 16, SWT.NORMAL));
		txtImportLlicencia.setBounds(463, 180, 100, 30);

		txtImportDomicili = new Text(grpImportPressupost, SWT.BORDER);
		txtImportDomicili.setEditable(false);
		txtImportDomicili.setFont(SWTResourceManager.getFont(".AppleSystemUIFont", 16, SWT.NORMAL));
		txtImportDomicili.setBounds(463, 220, 100, 30);

		shell.open();
		shell.layout();
		accions.desactivarBloc(grpImportPressupost);

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}

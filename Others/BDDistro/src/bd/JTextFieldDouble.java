package bd;


public class JTextFieldDouble extends javax.swing.JTextField{
	
	protected	javax.swing.text.Document	createDefaultModel(){
		return	new PlainDocumentDouble();
	}
	
	protected class PlainDocumentDouble extends javax.swing.text.PlainDocument{
		
		public void insertString(int offs, String str, javax.swing.text.AttributeSet a)
		throws javax.swing.text.BadLocationException{
			
			char[]	fuente	=	str.toCharArray();
			char[]	resul	=	new char[fuente.length];
			int		j		=	0;
			
			for (int i = 0; i < fuente.length; i++) {
				if(fuente[i]	>=	'0'	&&	fuente[i]	<=	'9'	||	fuente[i]	==	'.'	||	fuente[i]	==	'+'	||	fuente[i]	==	'-'){
					resul[j++]	=	fuente[i];
				}else{
					java.awt.Toolkit.getDefaultToolkit().beep();
				}			
			}
			super.insertString(offs, new String(resul, 0, j), a);
		}
	}

}

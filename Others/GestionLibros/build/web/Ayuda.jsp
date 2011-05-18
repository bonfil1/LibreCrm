<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%-- página JSP Ayuda.jsp --%>
<%@page contentType="text/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Ayuda al usuario</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<meta name="autor"        Content="Francisco Ceballos">
<meta name="copyright"    Content="(c) 2004">
</head>

<body bgcolor="#FFFFFF">
  <center>
  <h1><font face="Verdana,Helvetica"><b>DOCUMENTO DE AYUDA</b></font></h1>
  <br><br>
  </center>
  <%-- Mostrar información sobre la aplicación --%>
  <OL>
    <LI> <b>B&uacute;squeda de libros:</b>
        <UL>
            <LI> La b&uacute;squeda de libros se puede realizar de distintas maneras:
                <OL Type="a">
                    <LI> B&uacute;squeda por t&iacute;tulo:
                        <UL>
                            <LI> Se rellena la caja de texto con el t&iacute;tulo parcial o total del libro que desee buscar.
                        </UL>
                    <LI> B&uacute;squeda por autor:
                        <UL>
                            <LI> Se rellena la caja de texto con el nombre parcial o total del autor del libro que desee buscar.
                        </UL>                    
                    <LI> B&uacute;squeda por editorial:
                        <UL>
                            <LI> Se rellena la caja de texto con el nombre parcial o total de la editorial del libro que desee buscar.
                        </UL>                    
                    <LI> B&uacute;squeda por categor&iacute;a:
                        <UL>
                            <LI> Categorías en que se dividen los libros actualmente:
                                <UL>
                                    <LI> Ensayo
                                    <LI> F&iacute;sica
                                    <LI> Inform&aacute;tica
                                    <LI> Matem&aacute;ticas
                                    <LI> Novela
                                </UL>                        
                        </UL>
                    <LI> Lista que contiene todos los libros:
                        <UL>
                            <LI> Esta opción no requiere rellenar la caja de texto.
                        </UL>
                </OL>
            <LI> Para que una b&uacute;squeda se pueda realizar, se pulsar&aacute;
                 el bot&oacute;n "buscar".                
        </UL>
        <br><br>
    <LI> <b>Reestablecer:</b>
        <UL>
            <LI> Cada vez que pulsemos este bot&oacute;n todo lo escrito
                 por el usuario en esa misma pantalla ser&aacute; reestablecido a su valor incial.
        </UL>
        <br><br>        
    <LI> <b>Registro de un usuario:</b>
        <UL>
            <LI> Cuando un nuevo usuario quiere darse de alta en el sistema, debe pulsar este
                 bot&oacute;n que le llevará a una ventana donde deber&aacute; rellenar todos
                 los campos correctamente para que pueda ser admitido.
        </UL>
        <br><br>        
    <LI> <b>Historial de un usuario del sistema:</b>
        <UL>
            <LI> Para que un usuario ya registrado en el sistema pueda ver el historial de los
                 pedidos que ha realizado a esta librería, deberá rellenar previamente
                 los campos "Usuario" y "Contraseña" que se muestran en pantalla.
                 <OL type="a">
                    <LI> Usuario: nombre de usuario y no el nombre real del cliente.
                    <LI> Contraseña: clave secreta del usuario.
                 </OL>
            <LI> A continuación, se pulsa el bot&oacute;n "Historial" para que el sistema
                 compruebe la autenticidad de los datos y le permita o no acceder.
        </UL>
        <br><br>
     <LI> <b>Ver pedido/s del cliente:</b>
        <UL>
            <LI> Para que un usuario pueda ver un pedido, tiene que elegir el n&uacute;mero de
                 identificaci&oacute;n del pedido y hacer clic sobre el bot&oacute;n "Comprobar".
                 Se le mostrarán los detalles del pedido que realiz&oacute en su d&iacute;a.
        </UL>          
        <br><br>        
    <LI> <b>Comprar libro/s:</b>
        <UL>
            <LI> Para que un usuario pueda realizar una compra debe estar previamente registrado en el
                 sistema.
            <LI> El mecanismo de compra es el del carrito de la compra. Primero se elige todo lo que
                 se quiere comprar y luego se hace clic en el bot&oacute;n "Comprar". El sistema realizará
                 un albar&aacute;n que guardar&aacute; en su base de datos.
            <LI> Todo pedido tiene que llevar una forma de pago consigo: contrareembolso o tarjeta de crédito.<br>
                 En el caso de pagar con tarjeta de crédito, hay que introducir 16 d&iacute;gitos
                 correctamente para que el sistema pueda tramitar el pedido.
        </UL>   
     <LI> <b>Ver carrito de la compra:</b>
        <UL>
            <LI> Para que un usuario pueda ver su carrito de la compra actual.
        </UL>          
        <br><br>        
  </OL>
  
  <br><br><br>
  <center>
  <%-- Volver a la pantalla inicial de la aplicación --%>
  <form action="/GestionLibros/SvLibros" method=post>
    <input type="submit" name="boton" 
         value="Inicio">&nbsp;&nbsp;&nbsp;&nbsp;  
  </form>
  </center>
</body>
</html>

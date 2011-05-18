<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%-- página JSP Bienvenida.jsp --%>
<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Librería Virtual</title>
        <meta http-equiv="Content-Type" content="text/html; utf-8">
        <meta name="autor"        Content="Jose Angel Bonfil">
        <meta name="copyright"    Content="(c) 2010">
    </head>

    <body bgcolor="#FFFFFF">
        <center>
            <h1><font face="Verdana,Helvetica"><b>BUSQUEDA DE LIBROS</b></font></h1>

            <%-- Mostrar el formulario --%>
            <form action="/GestionLibros/SvLibros" method=post>
                <font face="Verdana,Helvetica" size="2"><b>Busqueda por:</b></font>&nbsp;&nbsp;&nbsp;&nbsp;
                <%-- Lista desplegable --%>
                <select size="1" name='opcion'>
                    <option value="1">Título del libro</option>
                    <option value="2">Autor del libro</option>
                    <option value="3">Editorial del libro</option>
                    <option value="4">Categoría del libro</option>
                    <option selected value="5">Todos los libros disponibles</option>
                </select><br><br><br>
                <font face="Verdana,Helvetica" size="2"><b>Buscar:</b></font>&nbsp;&nbsp;&nbsp;&nbsp;
                <input type='text' name='busqueda' size='60'>

                <br><br><input type="submit" name='boton' value='Buscar'>&nbsp;&nbsp;
                <input type="reset">&nbsp;&nbsp;
                <input type="submit" name='boton' value='Ayuda'>
                <br>
                <br>
                <table bgColor="#6A63F3" border=0 cellPadding=0 cellspacing=4 width=425 nowrap>
                    <tbody><tr><td noWrap width=250>
                                <table width=425 nowrap>
                                    <tbody><tr><td><br></td></tr>
                                        <tr><td>
                                                <font face="Verdana,Helvetica" size="2" color="#FFFFFF">
                                                    <b>Si aún no eres cliente nuestro, REGÍSTRATE:</b>&nbsp;&nbsp;&nbsp;&nbsp;</font>
                                            </td><td><input align=right type='submit' name='boton' value='Registro'></td></tr>
                                        <tr><td><br>
                                                <font face="Verdana,Helvetica" size="2" color="#FFFFFF">
                                                    <b>Historial de Pedidos (*):</b>
                                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font>
                                            </td><td><input align=right type='submit' name='boton' value='Historial'></td></tr>
                                    <table cellspacing=0 cellpadding=0 border=0 align=right>
                                        <tr><td>
                                                <font face="Verdana,Helvetica" size="1" color="#FFFFFF">
                                                    <b>Usuario&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></b>
                                                <input type="text" name="usuario" size="10">
                                            </td></tr>
                                        <tr><td>
                                                <font face="Verdana,Helvetica" size="1" color="#FFFFFF">
                                                    <b>Contraseña&nbsp;</font></b>
                                                <input type="password" name="pwd" size="10">
                                            </td></tr>
                                    </table>
                                    <tr><td><br><font face="Verdana,Helvetica" size="1" color="#FFFFFF">
                                                <b>(*)</b> Debes estar dado de alta en el registro de clientes</font><br>
                                        </td></tr>
                    </tbody>
                </table>
                </td></tr></tbody>
                </table>
            </form>

        </center>
    </body>
</html>

package com.javi.acme.controlador;

import java.io.IOException;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.javi.acme.formulario.BaseDatosForm;
import com.javi.acme.formulario.UsuarioForm;
import com.javi.acme.servicios.UsuarioService;
import com.javi.acme.servicios.UsuarioServiceImpl;
import com.javi.acme.util.archivo_bd;


@SessionAttributes("basedatos")
@Controller
public class UsuarioController {
	 private UsuarioService usuarioService = new UsuarioServiceImpl();
	    static UsuarioForm usuarioForm = new UsuarioForm();
	 private int sistemaausar=0;
		    	   
	    @RequestMapping(value = "/inicializarLogin.html", method = RequestMethod.POST)
	    public ModelAndView inicializarUsuario(@ModelAttribute("BaseDatosForm") BaseDatosForm baseDatosForm)
	    {	
	    	ModelAndView modelAndView = new ModelAndView("login" , "usuarioForm", new UsuarioForm());
	    
	    	System.out.println(baseDatosForm.getBasededatos());
	    	sistemaausar = baseDatosForm.getBasededatos();
	    	modelAndView.addObject("basedatos",baseDatosForm);
	        System.out.println("Si hemos llegado aqui quiere decir que la pagina index.jsp ha invocado a este controlador por el request /inicializarLogin.html y requiere el inicializarUsuario View");
	        return modelAndView;
	    }
	    @RequestMapping(value= "/seleccionarBD.htm",method=RequestMethod.GET)
	    public ModelAndView inicializarBaseDatos()
	    {
	    	return new ModelAndView("sel_bd","baseDatosForm",new BaseDatosForm()); 
	    
	    }
	    
	 
	    @RequestMapping(value = "/verificarLogin.html", method = RequestMethod.POST)
	    public ModelAndView verificarUsuario(@ModelAttribute("usuarioForm") UsuarioForm usuarioForm,@ModelAttribute("basedatos") BaseDatosForm baseDatosForm) throws IOException 
	    {
	        boolean existe = false;
	        System.out.println("Si hemos llegado aqui quiere decir que la pagina login.jsp ha invocado a este controlador por el request /verificarLogin.html y requiere el verificarUsuario View");
	        new archivo_bd().c_archivo_bd(sistemaausar);
	        existe = usuarioService.buscarUsuario(usuarioForm);
	 
	        if("".equals(usuarioForm.getUsuario())&&"".equals(usuarioForm.getPassword())){
	            System.out.println("Cargaremos por primera vez la pagina de login con el mensaje vacio");
	            return new ModelAndView("login" , "mensaje", "Debe de llenar los campos de Usuario y Clave");
	        }
	        else if(existe){
	        	
	            System.out.println("Se coloco al usuario y clave correctamente y va a la pagina de agregarComponentes");	 
	                      
	            return new ModelAndView("redirect:menu.acme");
	        }
	        else{
	            System.out.println("Se coloco al usuario y clave incorrectamente y regresamos a la pagina de login con el mensaje de Usuario Incorrecto");
	            return new ModelAndView("login" , "mensaje", "Usuario Incorrecto");
	        }
	    }
	    
	 
}

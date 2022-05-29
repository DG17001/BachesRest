/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package occ.ues.edu.sv.baches.resources;

import java.io.StringReader;
import java.net.URL;
import java.util.Date;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import occ.ues.edu.sv.baches.JAXRSConfiguration;
import occ.ues.edu.sv.baches.control.AbstractDataAccess;
import occ.ues.edu.sv.baches.control.ObjetoEstadoBean;
import occ.ues.edu.sv.baches.entity.ObjetoEstado;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit5.ArquillianExtension;
import org.jboss.arquillian.test.api.ArquillianResource;    
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 *
 * @author magdiel
 */
@ExtendWith(ArquillianExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ObjetoEstadoResourceIT {
    
    @Deployment
    public static WebArchive crearDespliegue() {
        WebArchive salida = ShrinkWrap.create(WebArchive.class)
                .addPackage("occ.ues.edu.sv.baches.entity")
                .addAsResource("persistence-arquillian.xml")
                .addClass(AbstractDataAccess.class)
                .addClass(ObjetoEstadoBean.class)
                .addClass(JAXRSConfiguration.class)
                .addClass(ObjetoEstadoResource.class)
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsResource("META-INF/sql/datos.sql", "META-INF/sql/datos.sql")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
        System.out.println(salida.toString(true));
        return salida;
    }
    
    
    @ArquillianResource
    URL url;

    @Test
    @RunAsClient
    @Order(1)
    public void testCrear() {
        System.out.println("Crear ObjetoEstado");
        ObjetoEstado nuevo = new ObjetoEstado();
        nuevo.setActual(true);
        nuevo.setFechaAlcanzado(new Date());
        int resultadoEsperado = 200;
        Client cliente = ClientBuilder.newClient();
        WebTarget target = cliente.target(url.toString() + "resources/");
        //Response respuesta = target.path("objetoestado").request("application/json").post(Entity.entity(nuevo, MediaType.APPLICATION_JSON));
        //Assertions.assertEquals(resultadoEsperado, respuesta.getStatus());
        //String registro = respuesta.getHeaderString("El registro se ha creado");
        //Assertions.assertNotEquals(null, registro);
        //String cuerpoString = respuesta.readEntity(String.class);
        //JsonReader lector = Json.createReader(new StringReader(cuerpoString));
        //JsonObject objeto = lector.readObject();
        System.out.println("\n");
        //System.out.println("Creado " + objeto);
        System.out.println("\n");
    }

    @Test
    @RunAsClient
    @Order(2)
    public void testModificar() {
        System.out.println("Modificando ObjetoEstado");
        ObjetoEstado edit = new ObjetoEstado();
        edit.setActual(false);
        edit.setFechaAlcanzado(new Date());
        int resultadoEsperado = 200;
        Client cliente = ClientBuilder.newClient();
        WebTarget target = cliente.target(url.toString() + "resources/");
        //Response respuesta = target.path("objetoestado").request("application/json").put(Entity.entity(edit, MediaType.APPLICATION_JSON));
        //Assertions.assertEquals(resultadoEsperado, respuesta.getStatus());
        //String registro = respuesta.getHeaderString("Modificado");
        //Assertions.assertNotEquals(null, registro);
        //String cuerpoString = respuesta.readEntity(String.class);
        //JsonReader lector = Json.createReader(new StringReader(cuerpoString));
        //JsonObject objeto = lector.readObject();
        System.out.println("\n");
        //System.out.println("Modificado " + objeto);
        System.out.println("\n");

    }

    @Test
    @RunAsClient
    @Order(3)
    public void testEliminar() {
        System.out.println("Eliminar ObjetoEstado");
        ObjetoEstado delete = new ObjetoEstado();        
        int resultadoEsperado = 200;
        Client cliente = ClientBuilder.newClient();
        WebTarget target = cliente.target(url.toString() + "resources/");
        //Response respuesta = target.path("objetoestado/3").request("application/json").delete();
        //Assertions.assertEquals(resultadoEsperado, respuesta.getStatus());
        //String registro = respuesta.getHeaderString("ID-eliminado");
        //Assertions.assertNotEquals(null, registro);
        //String cuerpoString = respuesta.readEntity(String.class);
        //JsonReader lector = Json.createReader(new StringReader(cuerpoString));
        //JsonObject objeto = lector.readObject();

        System.out.println("\n");
        //System.out.println("ID:" + objeto.getInt("idObjetoEstado") + " eliminado con exito");
        System.out.println("\n");
    }
    
    @Test
    @RunAsClient
    @Order(4)
    public void testFindAll(){
        System.out.println("\n");
        System.out.println("--------------------------------------------------------------");
        System.out.println("findAllObjetoEstado");
        int resultadoEsperado=200;
        Client cliente=ClientBuilder.newClient();
        WebTarget target= cliente.target(url.toString()+"resources/");
        //Response respuesta = target.path("objetoestado").request("application/json").get(); 
        //Assertions.assertEquals(resultadoEsperado, respuesta.getStatus());
        //String totalTexto = respuesta.getHeaderString("Total-Registros");
        //Assertions.assertNotEquals(Integer.valueOf(0), Integer.valueOf(totalTexto));
        //System.out.println("Total: "+totalTexto);
        //String cuerpoString = respuesta.readEntity(String.class);
        //JsonReader lector = Json.createReader(new StringReader(cuerpoString));
        //JsonArray listaJson = lector.readArray();
        //int totalRegistros = listaJson.size();
        //Assertions.assertTrue(totalRegistros>0);
        System.out.println("\n");
        //for(int i=0; i< listaJson.size(); i++)
        {
            //JsonObject objeto = listaJson.getJsonObject(i);
            //System.out.println("ID: " + objeto.getInt("idObjetoEstado"));
        }
        System.out.println("\n");
    }
    
}
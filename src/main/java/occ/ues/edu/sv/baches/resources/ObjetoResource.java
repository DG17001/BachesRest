/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package occ.ues.edu.sv.baches.resources;

import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import occ.ues.edu.sv.baches.control.ObjetoBean;
import occ.ues.edu.sv.baches.entity.Objeto;

/**
 *
 * @author magdiel
 */
@Stateless
@Path("objeto")
public class ObjetoResource {
    
    @Inject
    ObjetoBean toBean;
   

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response findAll() {
        List<Objeto> registros = toBean.findAll();
        Long total = toBean.contar();

        return Response.ok(registros)
                .header("Total-Registro", total)
                .build();
    }
    
    @GET
    @Path("findRange/{first}/{pagesize}")
    @Produces({MediaType.APPLICATION_JSON})    
    public Response findRange(@PathParam("first") Integer first, @PathParam("pagesize") Integer pagesize) {
        List<Objeto> registros = toBean.findRange(first, pagesize);
        return Response.ok(registros)
                .build();
    }   
    
    @GET
    @Path("findByName/{name}")
    public Response findNByName(@PathParam("name") String nombre){
        List<Objeto> lista;
        lista=toBean.findByName(nombre);
        return Response.ok(lista).build();
    }
    
    @GET
    @Path("findById/{id}")
    @Produces({MediaType.APPLICATION_JSON})    
    public Objeto findById(@PathParam("id") Long id) {
        return toBean.findById(id);
    }
    
    @GET
    @Path("contar")
    @Produces(MediaType.TEXT_PLAIN)
    public String contar() {
        return String.valueOf(toBean.contar());
    }
    
    @POST
    @Path("crear/{nombre}/{latitud}/{longitud}")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response crear(@PathParam("nombre") String nombre,@PathParam("latitud") BigDecimal latitud,@PathParam("latitud") BigDecimal longitud) {
        Objeto nuevo=new Objeto();
        nuevo.setNombre(nombre);
        nuevo.setLatitud(latitud);
        nuevo.setLongitud(longitud);
        toBean.crear(nuevo);
        
        return Response.ok(nuevo).build();
    }
    
    @PUT
    @Path("modificar/{id}/{latitud}/{longitud}/{nombre}")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response modificar(@PathParam("id") Long id, @PathParam("latitud") BigDecimal latitud,@PathParam("longitud") BigDecimal longitud,@PathParam("nombre") String nombre) {
        Objeto update=new Objeto();
        update.setIdObjeto(id);
        update.setLatitud(latitud);
        update.setLongitud(longitud);
        update.setNombre(nombre);
        toBean.modificar(update);
        
        return Response.ok(update).build();
    }
    
    @PUT
    @Path("eliminar/{id}")
    @Consumes({MediaType.TEXT_PLAIN})
    public Response eliminar(@PathParam("id") Long id){
        toBean.eliminar(toBean.findById(id));
        return Response.ok().build();
    }
}

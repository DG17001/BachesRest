/*  
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package occ.ues.edu.sv.baches.resources;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import occ.ues.edu.sv.baches.control.EstadoBean;
import occ.ues.edu.sv.baches.entity.Estado;

/**
 *
 * @author magdiel
 */
@Stateless
@Path("estado")
public class EstadoResource {
    
    @Inject
    EstadoBean toBean;
   

    @GET
    @Produces({MediaType.APPLICATION_JSON})    
    public Response findAll() {
        List<Estado> registros = toBean.findAll();
        Long total = toBean.contar();

        return Response.ok(registros)
                .header("Total-Registro", total)
                .build();
    }   
    
    @GET
    @Path("findByName/{name}")
    public Response findByName(@PathParam("name") String nombre){
        List<Estado> lista;
        lista=toBean.findByName(nombre);
        lista.stream().forEach(u -> u.setNombre(u.getNombre().toUpperCase()));
        return Response.ok(lista).build();
    }
    
    @GET
    @Path("findRange/{first}/{pagesize}")
    @Produces({MediaType.APPLICATION_JSON})    
    public Response findRange(@PathParam("first") Integer first, @PathParam("pagesize") Integer pagesize) {
        List<Estado> registros = toBean.findRange(first, pagesize);
        return Response.ok(registros)
                .build();
    }   
    
    @GET
    @Path("findById/{id}")
    @Produces({MediaType.APPLICATION_JSON})    
    public Estado findById(@PathParam("id") Integer id) {
        return toBean.findById(id);
    }
    
    @GET
    @Path("contar")
    @Produces(MediaType.TEXT_PLAIN)
    public String contar() {
        return String.valueOf(toBean.contar());
    }
    
    @POST   
    @Path("crear/{nombre}")
    @Consumes({MediaType.TEXT_PLAIN})
    @Produces({MediaType.APPLICATION_JSON})
    public Response crear(@PathParam("nombre") String nombre) {
        Estado nuevo=new Estado();
        nuevo.setIdEstado(Integer.SIZE);
        nuevo.setNombre(nombre);
        nuevo.setFechaCreacion(new Date());
        toBean.crear(nuevo);
        
        return Response.ok(nuevo).build();
    }
       
    @PUT
    @Path("modificar/{id}/{nombre}")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response modificar(@PathParam("id") Integer id,@PathParam("nombre") String name) {
        Estado update=new Estado();
        update.setIdEstado(id);
        update.setNombre(name);
        update.setFechaCreacion(new Date());
        toBean.modificar(update);
        
        return Response.ok(update).build();
    }
    
    @DELETE
    @Path("eliminar/{id}")
    @Consumes({MediaType.TEXT_PLAIN})
    public Response eliminar(@PathParam("id") Integer id){
        toBean.eliminar(toBean.findById(id));
        return Response.ok().build();
    }
}
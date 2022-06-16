/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package occ.ues.edu.sv.baches.resources;

import java.io.Serializable;
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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import occ.ues.edu.sv.baches.control.ObjetoEstadoBean;
import occ.ues.edu.sv.baches.entity.ObjetoEstado;

/**
 *
 * @author magdiel
 */
@Stateless
@Path("objetoestado")
public class ObjetoEstadoResource implements Serializable{
    @Inject
    ObjetoEstadoBean toBean;
   

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response findAll() {
        List<ObjetoEstado> registros = toBean.findAll();
        Long total = toBean.contar();

        return Response.ok(registros)
                .header("Total-Registro", total)
                .build();
    }
    
    
    @GET
    @Path("findRange/{first}/{pagesize}")
    @Produces({MediaType.APPLICATION_JSON})    
    public Response findRange(@PathParam("first") Integer first, @PathParam("pagesize") Integer pagesize) {
        List<ObjetoEstado> registros = toBean.findRange(first, pagesize);
        return Response.ok(registros)
                .build();
    }   
    
    @GET
    @Path("findById/{id}")
    @Produces({MediaType.APPLICATION_JSON})    
    public ObjetoEstado findById(@PathParam("id") Long id) {
        return toBean.findById(id);
    }
    
    @GET
    @Path("contar")
    @Produces(MediaType.TEXT_PLAIN)
    public String contar() {
        return String.valueOf(toBean.contar());
    }
    
    @POST
    @Path("crear")
    public Response crear(@QueryParam(value="actual") Boolean actual,@QueryParam(value="observacion") String observacion) {
        ObjetoEstado nuevo=new ObjetoEstado();
        nuevo.setActual(actual);
        nuevo.setFechaAlcanzado(new Date());
        nuevo.setObservaciones(observacion);
        toBean.crear(nuevo);
        
        return Response.ok(nuevo).build();
    }
    
    @PUT
    @Path("modificar")
    public Response modificar(@QueryParam(value="id") Long id,@QueryParam(value="actual") boolean actual, @QueryParam(value="observacion") String observacion) {
        ObjetoEstado update=new ObjetoEstado();
        update.setIdObjetoEstado(id);
        update.setFechaAlcanzado(new Date());
        update.setActual(actual);
        update.setObservaciones(observacion);
        toBean.modificar(update);
        
        return Response.ok(update).build();
    }
    
    @DELETE
    @Path("eliminar/{id}")
    public Response eliminar(@PathParam("id") Long id){
        toBean.eliminar(toBean.findById(id));
        return Response.ok().build();
    }
}

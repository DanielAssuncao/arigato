package br.com.assuncao.arigato.presentation.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.assuncao.arigato.business.service.ICrudService;
import br.com.assuncao.arigato.exceptions.GeneralException;
import br.com.assuncao.arigato.util.ApplicationConstant;

public abstract class CrudBaseController<T, I, F, S extends ICrudService<T, I, F>> {
    
    private static final String BASE_URL = ApplicationConstant.BASE_URL;
    
    protected static final String PAGE_LISTA = "/";
    protected static final String PAGE_FORM_EDIT = "/edit";
    protected static final String PAGE_FORM_CREATE = "/create";
    protected static final String PAGE_FORM_DETAIL = "/detail";
    protected static final String ENTITY = "entity";
    protected static final String FILTER = "filter";
    
    protected S service;
    
    private String rootContext;
    
    public CrudBaseController(String rootContext, S s) {
        this.rootContext = rootContext;
        this.service = s;
    }
    
    @RequestMapping(value = "/list", method=RequestMethod.GET)
    protected List<T> getAll(@ModelAttribute(FILTER) F filter) {
                
        List<T> listFound = fillList(filter);
        
        prepareListForm(service);
        
        return listFound;
    }
    
    @RequestMapping(value = "/list", method=RequestMethod.POST, 
    				consumes=MediaType.APPLICATION_JSON_VALUE)
    protected List<T> filter(@RequestBody F filter) {       
    	
    	prepareListForm(service);
        
        return this.getAll(filter);
    }
    
    @RequestMapping(value = "/create", method=RequestMethod.GET)
    protected void create() {
                
        prepareCreateForm(service);
    }
    
    @RequestMapping(value = "/save", method=RequestMethod.POST)
    protected void salvar(@ModelAttribute(ENTITY) T t, @ModelAttribute(FILTER) F filter) {
        try {
            service.save(t);
        } catch (GeneralException e) {
        	//Enviar URL_BASE para o front e redirecionar para a p�gina NOVO
        }
        
      //Enviar URL_BASE para o front e redirecionar para a p�gina LISTA
    }
    
    @RequestMapping(value = "/edit", method=RequestMethod.POST)
    protected T edit(@RequestBody I i) {
    
        T entity = service.findOne(i);
        
        prepareEditForm(service);
        
        return entity;
    }
    
    @RequestMapping(value = "/update", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
    protected ResponseEntity<String> update(@RequestBody T customerRegistration){
        try {
        	service.save(customerRegistration);
        } catch (GeneralException e) {
        	return new ResponseEntity<String>("Error: "+ e.getMessage(), HttpStatus.OK);
        }
        
        return new ResponseEntity<String>("Registration successfully saved!", HttpStatus.OK);
    }
    
    @RequestMapping(value = "/delete", method=RequestMethod.GET)
    protected ResponseEntity<Void> delete(@RequestParam(name="id") I i) {
        service.delete(i);
        
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @RequestMapping(value = "/detail", method=RequestMethod.GET)
    protected ResponseEntity<T> detail(@RequestParam(name="id") I i) {
    	
    	T entity = service.findOne(i);
    	prepareDetail (entity, service);   
    	
    	// Enviar URL_BASE para o front e redirecionar para a p�gina LISTA
    	return ResponseEntity.ok().body(entity);
    }

    protected void prepareDetail(T entity, S service) {
    	//sobrescrever caso precise preparar dados para a tela de detalhe
	}

	protected void prepareCreateForm(S service) {
        //sobrescrever caso precise preparar dados para a tela de inclus�o
    }
    
    protected void prepareEditForm(S service) {
        //sobrescrever caso precise preparar dados para a tela de edi��o
    }
    
    protected void prepareListForm(S service) {
     	//sobrescrever caso precise preparar dados para a tela de lista
    }

    protected void fillList() {
        fillList(null);
    }

    private List<T> fillList(F filter) {
        return service.findAll(filter);
    }

    protected String getPathPages() {
        return this.rootContext.replace(".do", "");
    }
}

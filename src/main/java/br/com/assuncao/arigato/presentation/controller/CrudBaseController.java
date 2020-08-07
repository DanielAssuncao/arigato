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

import br.com.assuncao.arigato.business.service.ICrudService;
import br.com.assuncao.arigato.exceptions.GeneralException;
import br.com.assuncao.arigato.util.ApplicationConstant;

public abstract class CrudBaseController<T, I, F, S extends ICrudService<T, I, F>> {
    
    private static final String URL_BASE = ApplicationConstant.URL_BASE;
    
    protected static final String PAGE_LISTA = "/";
    protected static final String PAGE_FORM_EDITAR = "/editar";
    protected static final String PAGE_FORM_NOVO = "/novo";
    protected static final String PAGE_FORM_DETALHE = "/detalhe";
    protected static final String ENTITY = "entity";
    protected static final String FILTER = "filter";
    
    protected S service;
    
    private String contextoRaiz;
    
    public CrudBaseController(String contextoRaiz, S s) {
        this.contextoRaiz = contextoRaiz;
        this.service = s;
    }
    
    @RequestMapping(value = "/lista", method=RequestMethod.GET)
    protected List<T> getAll(@ModelAttribute(FILTER) F filter) {
                
        List<T> listaBuscada = preencherLista(filter);
        
        prepararFormLista(service);
        
        //Enviar URL_BASE para o front
        
        return listaBuscada;
    }
    
    @RequestMapping(value = "/lista", method=RequestMethod.POST, 
    				consumes=MediaType.APPLICATION_JSON_VALUE)
    protected List<T> filtro(@RequestBody F filter) {       
    	
    	prepararFormLista(service);
    	
    	//Enviar URL_BASE para o front
        
        return this.getAll(filter);
    }
    
    @RequestMapping(value = "/novo", method=RequestMethod.GET)
    protected void novo() {
                
        prepararFormNovo(service);
        
      //Enviar URL_BASE para o front
    }
    
    @RequestMapping(value = "/salvar", method=RequestMethod.POST)
    protected void salvar(@ModelAttribute(ENTITY) T t, @ModelAttribute(FILTER) F filter) {
        try {
            service.save(t);
        } catch (GeneralException e) {
        	//Enviar URL_BASE para o front e redirecionar para a página NOVO
        }
        
      //Enviar URL_BASE para o front e redirecionar para a página LISTA
    }
    
    @RequestMapping(value = "/editar", method=RequestMethod.POST)
    protected T editar(@RequestBody I i) {
    
        T entidade = service.findOne(i);
        
        prepararFormEditar(service);
        
        //Enviar URL_BASE para o front
        
        return entidade;
    }
    
    @RequestMapping(value = "/atualizar", method=RequestMethod.POST)
    protected void atualizar(@ModelAttribute(ENTITY) T t){
    	        
        try {
            service.save(t);
        } catch (GeneralException e) {
        	//Enviar URL_BASE para o front e redirecionar para a página NOVO
        }
        
      //Enviar URL_BASE para o front e redirecionar para a página LISTA
    }
    
    @RequestMapping(value = "/deletar", method=RequestMethod.GET)
    protected ResponseEntity<Void> deletar(@RequestParam(name="id") I i) {
        service.delete(i);
        
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @RequestMapping(value = "/detalhar", method=RequestMethod.GET)
    protected ResponseEntity<T> detalhar(@RequestParam(name="id") I i) {
    	
    	T entidade = service.findOne(i);
    	prepararDetalhe (entidade, service);   
    	
    	// Enviar URL_BASE para o front e redirecionar para a página LISTA
    	return ResponseEntity.ok().body(entidade);
    }

    protected void prepararDetalhe(T entity, S service) {
    	//sobrescrever caso precise preparar dados para a tela de detalhe
	}

	protected void prepararFormNovo(S service) {
        //sobrescrever caso precise preparar dados para a tela de inclusão
    }
    
    protected void prepararFormEditar(S service) {
        //sobrescrever caso precise preparar dados para a tela de edição
    }
    
    protected void prepararFormLista(S service) {
     	//sobrescrever caso precise preparar dados para a tela de lista
    }

    protected void preencherLista() {
        preencherLista(null);
    }

    private List<T> preencherLista(F filter) {
        return service.findAll(filter);
    }

    protected String getPathPaginas() {
        return this.contextoRaiz.replace(".do", "");
    }
}

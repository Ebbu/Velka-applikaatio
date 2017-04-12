package com.velka.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.velka.domain.Velka;
import com.velka.domain.VelkaRepository;


@Controller
public class VelkaController {

	@Autowired
	private VelkaRepository repository; 
	
    //Etusivu velkalistalla 
    @RequestMapping(value="/")
    public String velkaList2(Model model) {	
        model.addAttribute("velat", repository.findAll());
        return "velkalista";
    }

	
	//Login sivusto
    @RequestMapping(value="/login")
    public String login() {	
        return "login"; 
    }	
    
    //Hakee kaikki velat.
    @RequestMapping(value="/velkalista")
    public String velkaList(Model model) {	
        model.addAttribute("velka", repository.findAll());
        return "velkalista";
    }
    
    //Tallennetaan uusi velka
    @RequestMapping(value = "/add")
    public String addVelka(Model model){
    	model.addAttribute("velka", new Velka());
        return "lisaavelka";
    } 
    
    //Poistetaan velka ID:n perusteella, joka tulee urlin mukana.
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteVelka(@PathVariable("id") Long Id, Model model) {
    	repository.delete(Id);
        return "redirect:../velkalista";
    }   

    
    //Tallennetaan velka
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Velka velka){
        repository.save(velka);
        return "redirect:velkalista";
    }        
    
    //Haetaan kaikki velat repositorystä.
    @RequestMapping(value="/velat", method = RequestMethod.GET)
    public @ResponseBody List<Velka> velkaListRest() {	
        return (List<Velka>) repository.findAll();
    }    
    
	// Hae kirja ID:n perusteella, joka lähetetään osoiterivin kautta.
    @RequestMapping(value="/velka/{id}", method = RequestMethod.GET)
    public @ResponseBody Velka findVelkaRest(@PathVariable("id") Long Id) {	
    	return repository.findOne(Id);
    }    


}

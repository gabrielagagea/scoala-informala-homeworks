package com.si.controller;

import com.si.model.Client;
import com.si.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/clients")
public class ClientsController {
    @Autowired
    private ClientRepository clientRepository;

    public ClientsController() {
    }

    @RequestMapping(
            method = RequestMethod.GET
    )
    public String list(Model model, HttpServletRequest request) {
        List<Client> clients = (List<Client>) clientRepository.findAll();
        model.addAttribute("clients", clients);
        System.out.println("====== clients: " + clients);
        return "clients";
    }
    public String update(Model model, HttpServletRequest request) {
        Client client = new Client(1L, "Olesea", "Solodcov", "olesea_solodcov@yahoo.com" );
        List<Client> clients = (List<Client>) clientRepository.save(client);
        model.addAttribute("clients", clients);
        System.out.println("====== clients: " + clients);
        return "clients";
    }
}

